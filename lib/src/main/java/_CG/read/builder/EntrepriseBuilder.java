package _CG.read.builder;

import java.util.HashMap;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;

import _CG.bean.EntrepriseType;
import _CG.bean.ObjectFactory;

/**
 * Constructeur de données pour {@link EntrepriseType}.
 */
public class EntrepriseBuilder extends ABuilder implements IBuilder {

	/** Collection des entreprises récupérer sous forme de map. */
	protected HashMap<String, EntrepriseType> mEntrepriseCreated;
	/** Entreprise courante en cours de création. */
	protected EntrepriseType mEntreprise;
	/** L'entreprise est-elle à ajouter ? */
	protected boolean isToAdded = false;

	/**
	 * Constructeur.
	 * 
	 * @param fabrique Fabrique permettant d'initialiser les entités de
	 *                 l'application GIRAPHIX.
	 */
	public EntrepriseBuilder(ObjectFactory fabrique) {
		super(fabrique);
		this.mEntrepriseCreated = new HashMap<String, EntrepriseType>();
	}

	@Override
	public void reset() {
		this.mEntreprise = mFabrique.createEntrepriseType();

		this.createBordeauxEntreprise();
	}

	/**
	 * Récupération des différentes données nécessaires à la création de
	 * l'entreprise en fonction de la colonne <b> Agence Rattachement </b>.
	 * 
	 * @param cell Cellule à gérer.
	 */
	public void setAgenceRattachement(HSSFCell cell) {
		// Sans information contraire chaque entreprise est à ajouter
		isToAdded = true;

		// Récupération de la valeur contenue par la cellule
		String cellValue = getStringFromCell(cell);

		// Crétion d'un identifiant pour l'entreprise
		String idEntreprise = UUID.randomUUID().toString();

		// Si aucune entreprise n'a été crée
		if (!mEntrepriseCreated.isEmpty()) {

			// Vérification que l'entreprise que l'on veut crée n'est pas déjà présente.
			for (EntrepriseType currentEntreprise : mEntrepriseCreated.values()) {
				if (cellValue.toLowerCase().indexOf(currentEntreprise.getLocalite().toLowerCase()) != -1) {
					isToAdded = false;
					mEntreprise = currentEntreprise;
				}
			}

			// Si elle n'est pas présente on l'ajoute, comme les pokémons
			if (isToAdded) {
				createEntreprise(cellValue, idEntreprise);
			}

		} else {
			createEntreprise(cellValue, idEntreprise);
		}
	}

	/**
	 * Création de l'entreprise de Bordeaux.
	 */
	protected void createBordeauxEntreprise() {
		String idEntreprise = UUID.randomUUID().toString();

		mEntreprise.setNom("Apside");
		mEntreprise.setLocalite("Bordeaux");
		mEntreprise.setAdresse("Immeuble Managers St Jean, 23 Quai de Paludate Bâtiment A");
		mEntreprise.setCodePostal("33800");
		mEntreprise.setCodeSE("");

		mEntrepriseCreated.put(idEntreprise, mEntreprise);
	}

	/**
	 * Création de l'entreprise.
	 * 
	 * @param cellValue    Cellule à vérifier.
	 * @param idEntreprise Identifiant de l'entreprise.
	 */
	protected void createEntreprise(String cellValue, String idEntreprise) {
		mEntreprise.setNom("Apside");
		mEntreprise.setLocalite("");
		mEntreprise.setAdresse("");
		mEntreprise.setCodePostal("");
		mEntreprise.setCodeSE("");

		mEntrepriseCreated.put(idEntreprise, mEntreprise);
	}

	/**
	 * @return Entreprise en cours de création.
	 */
	public EntrepriseType getEntreprise() {
		return this.mEntreprise;
	}

	/**
	 * @return Est-ce que l'entreprise est à ajouter.
	 */
	public boolean isEntrepriseToAdded() {
		return this.isToAdded;
	}

}
