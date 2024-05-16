package _CG.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import _CG.bean.DacssiType;
import _CG.bean.EntrepriseType;
import _CG.bean.GiraphixDatas;
import _CG.bean.HabilitationType;
import _CG.bean.ObjectFactory;
import _CG.bean.PersonneType;
import _CG.exception.CGException;
import _CG.read.builder.DacsiiBuilder;
import _CG.read.builder.EntrepriseBuilder;
import _CG.read.builder.GiraphixDataBuilder;
import _CG.read.builder.HabilitationBuilder;
import _CG.read.builder.PersonneBuilder;
import _CG.tools.ApplicationLoader;
import _CG.tools.Tools;
import javafx.scene.control.Alert.AlertType;

/**
 * Lecteur d'un fichier Excel à l'aide de POI.
 */
public class CGExcelReader implements ICGReader {

	/** Logger. */
	private static final Logger LOGGER = LogManager.getLogger(CGExcelReader.class);

	/**************************
	 * Constructeur de données.
	 *************************/
	/** Constructeur des données de haut niveau de giraphix. */
	protected GiraphixDataBuilder mGiraphixBuilder;
	/** Constructeur des données {@link PersonneType} de giraphix. */
	protected PersonneBuilder mPersonneBuilder;
	/** Constructeur des données {@link HabilitationType} de giraphix. */
	protected HabilitationBuilder mHabilitationBuilder;
	/** Constructeur des données {@link EntrepriseType} de giraphix. */
	protected EntrepriseBuilder mEntrepriseBuilder;
	/** Constructeur des données {@link DacssiType} de giraphix. */
	protected DacsiiBuilder mDacsiiBuilder;

	/************************
	 * Lecteur de pages Excel.
	 ************************/
	/** Lecteur de la page des habilitations. */
	protected HabilitationPageReader mHabilitationReader;
	/** Lecteur de la page des habilitations. */
	protected DacsiiPageReader mDacsiiReader;

	/** Fichier excel. */
	protected File mExcelFile;
	/** Usine permettant la création des bean de giraphix. */
	protected ObjectFactory mFabrique;

	/**
	 * Constructeur.
	 * 
	 * @param file   Fichier excel à lire.
	 * @param agence L'agence à créer.
	 */
	public CGExcelReader(File file, String agence) {
		this.mExcelFile = file;
		this.mFabrique = new ObjectFactory();
		this.mGiraphixBuilder = new GiraphixDataBuilder(mFabrique);
		this.mPersonneBuilder = new PersonneBuilder(mFabrique, agence);
		this.mHabilitationBuilder = new HabilitationBuilder(mFabrique);
		this.mEntrepriseBuilder = new EntrepriseBuilder(mFabrique, agence);
		this.mDacsiiBuilder = new DacsiiBuilder(mFabrique);

		this.mHabilitationReader = new HabilitationPageReader(mGiraphixBuilder, mPersonneBuilder, mHabilitationBuilder,
				mEntrepriseBuilder);
		this.mDacsiiReader = new DacsiiPageReader(mGiraphixBuilder, mPersonneBuilder, mDacsiiBuilder,
				mEntrepriseBuilder);
	}

	@Override
	public void read() throws CGException {
		try {
			LOGGER.info("Debut de la lecture du Excel :" + mExcelFile.getName());

			// Récupération du fichier sous le format POI
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(mExcelFile));
			HSSFWorkbook workbook = new HSSFWorkbook(fs);

			// Récupération des informations pour les habilitations
			HSSFSheet sheet = workbook.getSheetAt(0);
			this.mHabilitationReader.readRows(sheet);

			// Récupération des informations pour les DACSII
			if (workbook.getNumberOfSheets() == 2) {
				sheet = workbook.getSheetAt(1);
				this.mDacsiiReader.readRows(sheet);
			} else {
				Tools.displayMessage(ApplicationLoader.getInstance().getText("message.warning.no.dacssi"),
						AlertType.WARNING, LOGGER);
			}

			workbook.close();

		} catch (FileNotFoundException e) {
			throw new CGException(
					ApplicationLoader.getInstance().getText("message.error.reader.path", mExcelFile.getPath()), e);
		} catch (IOException e) {
			throw new CGException(ApplicationLoader.getInstance().getText("message.error.reader.data"), e);
		} finally {
			LOGGER.info("Fin de la lecture du Excel :" + mExcelFile.getName());
		}
	}

	@Override
	public GiraphixDatas getDatas() {
		return this.mGiraphixBuilder.getResult();
	}
}
