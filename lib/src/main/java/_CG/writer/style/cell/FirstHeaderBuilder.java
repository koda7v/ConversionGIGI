package _CG.writer.style.cell;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import _CG.constant.ConstantStyleColor;

/**
 * Constructeur pour la création des cellules pour le premier en-tête.
 */
public class FirstHeaderBuilder extends ACellBuilder {

	/**
	 * COnstructeur.
	 * 
	 * @param workbook {@link Workbook}.
	 */
	public FirstHeaderBuilder(Workbook workbook) {
		super(workbook);
		this.mSize = (short) 18;
	}

	/**
	 * @return Style de cellule ayant un backgroud de couleur jaune.
	 */
	public CellStyle getYellowCellStyle() {
		return createBuilderCellStyle(new XSSFColor(ConstantStyleColor.YELLOW_COLOR, null));
	}

	/**
	 * @return Style de cellule ayant un backgroud de couleur orange.
	 */
	public CellStyle getOrangeCellStyle() {
		return createBuilderCellStyle(new XSSFColor(ConstantStyleColor.ORANGE_COLOR, null));
	}

	/**
	 * @return Style de cellule ayant un backgroud de couleur blanche.
	 */
	public CellStyle getWhiteCellStyle() {
		return createBuilderCellStyle(IndexedColors.WHITE.getIndex());
	}

	@Override
	protected XSSFFont createFont() {
		XSSFFont font = ((XSSFWorkbook) mWorkbook).createFont();
		font.setFontName(ConstantStyleColor.FONT_NAME);
		font.setFontHeightInPoints(mSize);
		font.setBold(true);
		return font;
	}
}
