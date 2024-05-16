package _CG.gui.filechooser;

import javafx.stage.FileChooser;

/**
 * Classe permettant la gestion du {@link FileChooser} de l'excel.
 */
public class ExcelFileChooserInfo extends ASpecificFileChooser {

	/** Nom de l'extension Excel. */
	private static final String EXCEL_DESCRIPTION_EXTENSION_FILTER = "Fichier Excel (.xls)";
	/** Extension Excel. */
	private static final String EXCEL_EXTENSION_FILTER = "xls";

	/**
	 * Constructeur.
	 */
	public ExcelFileChooserInfo() {
		super();
	}

	@Override
	public String getExtensionDescription() {
		return EXCEL_DESCRIPTION_EXTENSION_FILTER;
	}

	@Override
	public String getFilter() {
		return EXCEL_EXTENSION_FILTER;
	}
}
