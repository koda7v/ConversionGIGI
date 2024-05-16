package _CG;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import _CG.tools.ApplicationLoader;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Classe principal de l'application.
 */
public class CGMain extends Application {

	/** Logger. */
	private static final Logger LOGGER = LogManager.getLogger(CGMain.class);
	/** Clef pour récupérer le chemin vers le logo. */
	private static final String LOGO_PATH = "giraphix.logo";
	/** Clef pour récupérer le titre de l'application */
	private static final String TITLE_NAME = "giraphix.title";
	/** Fichier selectionné. */
	protected File mSelectedFile;






	@Override
	public void start(Stage primaryStage) throws Exception {
		LOGGER.info("Lancement de l'application");
		VBox root = new CGMainView();
		primaryStage.setTitle(ApplicationLoader.getInstance().getText(TITLE_NAME));
		String logoPath = ApplicationLoader.getInstance().getText(LOGO_PATH);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream(logoPath)));
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	@Override
	public void stop() {
		LOGGER.info("Arrêt de l'application");
		Platform.exit();
	}
}
