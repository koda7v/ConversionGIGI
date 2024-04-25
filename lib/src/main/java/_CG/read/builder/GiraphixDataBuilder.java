package _CG.read.builder;

import _CG.bean.EntrepriseType;
import _CG.bean.GiraphixDatas;
import _CG.bean.HabilitationType;
import _CG.bean.ObjectFactory;
import _CG.bean.PersonneType;

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
	 * Ajout d'une habilitation dans les données prévue pour GIRAPHIX.
	 * 
	 * @param entreprise {@link EntrepriseType} à ajouter.
	 */
	public void addEntreprise(EntrepriseType entreprise) {
		this.mEntreprise.getEntreprise().add(entreprise);
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

		return mDatas;

	}

}
