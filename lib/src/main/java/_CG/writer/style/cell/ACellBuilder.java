package _CG.writer.style.cell;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import _CG.constant.ConstantStyleColor;

/**
 * Classe abstraite permettant la création des cellules pour un fichier Excel.
 */
public abstract class ACellBuilder {

	/** {@link Workbook} sur lequel on travaille. */
	protected Workbook mWorkbook;
	/** Taille prise par les données dans un cellule. */
	protected short mSize;
	/** Alignement horizontal dans une cellule. */
	protected HorizontalAlignment mHorizontalAlignement;

	/**
	 * Constructeur.
	 * 
	 * @param workbook {@link Workbook}.
	 */
	public ACellBuilder(Workbook workbook) {
		this.mWorkbook = workbook;
		this.mSize = 10;
		this.mHorizontalAlignement = HorizontalAlignment.LEFT;
	}

	/**
	 * Création du style pour une cellule.
	 * 
	 * @param color {@link XSSFColor}.
	 * @return {@link CellStyle}.
	 */
	protected CellStyle createBuilderCellStyle(XSSFColor color) {
		XSSFFont font = createFont();
		CellStyleBuilder builder = new CellStyleBuilder(color, mWorkbook, FillPatternType.SOLID_FOREGROUND,
				HorizontalAlignment.LEFT, VerticalAlignment.CENTER, BorderStyle.THIN, font);
		return builder.getCellStyle();

	}

	/**
	 * Création du style pour une cellule.
	 * 
	 * @param color short.
	 * @return {@link CellStyle}.
	 */
	protected CellStyle createBuilderCellStyle(short color) {
		XSSFFont font = createFont();
		CellStyleBuilder builder = new CellStyleBuilder(color, mWorkbook, FillPatternType.SOLID_FOREGROUND,
				HorizontalAlignment.LEFT, VerticalAlignment.CENTER, BorderStyle.THIN, font);
		return builder.getCellStyle();

	}

	/**
	 * Création d'un font pour les cellules.
	 * 
	 * @return {@link XSSFFont}.
	 */
	protected XSSFFont createFont() {
		XSSFFont font = ((XSSFWorkbook) mWorkbook).createFont();
		font.setFontName(ConstantStyleColor.FONT_NAME);
		font.setFontHeightInPoints(mSize);
		font.setBold(false);
		return font;
	}
}
