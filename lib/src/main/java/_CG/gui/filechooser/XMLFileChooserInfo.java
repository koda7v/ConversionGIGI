package _CG.gui.filechooser;

import javafx.stage.FileChooser;

/**
 * Classe permettant la gestion du {@link FileChooser} du XML.
 */
public class XMLFileChooserInfo extends ASpecificFileChooser {

	/** Nom de l'extension XML. */
	private static final String XML_DESCRIPTION_EXTENSION_FILTER = "Fichier XML (.xml)";
	/** Extension XML. */
	private static final String XML_EXTENSION_FILTER = "xml";

	/**
	 * Constructeur.
	 */
	public XMLFileChooserInfo() {
		super();
	}

	@Override
	public String getExtensionDescription() {
		return XML_DESCRIPTION_EXTENSION_FILTER;
	}

	@Override
	public String getFilter() {
		return XML_EXTENSION_FILTER;
	}


}
