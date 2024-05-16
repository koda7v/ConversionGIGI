package _CG.gui.filechooser;

import java.io.File;

import org.apache.commons.lang3.SystemProperties;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.FileChooser;

/**
 * Classe abstraite permettant la gestion des {@link FileChooser}.
 */
public abstract class ASpecificFileChooser implements ISpecificFileChooser {
	/** Fichier sélectionné. */
	protected File mSelectedFile;
	/** Chemin vers le fichier sélectionné. */
	protected String mPath;
	/** Propriétés sur le nom du fichier sélectionné. */
	protected StringProperty mFileNameProperty;

	/**
	 * Constructeur.
	 */
	public ASpecificFileChooser() {
		mFileNameProperty = new SimpleStringProperty();
		mPath = SystemProperties.getUserDir();
	}

	@Override
	public File getFile() {
		return mSelectedFile;
	}

	@Override
	public void setFile(File file) {
		mFileNameProperty.setValue(file.getName());
		mSelectedFile = file;
	}

	@Override
	public String getExtensionDescription() {
		// A surchager
		return "";
	}

	@Override
	public String getFilter() {
		// A surchager
		return "";
	}

	@Override
	public StringProperty getFileNameProperty() {
		return mFileNameProperty;
	}

	@Override
	public String getFileChooserPath() {
		return mPath;
	}

	@Override
	public void setFileChooserPath(String path) {
		mPath = path;
	}
}
