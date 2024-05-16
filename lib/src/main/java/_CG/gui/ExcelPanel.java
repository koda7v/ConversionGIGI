package _CG.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import _CG.exception.CGException;

public class ExcelPanel extends JPanel {

	private static final long serialVersionUID = -3570487188210241960L;
	/** Titre de la dialogue permettant de choisir le fichier à lire. */
	private static final String JFILECHOOSER_TITLE = "Choisir un fichier.";
	/** Nom de l'extension Excel. */
	private static final String EXCEL_DESCRIPTION_EXTENSION_FILTER = "Fichier Excel (.xls)";
	/** Extension Excel. */
	private static final String EXCEL_EXTENSION_FILTER = "xls";
	private String[] datas = { "Paris", "Bordeaux" };

	/** Fichier selectionné. */
	protected File mSelectedFile;
	protected JTextField mTextField;
	protected JButton mButton;
	/** Combobox des agences pour lequel on veut convertir les données. */
	protected JComboBox<String> mAgenceCombox;

	public ExcelPanel() {
		initGUI();
	}

	protected void initGUI() {
		setLayout(new GridBagLayout());
		this.mAgenceCombox = new JComboBox<String>(datas);
		add(mAgenceCombox, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

		mTextField = new JTextField();
		add(mTextField, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));

		mButton = new JButton(JFILECHOOSER_TITLE);
		mButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chooseFileAndLaunch();
			}
		});
		add(mButton, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
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

		FileNameExtensionFilter excelFilter = new FileNameExtensionFilter(EXCEL_DESCRIPTION_EXTENSION_FILTER,
				EXCEL_EXTENSION_FILTER);
		chooser.addChoosableFileFilter(excelFilter);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

			// Fichier sélectionné
			mSelectedFile = chooser.getSelectedFile();
		}
		return chooser;
	}
}
