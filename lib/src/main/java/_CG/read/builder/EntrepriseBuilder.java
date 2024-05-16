package _CG.read.builder;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import _CG.bean.EntrepriseType;
import _CG.bean.ObjectFactory;
import _CG.constant.ConstantEntreprise;
import _CG.tools.ApplicationLoader;

/**
 * Constructeur de données pour {@link EntrepriseType}.
 */
public class EntrepriseBuilder extends ABuilder implements IBuilder {

	/** Logger. */
	private static final Logger LOGGER = LogManager.getLogger(EntrepriseBuilder.class);


	/** Entreprise courante en cours de création. */
	protected EntrepriseType mEntreprise;
	/** L'entreprise est-elle à ajouter ? */
	protected boolean isToAdded;

	/**
	 * Constructeur.
	 * 
	 * @param fabrique     Fabrique permettant d'initialiser les entités de
	 *                     l'application GIRAPHIX.
	 * @param localiteName Localite de l'entreprise.
	 */
	public EntrepriseBuilder(ObjectFactory fabrique, String localiteName) {
		super(fabrique);
		initEntreprise(localiteName);
	}

	private void initEntreprise(String entrepriseName) {
		this.mEntreprise = mFabrique.createEntrepriseType();

		if (StringUtils.indexOfIgnoreCase(StringUtils.stripAccents(entrepriseName),
				ApplicationLoader.getInstance().getText(ConstantEntreprise.BORDEAUX_LOCALITE)) != -1) {
			createBordeauxEntreprise();
		} else if (StringUtils.indexOfIgnoreCase(StringUtils.stripAccents(entrepriseName),
				ApplicationLoader.getInstance().getText(ConstantEntreprise.PARIS_LOCALITE)) != -1) {
			createParisEntreprise();
		} else {
			LOGGER.debug(ApplicationLoader.getInstance().getText("message.error.entreprise"));
		}
	}

	@Override
	public void reset() {
		this.mEntreprise = mFabrique.createEntrepriseType();
		this.isToAdded = true;
	}

	/**
	 * Création de l'entreprise de Bordeaux.
	 */
	protected void createBordeauxEntreprise() {
		mEntreprise.setNom(ApplicationLoader.getInstance().getText(ConstantEntreprise.APSIDE_NAME));
		mEntreprise.setLocalite(ApplicationLoader.getInstance().getText(ConstantEntreprise.BORDEAUX_LOCALITE));
		mEntreprise.setAdresse(ApplicationLoader.getInstance().getText(ConstantEntreprise.BORDEAUX_ADRESSE));
		mEntreprise.setCodePostal(ApplicationLoader.getInstance().getText(ConstantEntreprise.BORDEAUX_CODE_POSTAL));
		mEntreprise.setCodeSE(ApplicationLoader.getInstance().getText(ConstantEntreprise.BORDEAUX_CODE_SE));
	}

	/**
	 * Création de l'entreprise de Paris.
	 */
	protected void createParisEntreprise() {
		mEntreprise.setNom(ApplicationLoader.getInstance().getText(ConstantEntreprise.APSIDE_NAME));
		mEntreprise.setLocalite(ApplicationLoader.getInstance().getText(ConstantEntreprise.PARIS_LOCALITE));
		mEntreprise.setAdresse(ApplicationLoader.getInstance().getText(ConstantEntreprise.PARIS_ADRESSE));
		mEntreprise.setCodePostal(ApplicationLoader.getInstance().getText(ConstantEntreprise.PARIS_CODE_POSTAL));
		mEntreprise.setCodeSE(ApplicationLoader.getInstance().getText(ConstantEntreprise.PARIS_CODE_SE));
	}

	/**
	 * @return Entreprise en cours de création.
	 */
	public EntrepriseType getEntreprise() {
		return this.mEntreprise;
	}
}
