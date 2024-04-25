package _CG.read;

import java.util.Iterator;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import _CG.bean.EntrepriseType;
import _CG.bean.HabilitationType;
import _CG.bean.PersonneType;
import _CG.read.builder.EntrepriseBuilder;
import _CG.read.builder.GiraphixDataBuilder;
import _CG.read.builder.HabilitationBuilder;
import _CG.read.builder.IBuilder;
import _CG.read.builder.PersonneBuilder;
import _CG.read.constant.ConstantSheetHabilitation;

/**
 * Lecteur de la page des habilitations.
 */
public class HabilitationPageReader extends ACGSheetReader implements ICGSheetReader {

	/** Constructeur des données {@link PersonneType} de giraphix. */
	protected PersonneBuilder mPersonneBuilder;
	/** Constructeur des données {@link HabilitationType} de giraphix. */
	protected HabilitationBuilder mHabilitationBuilder;
	/** Constructeur des données {@link EntrepriseType} de giraphix. */
	protected EntrepriseBuilder mEntrepriseBuilder;

	/**
	 * Constructeur.
	 * 
	 * @param giraphixBuilder
	 * 
	 * @param personneBuilder     Constructeur des données {@link PersonneType} de
	 *                            giraphix.
	 * @param habilitationBuilder Constructeur des données {@link HabilitationType}
	 *                            de giraphix.
	 * @param entrepriseBuilder   Constructeur des données {@link EntrepriseType} de
	 *                            giraphix.
	 */
	public HabilitationPageReader(GiraphixDataBuilder giraphixBuilder, PersonneBuilder personneBuilder,
			HabilitationBuilder habilitationBuilder,
			EntrepriseBuilder entrepriseBuilder) {
		super(giraphixBuilder);
		this.mPersonneBuilder = personneBuilder;
		this.mHabilitationBuilder = habilitationBuilder;
		this.mEntrepriseBuilder = entrepriseBuilder;
	}

	/**
	 * Lecture du fichier ligne par ligne.
	 * 
	 * @param sheet {@link HSSFSheet}.
	 */
	@Override
	public void readRows(HSSFSheet sheet) {
		Iterator<Row> rowIter = sheet.rowIterator();
		while (rowIter.hasNext()) {
			HSSFRow row = (HSSFRow) rowIter.next();

			// Suppression de l'header
			if (row.getRowNum() != 0) {
				readRow(row);
			}
		}
		this.mEntrepriseBuilder.reset();
		this.mGiraphixBuilder.addEntreprise(mEntrepriseBuilder.getEntreprise());
	}

	/**
	 * Lecture d'une ligne. Gestion de chaque cellule à partir des colonnes.
	 * 
	 * @param row {@link HSSFRow}.
	 */
	@Override
	protected void readRow(HSSFRow row) {
		int index = 1;
		resetValue();

		String personneID = UUID.randomUUID().toString();
		mPersonneBuilder.setId(personneID);

		mHabilitationBuilder.setIDPersonne(personneID);

		Iterator<Cell> cellIter = row.cellIterator();
		while (cellIter.hasNext()) {

			// Récupération de la cellule
			HSSFCell cell = (HSSFCell) cellIter.next();

			switch (index) {
			case ConstantSheetHabilitation.INDEX_CODE_SOPHIA:
				mHabilitationBuilder.setNumeroInterne(cell);
				break;
			case ConstantSheetHabilitation.INDEX_REFERENCE_SOPHIA:
				mHabilitationBuilder.setNumeroSophia(cell);
				break;
			case ConstantSheetHabilitation.INDEX_NOM:
				mPersonneBuilder.setNomPrenom(cell);
				break;
			case ConstantSheetHabilitation.INDEX_AGENCE_RATTACHEMENT:
				// mEntrepriseBuilder.setAgenceRattachement(cell);
				break;
			case ConstantSheetHabilitation.INDEX_TYPE_HABILITATION:
				mHabilitationBuilder.setTypeHabilitation(cell);
				break;
			case ConstantSheetHabilitation.INDEX_DATE_NAISSANCE:
				mPersonneBuilder.setDateNaissance(cell);
				break;
			case ConstantSheetHabilitation.INDEX_FONCTION:
				mPersonneBuilder.setFonction(cell);
				break;
			case ConstantSheetHabilitation.INDEX_DATE_ENVOI_DIRPSD:
				mHabilitationBuilder.setDateEnvoiDIRPSD(cell);
				break;
			case ConstantSheetHabilitation.INDEX_DATE_RETOUR_DECISION:
				mHabilitationBuilder.setDateRetourDecision(cell);
				break;
			case ConstantSheetHabilitation.INDEX_RETOUR_ENGAGEMENT_RESPONSABILITE:
				mHabilitationBuilder.setRetourEngagementResponsabiliteSigne(cell);
				break;
			case ConstantSheetHabilitation.INDEX_VALIDITE_HABILITATION:
				mHabilitationBuilder.setValiditeHabilitation(cell);
				break;
			case ConstantSheetHabilitation.INDEX_CLIENT:
			case ConstantSheetHabilitation.INDEX_DATE_ENVOI_83B:
			case ConstantSheetHabilitation.INDEX_DATE_RECEPTION83B:
			case ConstantSheetHabilitation.INDEX_ENVOI_ENGAGEMENT_RESPONSABILITE:
			case ConstantSheetHabilitation.INDEX_DATE_RETOUR_SENSIBILITE:
			case ConstantSheetHabilitation.INDEX_NUMERO_HABILITATION:
			case ConstantSheetHabilitation.INDEX_AR_ENVOYE_COMMENTAIRE:
			case ConstantSheetHabilitation.INDEX_DOSSIER_SUIVI:
			case ConstantSheetHabilitation.INDEX_COMMENTAIRE:
			case ConstantSheetHabilitation.INDEX_VOLET_2_ENVOYE:
				// Non pris en compte
				break;
			default:
				break;
			}
			index++;
		}

		this.mGiraphixBuilder.addHabilitation(mHabilitationBuilder.getHabilitation());
		this.mGiraphixBuilder.addPersonne(mPersonneBuilder.getPersonne());
	}

	/**
	 * Permet la reinitialisation des {@link IBuilder} permettant la création des
	 * objets.
	 */
	@Override
	protected void resetValue() {
		mPersonneBuilder.reset();
		mHabilitationBuilder.reset();
	}

}
