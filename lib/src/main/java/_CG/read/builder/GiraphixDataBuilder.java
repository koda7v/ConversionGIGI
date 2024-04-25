package _CG.read.builder;

import _CG.bean.DacssiType;
import _CG.bean.EntrepriseType;
import _CG.bean.GiraphixDatas;
import _CG.bean.HabilitationType;
import _CG.bean.ObjectFactory;
import _CG.bean.PersonneType;
import _CG.comparator.PersonneComparator;

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

	/**
	 * Constructeur.
	 * 
	 * @param fabrique Fabrique permettant d'initialiser les entités de
	 *                 l'application GIRAPHIX.
	 */
	public GiraphixDataBuilder(ObjectFactory fabrique) {
		super(fabrique);

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
		// Affectation des données
		mDatas.setPersonnes(mPersonnes);
		mDatas.setHabilitations(mHabilitations);
		mDatas.setEntreprises(mEntreprise);
		mDatas.setDacssiList(mDacsii);

		return mDatas;
	}
	
	/**
	 * Vérifie si la personne est déjà enregistré. Si c'est le cas on renvoie l'ID
	 * de la personne déjà enregistré. Sinon on renvoie l'ID de la personne donnée
	 * en paramère.
	 * 
	 * @return ID de la personne.
	 */
	public String verifiesPresenceOfPersonneAndGetGoodID(PersonneType personne) {
		// Vérification de la présence d'une personne 
		// Vérification qu'aucun personne de ce type n'est présente dans les données
		PersonneComparator comparator = new PersonneComparator();
		PersonneType goodPersonne = this.mPersonnes.getPersonne()
				.stream()
				.filter(p -> comparator.compare(p, personne) == 0)
				.findAny()
				.orElse(personne);

		return goodPersonne.getId();
	}

}
