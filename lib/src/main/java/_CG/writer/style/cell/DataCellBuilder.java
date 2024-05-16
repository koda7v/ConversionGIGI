package _CG.writer.style.cell;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;

import _CG.constant.ConstantStyleColor;

/**
 * Classe permettant la création des cellules pour afficher des données.
 */
public class DataCellBuilder extends ACellBuilder {

	/** Valeur vide. */
	protected static final String EMPTY_VALUE = "";
	/** Valeur "sans objet". */
	protected static final String SANS_OBJET_VALUE = "Sans objet";

	/**
	 * Constructeur.
	 * 
	 * @param workbook {@link Workbook}.
	 */
	public DataCellBuilder(Workbook workbook) {
		super(workbook);
		this.mSize = (short) 10;
	}

	/**
	 * Création d'une cellule vide.
	 * 
	 * @param row         Ligne où l'on insère la valeur.
	 * @param indexOfCell Index de la colonne où l'on insère la valeur.
	 * @return {@link Cell} crée.
	 */
	public Cell createEmptyCell(Row row, int indexOfCell) {
		return setValueAndGetCell(row, indexOfCell, EMPTY_VALUE);
	}

	/**
	 * Création d'une cellule vide.
	 * 
	 * @param row         Ligne où l'on insère la valeur.
	 * @param indexOfCell Index de la colonne où l'on insère la valeur.
	 * @return {@link Cell} crée.
	 */
	public Cell createSansObjetCell(Row row, int indexOfCell) {
		return setValueAndGetCell(row, indexOfCell, SANS_OBJET_VALUE);
	}

	/**
	 * Création d'une cellule vide.
	 * 
	 * @param row         Ligne où l'on insère la valeur.
	 * @param indexOfCell Index de la colonne où l'on insère la valeur.
	 * @param value       Valeur à insérer.
	 * @return {@link Cell} crée.
	 */
	public Cell createCell(Row row, int indexOfCell, String value) {
		return setValueAndGetCell(row, indexOfCell, value);
	}

	/**
	 * Création d'une cellule vide.
	 * 
	 * @param row         Ligne où l'on insère la valeur.
	 * @param indexOfCell Index de la colonne où l'on insère la valeur.
	 * @param value       Valeur à insérer.
	 * @param style       Style de la cellule.
	 * @return {@link Cell} crée.
	 */
	public Cell createCell(Row row, int indexOfCell, String value, CellStyle style) {
		Cell cell = setValueAndGetCell(row, indexOfCell, value);
		cell.setCellStyle(style);
		return cell;
	}

	protected Cell setValueAndGetCell(Row row, int indexOfCell, String value) {
		Cell cell = row.getCell(indexOfCell);
		if (cell == null) {
			cell = row.createCell(indexOfCell);
		}
		cell.setCellValue(value);
		cell.setCellStyle(getGreyCellStyle());
		return cell;
	}

	public CellStyle getGreyCellStyle() {
		return createBuilderCellStyle(new XSSFColor(ConstantStyleColor.GREY_COLOR, null));
	}
}
