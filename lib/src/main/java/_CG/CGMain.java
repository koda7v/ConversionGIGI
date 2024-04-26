package _CG;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import _CG.read.CGReader;
import _CG.read.ICGReader;
import _CG.writer.CGWriter;
import _CG.writer.ICGWriter;

/**
 * Classe principal de l'application.
 */
public class CGMain {

	/** Titre de la dialogue permettant de choisir le fichier à lire. */
	private static final String JFILECHOOSER_TITLE = "Choisir un fichier.";
	/** Nom de l'extension autorisée. */
	private static final String DESCRIPTION_EXTENSION_FILTER = "Fichier Excel";
	/** Extension autorisée. */
	private static final String EXTENSION_FILTER = "xls";

	/**
	 * Lancement de la mini application permettant la conversion des données.
	 */
	public void launch() {

		// Initialisation de la boîte de dialogue permettant de choisir le fichier
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle(JFILECHOOSER_TITLE);
			chooser.setAcceptAllFileFilterUsed(false);

			FileNameExtensionFilter filter = new FileNameExtensionFilter(DESCRIPTION_EXTENSION_FILTER,
					EXTENSION_FILTER);
			chooser.addChoosableFileFilter(filter);

			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

				// Fichier sélectionné
				File selectedFile = chooser.getSelectedFile();

				// Vérification des droits
				if (selectedFile.canRead()) {

					// Vérification de l'extension du fichier.
					if (checkExtension(selectedFile)) {

						ICGReader reader = new CGReader(selectedFile);

						// Lecture du fichier
						reader.readXLS();

						// Récupération des données
						ICGWriter writer = new CGWriter(reader.getDatas());

						// Ecriture du XML
						writer.writeXML();
					}
				}
			} else {
				System.out.println("No Selection ");
			}
		} catch (Throwable ex) {
			System.out.println("Soucis avec le look and feel ");
		}
	}

	/**
	 * Vérification de l'extension du fichier choisit.
	 * 
	 * @param selectedFile Fichier sélectionné.
	 * @return True, si le fichier sélectionné est bien un excel.
	 */
	protected boolean checkExtension(File selectedFile) {
		// Vérification de l'extension
		String fileName = selectedFile.getName();

		// Extraction de l'extension du fichier.
		int index = fileName.lastIndexOf('.');

		String extension = "";
		if (index > 0) {
			extension = fileName.substring(index + 1);
		}
		return EXTENSION_FILTER.equals(extension);
	}
}
