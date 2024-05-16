package _CG.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import _CG.exception.CGException;

public class XMLPanel extends JPanel {

	private static final long serialVersionUID = 1390858112560254561L;
	/** Titre de la dialogue permettant de choisir le fichier à lire. */
	private static final String JFILECHOOSER_TITLE = "Choisir un fichier.";
	/** Nom de l'extension XML. */
	private static final String XML_DESCRIPTION_EXTENSION_FILTER = "Fichier XML (.xml)";
	/** Extension XML. */
	private static final String XML_EXTENSION_FILTER = "xml";
	/** Fichier selectionné. */
	protected File mSelectedFile;
	protected JTextField mTextField;
	protected JButton mButton;

	public XMLPanel() {
		initGUI();
	}

	protected void initGUI() {
		setLayout(new GridBagLayout());

		mTextField = new JTextField();
		add(mTextField, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));

		mButton = new JButton(JFILECHOOSER_TITLE);
		mButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chooseFileAndLaunch();
			}
		});
		add(mButton, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

	}

	/**
	 * Ecriture du fichier.
	 * 
	 * @throws CGException {@link CGException}.
	 */
	protected JFileChooser chooseFileAndLaunch() {

		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		chooser.setDialogTitle(JFILECHOOSER_TITLE);
		chooser.setAcceptAllFileFilterUsed(false);

		FileNameExtensionFilter excelFilter = new FileNameExtensionFilter(XML_DESCRIPTION_EXTENSION_FILTER,
				XML_EXTENSION_FILTER);
		chooser.addChoosableFileFilter(excelFilter);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

			// Fichier sélectionné
			mSelectedFile = chooser.getSelectedFile();
		}
		return chooser;
	}
}
