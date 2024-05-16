package _CG.read.builder;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;

import _CG.bean.CiviliteType;
import _CG.bean.FonctionType;
import _CG.bean.NationalitesType;
import _CG.bean.ObjectFactory;
import _CG.bean.PersonneType;
import _CG.constant.ConstantEntreprise;
import _CG.exception.LineExcelException;
import _CG.tools.ApplicationLoader;
import _CG.tools.PersonneTools;

/**
 * Constructeur de données pour {@link PersonneType}.
 */
public class PersonneBuilder extends ABuilder implements IBuilder {

	/** Logger. */
	private static final Logger LOGGER = LogManager.getLogger(PersonneBuilder.class);
	/** Nationnalité francaise. */
	private static final String NATIONNALITE_FRANCAISE = "Française";
	/** Civilite monsieur. */
	private static final String CIVILITE_MONSIEUR = "Monsieur";
	/** Civilite madame. */
	private static final String CIVILITE_MADAME = "Madame";
	/** Personne en cours de construction. */
	protected PersonneType mPersonne;
	/** Liste des différentes fonctions. */
	protected List<ImmutablePair<String, FonctionType>> mFonctions;
	/** Localite de l'agence. */
	protected String mLocaliteName;

	/**
	 * Constructeur.
	 * 
	 * @param fabrique     Fabrique permettant d'initialiser les entités de
	 *                     l'application GIRAPHIX.
	 * @param localiteName Localite de l'entreprise.
	 */
	public PersonneBuilder(ObjectFactory fabrique, String localiteName) {
		super(fabrique);

		this.mLocaliteName = localiteName;
	}

	@Override
	public void reset() {
		this.mPersonne = mFabrique.createPersonneType();

		this.mFonctions = PersonneTools.getListPairFonction();

		// Mise en place des données par défaut.
		NationalitesType nationalitesType = mFabrique.createNationalitesType();
		nationalitesType.getNationalites().add(NATIONNALITE_FRANCAISE);
		this.mPersonne.setNationalites(nationalitesType);
		this.mPersonne.setInterne(true);
		this.mPersonne.setActif(true);

		// Gestion de l'agence
		if (checkIfContains(mLocaliteName,
				ApplicationLoader.getInstance().getText(ConstantEntreprise.BORDEAUX_LOCALITE))) {
			this.mPersonne
					.setIdEntreprise(ApplicationLoader.getInstance().getText(ConstantEntreprise.BORDEAUX_CODE_SE));
		} else if (checkIfContains(mLocaliteName, ApplicationLoader.getInstance().getText(ConstantEntreprise.PARIS_LOCALITE))) {
			this.mPersonne.setIdEntreprise(ApplicationLoader.getInstance().getText(ConstantEntreprise.PARIS_CODE_SE));
		} else {
			LOGGER.debug(ApplicationLoader.getInstance().getText("message.error.entreprise"));
		}

	}

	/**
	 * Affectation de l'identitfiant de la personne.
	 * 
	 * @param personneID Identifiant de la personne.
	 */
	public void setId(String id) {
		this.mPersonne.setId(id);
	}

	/**
	 * Affectation de la date de naissance.
	 * 
	 * @param cell Cellule où l'on va récupérer la'information.
	 */
	public void setDateNaissance(HSSFCell cell) {
		long dateFromCell = getLongDateFromCell(cell);
		if (dateFromCell != 0) {
			this.mPersonne.setDateDeNaissance(dateFromCell);
		}
	}

	/**
	 * Affectation du nom.
	 * 
	 * @param cell Cellule où l'on va récupérer la'information.
	 * @throws LineExcelException
	 */
	public void setNom(HSSFCell cell) throws LineExcelException {

		String stringFromCell = getStringFromCell(cell);
		if (!stringFromCell.isBlank()) {
			this.mPersonne.setNom(stringFromCell);
		} else {
			int rowIndex = cell.getRowIndex() - 1;
			throw new LineExcelException(ApplicationLoader.getInstance()
					.getText("message.error.line.not.added.personne.id.lastname",
							Integer.toString(rowIndex)));
		}
	}

	/**
	 * Affectation du prénom.
	 * 
	 * @param cell Cellule où l'on va récupérer la'information.
	 * @throws LineExcelException
	 */
	public void setPrenom(HSSFCell cell) throws LineExcelException {
		String stringFromCell = getStringFromCell(cell);
		if (!stringFromCell.isBlank()) {
			this.mPersonne.setPrenom(getStringFromCell(cell));
		} else {
			int rowIndex = cell.getRowIndex() - 1;
			throw new LineExcelException(ApplicationLoader.getInstance()
					.getText("message.error.line.not.added.personne.id.firstname", Integer.toString(rowIndex)));
		}
	}

	/**
	 * Affectation du prénom.
	 * 
	 * @param cell Cellule où l'on va récupérer la'information.
	 */
	public void setCivilite(HSSFCell cell) {
		String currentValue = getStringFromCell(cell);
		if (checkIfContains(currentValue, CIVILITE_MONSIEUR)) {
			this.mPersonne.setCivilite(CiviliteType.M);
		} else if (checkIfContains(currentValue, CIVILITE_MADAME)) {
			this.mPersonne.setCivilite(CiviliteType.MME);
		} else {
			this.mPersonne.setCivilite(CiviliteType.M);
		}
	}

	/**
	 * Affectation de la ville de naissance.
	 * 
	 * @param cell Cellule où l'on va récupérer la'information.
	 * @throws LineExcelException
	 */
	public void setVilleNaissance(HSSFCell cell) {
		this.mPersonne.setVilleDeNaissance(getStringFromCell(cell));
	}

	/**
	 * Affectation de la fonction.
	 * 
	 * @param cell Cellule où l'on va récupérer la'information.
	 */
	public void setFonction(HSSFCell cell) {

		// Valeur déterminant si une fonction équivalent est présente dans GIRAPHIX
		boolean isFounded = false;

		String[] valueSplit = getStringFromCell(cell).toLowerCase().split(" ");
		for (String currentValue : valueSplit) {

			isFounded = this.mFonctions.stream().anyMatch(fonction -> {
				if (checkIfContains(currentValue, fonction.getKey())) {
					this.mPersonne.setFonction(fonction.getValue());
					return true;
				}
				return false;
			});
		}

		// Si aucune fonction équivalente n'est trouvé
		if (!isFounded) {

			// Valeurs par défaut
			this.mPersonne.setFonction(FonctionType.INGENIEURS_ET_CADRE);
		}
	}

	/**
	 * Vérifie si une valeur est contenu dans une autre.
	 * 
	 * @param currentValue   Valeur à vérifier.
	 * @param valueToCompare Valeur à copmparer.
	 * @return True, si la deuxième valeur est contenue dans la première.
	 */
	protected boolean checkIfContains(String currentValue, String valueToCompare) {
		return StringUtils.indexOfIgnoreCase(StringUtils.stripAccents(currentValue),
				StringUtils.stripAccents(valueToCompare)) != -1;
	}

	/**
	 * @return Personne en cours de création.
	 */
	public PersonneType getPersonne() {
		return this.mPersonne;
	}

}
