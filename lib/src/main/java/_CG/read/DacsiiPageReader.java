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
import _CG.read.builder.DacsiiBuilder;
import _CG.read.builder.EntrepriseBuilder;
import _CG.read.builder.GiraphixDataBuilder;
import _CG.read.builder.IBuilder;
import _CG.read.builder.PersonneBuilder;
import _CG.read.constant.ConstantSheetDacsii;

/**
 * Lecteur de la page des habilitations.
 */
public class DacsiiPageReader extends ACGSheetReader implements ICGSheetReader {

	/** Constructeur des données {@link PersonneType} de giraphix. */
	protected PersonneBuilder mPersonneBuilder;
	/** Constructeur des données {@link HabilitationType} de giraphix. */
	protected DacsiiBuilder mDacsiiBuilder;
	/** Constructeur des données {@link EntrepriseType} de giraphix. */
	protected EntrepriseBuilder mEntrepriseBuilder;

	/**
	 * Constructeur.
	 * 
	 * @param giraphixBuilder     Constructeur des données de haut niveau de
	 *                            giraphix.
	 * @param personneBuilder     Constructeur des données {@link PersonneType} de
	 *                            giraphix.
	 * @param entrepriseBuilder   Constructeur des données {@link EntrepriseType} de
	 *                            giraphix.
	 * @param habilitationBuilder Constructeur des données {@link HabilitationType}
	 *                            de giraphix.
	 */
	public DacsiiPageReader(GiraphixDataBuilder giraphixBuilder, PersonneBuilder personneBuilder,
			DacsiiBuilder dacsiiBuilder, EntrepriseBuilder entrepriseBuilder) {
		super(giraphixBuilder);
		this.mPersonneBuilder = personneBuilder;
		this.mDacsiiBuilder = dacsiiBuilder;
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
	}

	/**
	 * Lecture d'une ligne. Gestion de chaque cellule à partir des colonnes.
	 * 
	 * @param row {@link HSSFRow}.
	 */
	@Override
	protected void readRow(HSSFRow row) {
		
		if (checkCellValue(ConstantSheetDacsii.INDEX_NOM, row)) {
			int index = 1;
			resetValue();

			String personneID = UUID.randomUUID().toString();
			mPersonneBuilder.setId(personneID);
			
			Iterator<Cell> cellIter = row.cellIterator();
			while (cellIter.hasNext()) {

				// Récupération de la cellule
				HSSFCell cell = (HSSFCell) cellIter.next();

				switch (index) {
				case ConstantSheetDacsii.INDEX_REFERENCE_APSIDE:
					mDacsiiBuilder.setNumeroInterne(cell);
					break;
				case ConstantSheetDacsii.INDEX_REFERENCE_SOPHIA:
					mDacsiiBuilder.setNumeroSophia(cell);
					break;
				case ConstantSheetDacsii.INDEX_NOM:
					mPersonneBuilder.setNom(cell);
					break;
				case ConstantSheetDacsii.INDEX_PRENOM:
					mPersonneBuilder.setPrenom(cell);
					break;
				case ConstantSheetDacsii.INDEX_TYPE_HABILITATION:
					mDacsiiBuilder.setTypeHabilitation(cell);
					break;
				case ConstantSheetDacsii.INDEX_DATE_NAISSANCE:
					mPersonneBuilder.setDateNaissance(cell);
					break;
				case ConstantSheetDacsii.INDEX_FONCTION:
					mPersonneBuilder.setFonction(cell);
					break;
				case ConstantSheetDacsii.INDEX_DATE_ENVOI_DIRPSD:
					mDacsiiBuilder.setDateEnvoiDIRPSD(cell);
					break;
				case ConstantSheetDacsii.INDEX_DATE_RETOUR_DECISION:
					mDacsiiBuilder.setDateRetourDecision(cell);
					break;
				case ConstantSheetDacsii.INDEX_VALIDITE_HABILITATION:
					mDacsiiBuilder.setValiditeHabilitation(cell);
					break;
				case ConstantSheetDacsii.INDEX_AGENCE_RATTACHEMENT:
				case ConstantSheetDacsii.INDEX_CLIENT:
				case ConstantSheetDacsii.INDEX_NUMERO_HABILITATION:
				case ConstantSheetDacsii.INDEX_DOSSIER_SUIVI:
					// Non pris en compte
					break;
				default:
					break;
				}
				index++;
			}

			if (this.mDacsiiBuilder.isEntityToAdded()) {
				String goodID = this.mGiraphixBuilder
						.verifiesPresenceOfPersonneAndGetGoodID(mPersonneBuilder.getPersonne());

				// Si une ID est déjà présente
				if (!personneID.equals(goodID)) {
					// On associe le DACSSI à la personne déjà existante
					this.mDacsiiBuilder.setIDPersonne(goodID);
				} else {
					// Sinon on l'ajoute
					this.mDacsiiBuilder.setIDPersonne(personneID);
					this.mGiraphixBuilder.addPersonne(mPersonneBuilder.getPersonne());
				}

				this.mGiraphixBuilder.addDacsii(mDacsiiBuilder.getDacssi());
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
		mDacsiiBuilder.reset();
	}

}
