package _CG.read;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import _CG.bean.EntrepriseType;
import _CG.bean.HabilitationType;
import _CG.bean.PersonneType;
import _CG.comparator.PersonneComparator;
import _CG.constant.ConstantSheetHabilitation;
import _CG.exception.LineExcelException;
import _CG.read.builder.EntrepriseBuilder;
import _CG.read.builder.GiraphixDataBuilder;
import _CG.read.builder.HabilitationBuilder;
import _CG.read.builder.IBuilder;
import _CG.read.builder.PersonneBuilder;

/**
 * Lecteur de la page des habilitations.
 */
public class HabilitationPageReader extends ACGSheetReader implements ICGSheetReader {

	/** Logger. */
	private static final Logger LOGGER = LogManager.getLogger(HabilitationPageReader.class);
	/** Constructeur des données {@link PersonneType} de giraphix. */
	protected PersonneBuilder mPersonneBuilder;
	/** Constructeur des données {@link HabilitationType} de giraphix. */
	protected HabilitationBuilder mHabilitationBuilder;
	/** Constructeur des données {@link EntrepriseType} de giraphix. */
	protected EntrepriseBuilder mEntrepriseBuilder;

	/**
	 * Constructeur.
	 * 
	 * @param giraphixBuilder     Constructeur des données de haut niveau de
	 *                            giraphix.
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
		this.mGiraphixBuilder.addEntreprise(mEntrepriseBuilder.getEntreprise());
	}

	/**
	 * Lecture d'une ligne. Gestion de chaque cellule à partir des colonnes.
	 * 
	 * @param row {@link HSSFRow}.
	 */
	@Override
	protected void readRow(HSSFRow row) {

		// Chaque ligne doit être lié à une personne si la cellule n'est pas renseigné
		// on ne prends pas en compte la ligne.
		if (checkCellValue(ConstantSheetHabilitation.INDEX_NOM, row)) {
			try {
				int index = 1;
				resetValue();
	
				Iterator<Cell> cellIter = row.cellIterator();

				// Vérification
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
						mPersonneBuilder.setNom(cell);
						break;
					case ConstantSheetHabilitation.INDEX_PRENOM:
						mPersonneBuilder.setPrenom(cell);
						break;
					case ConstantSheetHabilitation.INDEX_CIVILITE:
						mPersonneBuilder.setCivilite(cell);
						break;
					case ConstantSheetHabilitation.INDEX_TYPE_HABILITATION:
						mHabilitationBuilder.setTypeHabilitation(cell);
						break;
					case ConstantSheetHabilitation.INDEX_DATE_NAISSANCE:
						mPersonneBuilder.setDateNaissance(cell);
						break;
					case ConstantSheetHabilitation.INDEX_VILLE_NAISSANCE:
						mPersonneBuilder.setVilleNaissance(cell);
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
					default:
						break;
					}
					index++;
				}

				String personneID = createAndGetPersonneID(mPersonneBuilder.getPersonne());
				mPersonneBuilder.setId(personneID);

				if (this.mHabilitationBuilder.isEntityToAdded()) {
					PersonneComparator comparator = new PersonneComparator();
					boolean personneIsInCG = this.mGiraphixBuilder
							.checkPresenceOfOnePersonne(mPersonneBuilder.getPersonne(), comparator);

					HabilitationType habilitation = mHabilitationBuilder.getHabilitation();
					this.mHabilitationBuilder.setIDPersonne(personneID);
					
					// Si une ID n'est pas présente
					if (!personneIsInCG) {
						this.mGiraphixBuilder.addPersonne(mPersonneBuilder.getPersonne());
					}

					this.mGiraphixBuilder.addHabilitation(habilitation);
				}
			} catch (LineExcelException e) {
				LOGGER.warn(e.getMessage());
			}
		}
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
