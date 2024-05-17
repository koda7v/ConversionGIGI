package _CG.read;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.CellType;

import _CG.bean.PersonneType;
import _CG.read.builder.GiraphixDataBuilder;
import _CG.read.builder.IBuilder;

/**
 * Classe abstraite permettant la lecture d'une page d'un fichier Excel.
 */
public abstract class ACGSheetReader {

	/** Constructeur des données de haut niveau de giraphix. */
	protected GiraphixDataBuilder mGiraphixBuilder;

	/**
	 * Constructeur.
	 * 
	 * @param giraphixBuilder Constructeur des données de haut niveau de giraphix.
	 */
	public ACGSheetReader(GiraphixDataBuilder giraphixBuilder) {
		this.mGiraphixBuilder = giraphixBuilder;
	}

	/**
	 * Permet la reinitialisation des {@link IBuilder} permettant la création des
	 * objets.
	 */
	abstract void resetValue();

	/**
	 * Lecture d'une ligne. Gestion de chaque cellule à partir des colonnes.
	 * 
	 * @param row {@link HSSFRow}.
	 */
	abstract void readRow(HSSFRow row);

	/**
	 * Vérifie l'authenticité d'une row.
	 * 
	 * @param row Ligne sur laquelle on travaille.
	 * @return True, s'il y a une valeur dans la cellule.
	 */
	protected boolean checkCellValue(int cellIndexToCHeck, HSSFRow row) {
		HSSFCell cell = row.getCell(cellIndexToCHeck);
		return cell != null && cell.getCellType() != CellType.BLANK;
	}

	/**
	 * Crée et récupére de l'ID de la personne.
	 * 
	 * @param personneType Personne surlaquelle on travaille.
	 * @return Identifiant.
	 */
	protected String createAndGetPersonneID(PersonneType personneType) {
		return personneType.getNom().toUpperCase() + personneType.getPrenom().toUpperCase();
	}

}
