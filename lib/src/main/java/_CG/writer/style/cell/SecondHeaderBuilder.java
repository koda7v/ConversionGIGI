package _CG.writer.style.cell;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import _CG.constant.ConstantStyleColor;

/**
 * Constructeur pour la création des cellules pour le seconde en-tête.
 */
public class SecondHeaderBuilder extends ACellBuilder {

	/**
	 * COnstructeur.
	 * 
	 * @param workbook {@link Workbook}.
	 */
	public SecondHeaderBuilder(Workbook workbook) {
		super(workbook);
		this.mSize = (short) 10;
		this.mHorizontalAlignement = HorizontalAlignment.CENTER;
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
