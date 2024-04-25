package _CG.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import _CG.bean.EntrepriseType;
import _CG.bean.GiraphixDatas;
import _CG.bean.HabilitationType;
import _CG.bean.ObjectFactory;
import _CG.bean.PersonneType;
import _CG.read.builder.EntrepriseBuilder;
import _CG.read.builder.GiraphixDataBuilder;
import _CG.read.builder.HabilitationBuilder;
import _CG.read.builder.PersonneBuilder;

/**
 * Lecteur d'un fichier Excel à l'aide de POI.
 */
public class CGReader implements ICGReader {

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
	 * @param file Fichier excel à lire.
	 */
	public CGReader(File file) {
		this.mExcelFile = file;
		this.mFabrique = new ObjectFactory();
		this.mGiraphixBuilder = new GiraphixDataBuilder(mFabrique);
		this.mPersonneBuilder = new PersonneBuilder(mFabrique);
		this.mHabilitationBuilder = new HabilitationBuilder(mFabrique);
		this.mEntrepriseBuilder = new EntrepriseBuilder(mFabrique);

		this.mHabilitationReader = new HabilitationPageReader(mGiraphixBuilder, mPersonneBuilder, mHabilitationBuilder,
				mEntrepriseBuilder);
		this.mDacsiiReader = new DacsiiPageReader(mGiraphixBuilder, mPersonneBuilder, mHabilitationBuilder,
				mEntrepriseBuilder);
	}

	@Override
	public void readXLS() {
		System.out.println("Debut de la lecture.");
		try {
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
			}

			workbook.close();

			System.out.println("Fin de la lecture.");
		} catch (FileNotFoundException e) {
			System.err.println("Problème avec le chemin du fichier excel. \n" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problème avec la récupération des données \n" + e.getMessage());
		}
	}

	@Override
	public GiraphixDatas getDatas() {
		return this.mGiraphixBuilder.getResult();
	}
}
