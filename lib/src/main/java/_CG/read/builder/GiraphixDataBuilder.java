package _CG.read.builder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import _CG.bean.DacssiType;
import _CG.bean.EntrepriseType;
import _CG.bean.GiraphixDatas;
import _CG.bean.HabilitationType;
import _CG.bean.MotifType;
import _CG.bean.ObjectFactory;
import _CG.bean.PersonneType;
import _CG.comparator.HabilitationDescendingComparator;
import _CG.tools.ApplicationLoader;

/**
 * Builder permettant la création des entités de haut niveau de l'application de
 * GIRAPHIX.
 */
public class GiraphixDataBuilder extends ABuilder implements IBuilder {

	/** Liste des personnes récupérer. */
	protected GiraphixDatas.Personnes mPersonnes;
	/** Liste des habilitations récupérer. */
	protected GiraphixDatas.Habilitations mHabilitations;
	/** Liste des entreprise récupérer. */
	protected GiraphixDatas.Entreprises mEntreprise;
	/** Liste des DACSII récupérer. */
	protected GiraphixDatas.DacssiList mDacsii;
	/** Donnée importer. */
	protected GiraphixDatas mDatas;
	/** Liste d'habilitations par personne(ID). */
	protected Map<String, List<HabilitationType>> mHabilitationByPersonne;

	/**
	 * Constructeur.
	 * 
	 * @param fabrique Fabrique permettant d'initialiser les entités de
	 *                 l'application GIRAPHIX.
	 */
	public GiraphixDataBuilder(ObjectFactory fabrique) {
		super(fabrique);

		this.mHabilitationByPersonne = new HashMap<String, List<HabilitationType>>();
		this.mDatas = mFabrique.createGiraphixDatas();
		this.reset();
	}

	@Override
	public void reset() {
		this.mPersonnes = mFabrique.createGiraphixDatasPersonnes();
		this.mHabilitations = mFabrique.createGiraphixDatasHabilitations();
		this.mEntreprise = mFabrique.createGiraphixDatasEntreprises();
		this.mDacsii = mFabrique.createGiraphixDatasDacssiList();
	}

	/**
	 * Ajout d'une personne dans les données prévue pour GIRAPHIX.
	 * 
	 * @param personne {@link PersonneType} à ajouter.
	 */
	public void addPersonne(PersonneType personne) {
		this.mPersonnes.getPersonne().add(personne);
	}

	/**
	 * Ajout d'une habilitation dans les données prévue pour GIRAPHIX.
	 * 
	 * @param habilitation {@link HabilitationType} à ajouter.
	 */
	public void addHabilitation(HabilitationType habilitation) {
		String idPersonne = habilitation.getIdPersonne();
		if (mHabilitationByPersonne.containsKey(idPersonne)) {
			List<HabilitationType> list = mHabilitationByPersonne.get(idPersonne);
			list.add(habilitation);
		} else {
			List<HabilitationType> habilitationTypes = new ArrayList<HabilitationType>();
			habilitationTypes.add(habilitation);
			mHabilitationByPersonne.put(idPersonne, habilitationTypes);
		}

		this.mHabilitations.getHabilitation().add(habilitation);
	}

	/**
	 * Ajout d'une entreprise dans les données prévue pour GIRAPHIX.
	 * 
	 * @param entreprise {@link EntrepriseType} à ajouter.
	 */
	public void addEntreprise(EntrepriseType entreprise) {
		this.mEntreprise.getEntreprise().add(entreprise);
	}

	/**
	 * Ajout d'un DACSII dans les données prévue pour GIRAPHIX.
	 * 
	 * @param dacsii {@link DacssiType} à ajouter.
	 */
	public void addDacsii(DacssiType dacsii) {
		this.mDacsii.getDACSSI().add(dacsii);
	}

	/**
	 * @return {@link GiraphixDatas}, l'ensemble des données prévue pour
	 *         l'application GIRAPHIX.
	 */
	public GiraphixDatas getResult() {
		updateHabilitationsMotif();

		// Affectation des données
		mDatas.setPersonnes(mPersonnes);
		mDatas.setHabilitations(mHabilitations);
		mDatas.setEntreprises(mEntreprise);
		mDatas.setDacssiList(mDacsii);

		// Mise à jour de la version
		mDatas.setModelVersion(ApplicationLoader.getInstance().getText("giraphix.version"));

		return mDatas;
	}
	
	/**
	 * Modification du motif des habilitations pour une même persoone.
	 */
	protected void updateHabilitationsMotif() {
		Comparator<HabilitationType> comparator = new HabilitationDescendingComparator();
		for (List<HabilitationType> habilitations : mHabilitationByPersonne.values()) {
			List<HabilitationType> habilitationSorted = habilitations.stream().filter(this::hasDateValidite)
					.sorted(comparator).collect(Collectors.toList());
			int size = habilitationSorted.size();
			if (size > 1) {
				for (int i = 0; i < habilitationSorted.size(); i++) {
					if ((i + 1) < size) {
						HabilitationType habilitationType = habilitationSorted.get(i);
						HabilitationType habilitationTypeNext = habilitationSorted.get(i + 1);
						if (habilitationType.getNiveau().equals(habilitationTypeNext.getNiveau())
								&& habilitationType.getNature().equals(habilitationTypeNext.getNature())) {
							habilitationTypeNext.setMotif(MotifType.RENOUVELLEMENT);
						}
					}
				}
			}
		}
	}

	/**
	 * Vérification de la présence de la date de validation.
	 * 
	 * @param habilitation Habilitation sur laquelle on travaille.
	 * @return True, si elle est présente.
	 */
	public boolean hasDateValidite(HabilitationType habilitation) {
		Long dateValidite = habilitation.getDateValidite();
		if (dateValidite != null) {
			return true;
		}
		return false;
	}

	/**
	 * Vérifie si la personne est déjà enregistré. Si c'est le cas on renvoie l'ID
	 * de la personne déjà enregistré. Sinon on renvoie l'ID de la personne donnée
	 * en paramère.
	 * 
	 * @return ID de la personne.
	 */
	public boolean checkPresenceOfOnePersonne(PersonneType personne, Comparator<PersonneType> comparator) {
		// Vérification de la présence d'une personne 
		// Vérification qu'aucun personne de ce type n'est présente dans les données
		Optional<PersonneType> goodPersonne = this.mPersonnes.getPersonne()
				.stream()
				.filter(p -> comparator.compare(p, personne) == 0)
				.findAny();

		return goodPersonne.isPresent();
	}

}
