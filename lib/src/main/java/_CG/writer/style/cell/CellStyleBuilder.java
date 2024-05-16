package _CG.writer.style.cell;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;

/**
 * Classe permettant la gestion de différents style pour les cellules d'une
 * feuille Excel.
 */
public class CellStyleBuilder {

	/** {@link XSSFCellStyle}. */
	protected XSSFCellStyle mHeaderStyle;

	/**
	 * Constructeur.
	 * 
	 * @param color               {@link XSSFColor}.
	 * @param workbook            {@link Workbook}.
	 * @param fillPatternType     {@link FillPatternType}.
	 * @param horizontalAlignment {@link HorizontalAlignment}.
	 * @param verticalAlignment   {@link VerticalAlignment}.
	 * @param borderStyle         {@link BorderStyle}.
	 * @param xssfFont            {@link XSSFFont}.
	 */
	public CellStyleBuilder(XSSFColor color, Workbook workbook, FillPatternType fillPatternType,
			HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, BorderStyle borderStyle,
			XSSFFont xssfFont) {
		this(workbook, fillPatternType, horizontalAlignment, verticalAlignment, borderStyle, xssfFont);
		setFillForegroundColor(color);
	}

	/**
	 * Constructeur.
	 * 
	 * @param color               short.
	 * @param workbook            {@link Workbook}.
	 * @param fillPatternType     {@link FillPatternType}.
	 * @param horizontalAlignment {@link HorizontalAlignment}.
	 * @param verticalAlignment   {@link VerticalAlignment}.
	 * @param borderStyle         {@link BorderStyle}.
	 * @param xssfFont            {@link XSSFFont}.
	 */
	public CellStyleBuilder(short color, Workbook workbook, FillPatternType fillPatternType,
			HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, BorderStyle borderStyle,
			XSSFFont xssfFont) {
		this(workbook, fillPatternType, horizontalAlignment, verticalAlignment, borderStyle, xssfFont);
		setFillForegroundColor(color);
	}

	/**
	 * Constructeur.
	 * 
	 * @param workbook            {@link Workbook}.
	 * @param fillPatternType     {@link FillPatternType}.
	 * @param horizontalAlignment {@link HorizontalAlignment}.
	 * @param verticalAlignment   {@link VerticalAlignment}.
	 * @param borderStyle         {@link BorderStyle}.
	 * @param xssfFont            {@link XSSFFont}.
	 */
	public CellStyleBuilder(Workbook workbook, FillPatternType fillPatternType, HorizontalAlignment horizontalAlignment,
			VerticalAlignment verticalAlignment, BorderStyle borderStyle, XSSFFont xssfFont) {
		this.mHeaderStyle = (XSSFCellStyle) workbook.createCellStyle();
		setFillPattern(fillPatternType);
		setHorizontalAlignement(horizontalAlignment);
		setVerticaleAlignement(verticalAlignment);
		setBorder(borderStyle);
		setFont(xssfFont);
		this.mHeaderStyle.setWrapText(true);
	}

	/**************************
	 * Affectation des valeurs.
	 *************************/

	public void setFont(XSSFFont xssfFont) {
		this.mHeaderStyle.setFont(xssfFont);
	}

	public void setFillForegroundColor(XSSFColor color) {
		this.mHeaderStyle.setFillForegroundColor(color);
	}

	public void setFillForegroundColor(short color) {
		this.mHeaderStyle.setFillForegroundColor(color);
	}

	public void setFillPattern(FillPatternType fillPatternType) {
		this.mHeaderStyle.setFillPattern(fillPatternType);
	}

	public void setHorizontalAlignement(HorizontalAlignment horizontalAlignment) {
		this.mHeaderStyle.setAlignment(horizontalAlignment);
	}

	public void setVerticaleAlignement(VerticalAlignment verticalAlignment) {
		this.mHeaderStyle.setVerticalAlignment(verticalAlignment);
	}

	public void setBorder(BorderStyle borderStyle) {
		this.mHeaderStyle.setBorderBottom(borderStyle);
		this.mHeaderStyle.setBorderTop(borderStyle);
		this.mHeaderStyle.setBorderRight(borderStyle);
		this.mHeaderStyle.setBorderLeft(borderStyle);
	}

	/**
	 * @return {@link CellStyle}.
	 */
	public CellStyle getCellStyle() {
		return mHeaderStyle;
	}

}
