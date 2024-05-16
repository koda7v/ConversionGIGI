package _CG;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import _CG.exception.CGException;
import _CG.gui.LoadingComponent;
import _CG.gui.filechooser.ExcelFileChooserInfo;
import _CG.gui.filechooser.ISpecificFileChooser;
import _CG.gui.filechooser.XMLFileChooserInfo;
import _CG.read.CGExcelReader;
import _CG.read.CGXMLReader;
import _CG.read.ICGReader;
import _CG.tools.ApplicationLoader;
import _CG.tools.GuiLoader;
import _CG.tools.Tools;
import _CG.writer.CGExcelWriter;
import _CG.writer.CGXMLWriter;
import _CG.writer.ICGWriter;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * Vue principale de l'application.
 */
public class CGMainView extends VBox implements Initializable {

	/** Logger. */
	private static final Logger LOGGER = LogManager.getLogger(CGMainView.class);
	/** XSD de giraphix. */
	private static final String XSD = "/xsd/giraphix.xsd";
	/** Titre de la dialogue permettant de choisir le fichier à lire. */
	private static final String JFILECHOOSER_TITLE = "fileChooser.title";
	/** Chemin vers le fichier contenant les bundles pour les IHM. */
	private static final String BUNDLE_GUI_PATH = "dico.gui";
	/** Chemin vers le logo de l'application(PNG). */
	private static final String LOGO_PATH = "/images/folder.png";
	/** Chemin vers le FXML. */
	private static final String MAIN_FXML_PATH = "/fxml/main.fxml";
	/** Tooltip pour le bouton ouvrant le filechooser. */
	private static final String FILECHOOSER_BUTTON_TOOLTIP = "fileChooser.button.tooltip";
	/** Nom du fichier pour les logs. */
	private static final String NAME_FOLDER_LOGS = "logs";
	/**
	 * Clef permettant la récupération des valeurs de la combobox contenant les
	 * agences.
	 */
	private static final String AGENCE_COMBOBOX_VALUES = "combobox.values";
	/**
	 * Clef permettant d'afficher les messages d'erreur pour un problème de format.
	 */
	private static final String MESSAGE_ERROR_FORMAT = "message.error.format";
	/**
	 * Clef permettant d'afficher les messages d'erreur pour un problème de droit.
	 */
	private static final String MESSAGE_ERROR_RIGHT = "message.error.right";
	/**
	 * Clef permettant d'afficher les messages d'erreur pour un problème d'ouverture
	 * du fichier des logs.
	 */
	private static final String MESSAGE_ERROR_LOGS = "message.error.logs";

	/** {@link TabPane} de la vue. */
	@FXML
	protected TabPane mTabPane;
	/** {@link Tab} pour les fichier Excel. */
	@FXML
	protected Tab mXMLTab;
	/** {@link Tab} pour les fichier XML. */
	@FXML
	protected Tab mExcelTab;
	/** Combobox de l'onglet de l'excel permettant la gestion des agences. */
	@FXML
	protected ComboBox<String> mExcelCombobox;
	/** Textfield permettant de connaitre le nom de fichier sélectionner. */
	@FXML
	protected TextField mExcelTextField;
	/**
	 * Bouton dans l'onglet de l'excel permettant la sélection du fichier à
	 * convertir.
	 */
	@FXML
	protected Button mExcelButton;
	/** Textfield permettant de connaitre le nom de fichier sélectionner. */
	@FXML
	protected TextField mXMLTextField;
	/**
	 * Bouton dans l'onglet de XML permettant la sélection du fichier à convertir.
	 */
	@FXML
	protected Button mXMLButton;
	/** Bouton permettant d'ouvrir le répertoire contenant les logs. */
	@FXML
	protected Button mLogsButton;
	/** Bouton permettant la génération. */
	@FXML
	protected Button mGenerateButton;
	/**
	 * {@link ISpecificFileChooser}, permettant la gestion du fichier choisit pour
	 * l'onglet de l'excel.
	 */
	protected ISpecificFileChooser mExcelFileChooserInfo;
	/**
	 * {@link ISpecificFileChooser}, permettant la gestion du fichier choisit pour
	 * l'onglet de XML.
	 */
	protected ISpecificFileChooser mXMLFileChooserInfo;
	/** Répertoire contenant les logs. */
	protected File mLogFile;

	/**
	 * Constructeur.
	 */
	public CGMainView() {
		this.initGUI();
	}

	/**
	 * Initalise le contenu de la vue.
	 */
	protected void initGUI() {
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_GUI_PATH);
		FXMLLoader loader = new FXMLLoader(getClass().getResource(MAIN_FXML_PATH), bundle);

		loader.setRoot(this);
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initButtons();
		initProperties();
		initCombobox();

		mXMLTextField.setEditable(false);
		mExcelTextField.setEditable(false);
		mXMLTextField.setDisable(true);
		mExcelTextField.setDisable(true);
	}

	/**
	 * Initialise les boutons.
	 */
	public void initButtons() {
		Image img = new Image(getClass().getResourceAsStream(LOGO_PATH));
		Tooltip tooltip = new Tooltip(GuiLoader.getInstance().getText(FILECHOOSER_BUTTON_TOOLTIP));

		mExcelFileChooserInfo = new ExcelFileChooserInfo();
		mXMLFileChooserInfo = new XMLFileChooserInfo();

		initFileChooserButton(img, tooltip, mExcelButton, mExcelFileChooserInfo);
		initFileChooserButton(img, tooltip, mXMLButton, mXMLFileChooserInfo);
		initLogsButton();
		initGenerateButton();
	}

	/**
	 * Initialisation du bouton de génération.
	 */
	protected void initGenerateButton() {
		mGenerateButton.setOnAction(e -> {
			ICGReader reader = null;
			ICGWriter writer = null;
			File selectedFile = null;

			// Gestion pour l'onglet des XML
			if (mXMLTab.isSelected()) {
				selectedFile = mXMLFileChooserInfo.getFile();
				if (checkPresenceFile(selectedFile,
						ApplicationLoader.getInstance().getText("message.warning.xml.fileNotSelected"))) {
					 try {
						if (checkXSD()) {
							reader = new CGXMLReader(selectedFile);
							writer = new CGExcelWriter();
						} else {
							Tools.displayMessage(ApplicationLoader.getInstance().getText("message.warning.xsd"),
									AlertType.ERROR, LOGGER);
						 }
					} catch (CGException e1) {
						Tools.displayMessage(ApplicationLoader.getInstance().getText("message.error.xsd"),
								AlertType.ERROR, LOGGER, e1);
					}
				}
			} else if (mExcelTab.isSelected()) {
				// Gestion pour l'onglet des excel.
				selectedFile = mExcelFileChooserInfo.getFile();
				if (checkPresenceFile(selectedFile,
						ApplicationLoader.getInstance().getText("message.warning.excel.fileNotSelected"))) {
					if (checkPresenceAgence()) {
						reader = new CGExcelReader(selectedFile, mExcelCombobox.getValue());
						writer = new CGXMLWriter();
					}
				}
			}
			// Lancement de la lecture et de l'écriture.
			try {
				if(reader != null && writer != null) {
					readAndWriteFile(reader, writer);
				} else {
					LOGGER.debug(ApplicationLoader.getInstance().getText("message.debug.reader.writer"));
				}
			} catch (CGException ex) {
				Tools.displayMessage(ex.getMessage(), AlertType.ERROR, LOGGER, ex.getCause());
			}
		});
	}

	/**
	 * Initialisation de bouton gérant les logs.
	 */
	protected void initLogsButton() {
		File file = new File(".");
		File[] listFiles = file.listFiles();
		for (File currentFile : listFiles) {
			if (currentFile.getName().equals(NAME_FOLDER_LOGS)) {
				mLogFile = currentFile;
			}
		}
		mLogsButton.setOnAction(e -> {
			try {
				Desktop.getDesktop().open(mLogFile);
			} catch (IOException e1) {
				String msg = ApplicationLoader.getInstance().getText(MESSAGE_ERROR_LOGS, file.getName());
				Tools.displayMessage(msg, AlertType.ERROR, LOGGER);
			}
		});
	}

	/**
	 * Vérifie la sélection d'une agence.
	 * 
	 * @return True, si un fichier est présent.
	 */
	protected boolean checkPresenceAgence() {
		if (mExcelCombobox.getSelectionModel().isEmpty()) {
			Tools.displayMessage(ApplicationLoader.getInstance().getText("message.warning.agence.not.selected"),
					AlertType.WARNING, LOGGER);
			return false;
		}
		return true;
	}

	/**
	 * Vérifie la présence du fichier sélectionner.
	 * 
	 * @param selectedFile Fichier sélectionné.
	 * @return True, si un fichier est présent.
	 */
	protected boolean checkPresenceFile(File selectedFile, String msg) {
		if (selectedFile == null) {
			Tools.displayMessage(msg, AlertType.WARNING, LOGGER);
			return false;
		}
		return true;
	}

	/**
	 * Initlialise les différents boutons permettant la sélection des fichiers.
	 * 
	 * @param img                 Image à positionner.
	 * @param tooltip             Tooltip.
	 * @param button              Bouton.
	 * @param specificFileChooser {@link ISpecificFileChooser}.
	 */
	protected void initFileChooserButton(Image img, Tooltip tooltip, Button button,
			ISpecificFileChooser specificFileChooser) {
		ImageView view = new ImageView(img);
		view.setFitHeight(20);
		view.setPreserveRatio(true);

		button.setPrefSize(20, 20);
		button.setGraphic(view);
		button.setTooltip(tooltip);
		button.setOnAction(e -> {
			FileChooser chooser = new FileChooser();
			chooser.setInitialDirectory(new File(specificFileChooser.getFileChooserPath()));
			chooser.setTitle(GuiLoader.getInstance().getText(JFILECHOOSER_TITLE));
			ExtensionFilter filter = new ExtensionFilter(specificFileChooser.getExtensionDescription(),
					"*." + specificFileChooser.getFilter());
			chooser.getExtensionFilters().add(filter);
			File file = chooser.showOpenDialog(null);
			if (file != null) {
				if (file.canRead()) {
					if (checkExtension(specificFileChooser.getFilter(), file)) {
						specificFileChooser.setFile(file);
						specificFileChooser.setFileChooserPath(file.getParentFile().getPath());
					} else {
						String msg = ApplicationLoader.getInstance().getText(MESSAGE_ERROR_FORMAT, file.getName());
						Tools.displayMessage(msg, AlertType.ERROR, LOGGER);
					}
				} else {
					String msg = ApplicationLoader.getInstance().getText(MESSAGE_ERROR_RIGHT, file.getName());
					Tools.displayMessage(msg, AlertType.ERROR, LOGGER);
				}
			}
		});
	}

	/**
	 * Initalise les properties.
	 */
	public void initProperties() {
		this.mExcelTextField.textProperty().bind(mExcelFileChooserInfo.getFileNameProperty());
		this.mXMLTextField.textProperty().bind(mXMLFileChooserInfo.getFileNameProperty());
	}

	/**
	 * Initialise la combobox.
	 */
	public void initCombobox() {
		List<String> agences = List.of(GuiLoader.getInstance().getText(AGENCE_COMBOBOX_VALUES).split(","));
		for (String currentAgence : agences) {
			this.mExcelCombobox.getItems().add(currentAgence);
		}
	}

	/**
	 * Lecture et écriture des données.
	 * 
	 * @throws CGException {@link CGException}.
	 */
	protected void readAndWriteFile(ICGReader reader, ICGWriter writer) throws CGException {

		LoadingComponent pForm = new LoadingComponent();

		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws InterruptedException, CGException {

				// Lecture du fichier
				reader.read();
				// Mise en place des données
				writer.setDatas(reader.getDatas());
				// Ecriture du XML
				writer.write();

				return null;
			}
		};

		pForm.activateProgressBar(task);

		task.setOnSucceeded(event -> {
			pForm.getDialogStage().close();
		});
		
		task.setOnFailed(event -> {
			LOGGER.error(event.getSource().getMessage(), event.getSource().getException());
		});

		pForm.getDialogStage().show();

		Thread thread = new Thread(task);
		Platform.runLater(thread);
	}

	/**
	 * Vérification du XSD de giraphix sur le fichier donnée.
	 * 
	 * @return True, si le fichier est correcte.
	 * @throws CGException
	 */
	protected boolean checkXSD() throws CGException {
		boolean value = false;
		try {
			Validator validator = createValidator();
			validator.validate(new StreamSource(mXMLFileChooserInfo.getFile()));
			value = true;
		} catch (SAXException | IOException e) {
			throw new CGException("Impossible de vérifier le fichier XSD.", e);
		}
		return value;
	}

	/**
	 * @return {@link Validator}.
	 * @throws SAXException
	 */
	protected Validator createValidator() throws SAXException {
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Source schemaFile = new StreamSource(getClass().getResourceAsStream(XSD));
		Schema schema = factory.newSchema(schemaFile);
		return schema.newValidator();
	}

	/**
	 * Vérification de l'extension du fichier choisit.
	 * 
	 * @param extensionFilter Extension à vérifier.
	 * @param selectedFile    Fichier sélectionné.
	 * @return True, si le fichier sélectionné est bien du type demandé.
	 */
	protected boolean checkExtension(String extensionFilter, File selectedFile) {
		// Vérification de l'extension
		String fileName = selectedFile.getName();

		// Extraction de l'extension du fichier.
		int index = fileName.lastIndexOf('.');

		String extension = "";
		if (index > 0) {
			extension = fileName.substring(index + 1);
		}
		return extensionFilter.equals(extension);
	}
}
