package _CG.gui.filechooser;

import java.io.File;

import javafx.beans.property.StringProperty;
import javafx.stage.FileChooser;

/**
 * Interface permettant la gestion des {@link FileChooser}.
 */
public interface ISpecificFileChooser {

	/**
	 * @return Récupération du fichier sélectionner.
	 */
	File getFile();

	/**
	 * Affectation du fichier sélectionner.
	 * 
	 * @param file Le fichier sélectionné.
	 */
	void setFile(File file);

	/**
	 * @return Description de l'extension.
	 */
	String getExtensionDescription();

	/**
	 * @return Filtre.
	 */
	String getFilter();

	/**
	 * @return {@link StringProperty} pour le nom du filename.
	 */
	StringProperty getFileNameProperty();

	/**
	 * @return Chemin du répertoire menant au fichier choisit.
	 */
	String getFileChooserPath();

	/**
	 * Affectation du chemin vers le fichier choisit.
	 * 
	 * @param path Chemin.
	 */
	void setFileChooserPath(String path);
}
