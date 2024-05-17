package _CG.writer;


import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import _CG.bean.GiraphixDatas;
import _CG.bean.GiraphixDatas.Habilitations;
import _CG.bean.GiraphixDatas.Personnes;
import _CG.bean.HabilitationType;
import _CG.bean.PersonneType;
import _CG.bean.WorkflowType;
import _CG.constant.ConstantExcelWriter;
import _CG.exception.CGException;
import _CG.tools.ApplicationLoader;
import _CG.writer.style.cell.DataCellBuilder;
import _CG.writer.style.cell.HabilitationCellBuilder;
import _CG.writer.style.cell.PersonneCellBuilder;

/**
 * Ecriture sous un format XML à l'aide de JAXB.
 */
public class CGExcelWriter implements ICGWriter {

	/** Logger. */
	private static final Logger LOGGER = LogManager.getLogger(CGExcelWriter.class);
	/** Format de la date donnée dans le nom du fichier XML. */
	private static final String EXPORT_DATE_FORMAT = "yyyyddMMHHmmss";
	/** Nom du fichier XMl. */
	private static final String EXPORT_TITLE_NAME = "_DGA-SSDI-SDOSD_Giraphix";
	/** Extension donnée au fichier de sortie. */
	private static final String EXPORT_EXTENSION = ".xlsx";

	/** Donnée importer. */
	protected GiraphixDatas mDatas;
	/** L'index de la ligne courante. */
	protected int mIndexRow;
	/** Nombre total de colonne. */
	protected int mNumberOfCols;
	/** {@link DataCellBuilder} */
	protected DataCellBuilder mDataCellbuilder;
	/** {@link PersonneCellBuilder} */
	protected PersonneCellBuilder mPersonneBuilder;
	/** {@link HabilitationCellBuilder} */
	protected HabilitationCellBuilder mHabilitationBuilder;
	/** Chemin où l'on va placer le fichier écrit. */
	protected String mPathForFolder;

	/**
	 * Constructeur.
	 * 
	 * @param giraphixDatas
	 */
	public CGExcelWriter() {
		this.mIndexRow = 21;
	}

	@Override
	public void write() throws CGException {

		LOGGER.info("Debut de l'écriture.");

		// Récupération du fichier sous le format POI
		try {
			InputStream resourceAsStream = getClass().getResourceAsStream("/template/template_excel.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(resourceAsStream);

			XSSFSheet sheet = workbook.getSheetAt(2);

			// Initialisation des builder
			this.mDataCellbuilder = new DataCellBuilder(workbook);
			this.mPersonneBuilder = new PersonneCellBuilder(workbook);
			this.mHabilitationBuilder = new HabilitationCellBuilder(workbook);

			// Mise en place des données
			constructData(sheet);
			// Ecriture du fichier
			writeFile(workbook);
		} catch (IOException e) {
			throw new CGException(ApplicationLoader.getInstance().getText("message.error.writer.template"), e);
		}
		LOGGER.info("Fin de l'écriture.");
	}

	/**
	 * Ecriture du fichier.
	 * 
	 * @param workbook {@link Workbook}.
	 * @throws CGException
	 */
	protected void writeFile(Workbook workbook) throws CGException {
		// Fichier sélectionné
		writeData(workbook);

		try {
			Desktop.getDesktop().open(new File(mPathForFolder));
		} catch (IOException e) {
			throw new CGException(ApplicationLoader.getInstance().getText("message.error.writer.desktop"), e);
		}
	}

	/**
	 * Ecriture des données.
	 * 
	 * @param workbook {@link Workbook}.
	 * @throws CGException
	 */
	protected void writeData(Workbook workbook) throws CGException {

		LOGGER.info("Ecriture du fichier.");
		// Gestion du format de la date donnée dans le nom du fichier
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat(EXPORT_DATE_FORMAT);
		// Vérification des droits
		File fileToWrite = new File(
				mPathForFolder + File.separator + formater.format(date) + EXPORT_TITLE_NAME + EXPORT_EXTENSION);
		try {
			FileOutputStream outputStream = new FileOutputStream(fileToWrite.getPath());
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			throw new CGException(ApplicationLoader.getInstance().getText("message.error.writer.creation.file"), e);
		}
	}

	/**
	 * Mise en place des données dans l'Excel.
	 * 
	 * @param sheet Feuille Excel.
	 */
	protected void constructData(Sheet sheet) {
		LOGGER.info("Ecriture des données.");

		mNumberOfCols = sheet.getRow(20).getLastCellNum();

		Habilitations habilitations = this.mDatas.getHabilitations();
		Personnes personnes = this.mDatas.getPersonnes();

		for (HabilitationType habilitation : habilitations.getHabilitation()) {

			WorkflowType workflow = habilitation.getWorkflow();

			// Récupération d'une personne
			Optional<PersonneType> optionalPersonne = personnes.getPersonne().stream().filter(personne -> {
				return checkIfItsGoodPersonne(habilitation, personne);
			}).findAny();
			Row row = sheet.getRow(mIndexRow);
			if (row == null) {
				row = sheet.createRow(mIndexRow);
			}

			if (optionalPersonne.isPresent()) {
				PersonneType currentPersonne = optionalPersonne.get();
				for (int indexCol = 0; indexCol < mNumberOfCols; indexCol++) {
					switch (indexCol) {
					case ConstantExcelWriter.INDEX_FONCTION_MISSION:
						mPersonneBuilder.setFonctionMission(row, indexCol, currentPersonne);
						break;
					case ConstantExcelWriter.INDEX_FAMILY_NAME:
						mPersonneBuilder.setNom(row, indexCol, currentPersonne.getNom());
						break;
					case ConstantExcelWriter.INDEX_FIRSTNAME:
						mPersonneBuilder.setPrenom(row, indexCol, currentPersonne.getPrenom());
						break;
					case ConstantExcelWriter.INDEX_NIVEAU_NATURE:
						mHabilitationBuilder.setNiveauNature(row, indexCol, habilitation);
						break;
					case ConstantExcelWriter.INDEX_DATE_DELIVERY_DECISION:
						mHabilitationBuilder.setDateDeliveryDecision(row, indexCol, workflow.getDecision());
						break;
					case ConstantExcelWriter.INDEX_DATE_END_VALIDITY_DECISION:
						mHabilitationBuilder.setDateEndValidityDecision(row, indexCol, habilitation.getDateValidite());
						break;
					case ConstantExcelWriter.INDEX_REFERENCE_SOPHIA:
						mHabilitationBuilder.setReferenceSophia(row, indexCol, habilitation.getNumeroSophia());
						break;
					case ConstantExcelWriter.INDEX_AUTHORITY_HABILITATION:
						mHabilitationBuilder.setAuthorityHabilitation(row, indexCol, habilitation.getNumeroSophia());
						break;
					case ConstantExcelWriter.INDEX_ADMISSION_REVISION:
						mHabilitationBuilder.setAdmissionRevision(row, indexCol, habilitation.getMotif());
						break;
					case ConstantExcelWriter.INDEX_DATE_FIRST_PAGE_IG1300:
						mHabilitationBuilder.setDateFirstPageIG1300(row, indexCol, habilitation.getDateEngagement());
						break;
					case ConstantExcelWriter.INDEX_REFERENCE_NIS:
						mHabilitationBuilder.setReferenceNis(row, indexCol, habilitation.getNumeroInterne());
						break;
					case ConstantExcelWriter.INDEX_DATE_1:
						mHabilitationBuilder.setDate1(row, indexCol, workflow.getTransmission());
						break;
					case ConstantExcelWriter.INDEX_DATE_2:
						mHabilitationBuilder.setDate2(row, indexCol, workflow.getReception());
						break;
					case ConstantExcelWriter.INDEX_DATE_3:
						mHabilitationBuilder.setDate3(row, indexCol, workflow.getEnquete());
						break;
					case ConstantExcelWriter.INDEX_DATE_4:
						mHabilitationBuilder.setDate4(row, indexCol, workflow.getAvis());
						break;
					case ConstantExcelWriter.INDEX_DATE_5:
						mHabilitationBuilder.setDate5(row, indexCol, workflow.getDecision());
						break;
					case ConstantExcelWriter.INDEX_EMPLACEMENT:
						mHabilitationBuilder.setEmplacement(row, indexCol);
						break;
					case ConstantExcelWriter.INDEX_NUM_POSTE:
					case ConstantExcelWriter.INDEX_DATE_FORMATION:
					case ConstantExcelWriter.INDEX_REFERENCE_NIS_FULL:
					case ConstantExcelWriter.INDEX_DATE_SIGNATURE_NIS:
					case ConstantExcelWriter.INDEX_PU:
					case ConstantExcelWriter.INDEX_JUSTIFICATIF_PU:
					case ConstantExcelWriter.INDEX_DATE_RAPPEL_A:
					case ConstantExcelWriter.INDEX_DATE_RAPPEL_B:
					case ConstantExcelWriter.INDEX_DATE_SIGNATURE_VOLET_1:
					case ConstantExcelWriter.INDEX_DATE_SIGNATURE_VOLET_2:
					case ConstantExcelWriter.INDEX_DATE_TRANSMISSION_VOLET_1_2:
					case ConstantExcelWriter.INDEX_DATE_RENOUVELLEMENT:
					case ConstantExcelWriter.INDEX_OBSERVATION:
						mDataCellbuilder.createEmptyCell(row, indexCol);
						break;
					case ConstantExcelWriter.INDEX_LASTNAME:
					case ConstantExcelWriter.INDEX_DATE_MISE_EVEIL:
					case ConstantExcelWriter.INDEX_DATE_SIGNATURE_MISE_EVEIL:
					case ConstantExcelWriter.INDEX_DATE_TRANSMISSION_AUTHORITY_HABILITATION:
					case ConstantExcelWriter.INDEX_DATE_MISE_EN_GARDE:
					case ConstantExcelWriter.INDEX_DATE_SIGNATURE_MISE_EN_GARDE:
					case ConstantExcelWriter.INDEX_DATE_TRANSMISSION_AUTHORITY_HABILITATION_ATTESTATION_MISE_EN_GARDE:
						mDataCellbuilder.createSansObjetCell(row, indexCol);
						break;
					default:
						mDataCellbuilder.createEmptyCell(row, indexCol);
						break;
					}
				}
			} else {
				LOGGER.warn("L'habilitation avec le numéro interne : " + habilitation.getNumeroInterne()
						+ " n'est pas lié à une personne.");
			}
			mIndexRow++;
		}
	}

	/**
	 * Vérification de l'identifiant d'une personne pour savoir si elle correspond à
	 * celui de l'habilitation.
	 * 
	 * @param habilitation {@link HabilitationType}.
	 * @param personne     {@link PersonneType}.
	 * @return True, si la personne correspond.
	 */
	protected boolean checkIfItsGoodPersonne(HabilitationType habilitation, PersonneType personne) {
		return personne.getId().equals(habilitation.getIdPersonne());
	}

	@Override
	public void setDatas(GiraphixDatas giraphixDatas) {
		this.mDatas = giraphixDatas;
	}

	@Override
	public void setFolderPath(String path) {
		this.mPathForFolder = path;
	}
}
