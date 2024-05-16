package _CG.gui;

import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Composant faisant office de page de chargement.
 */
public class LoadingComponent extends StackPane {

	/** Dialog. */
	protected final Stage mDialogStage;
	/** Indicateur visuel. */
	protected final ProgressIndicator mProgressIndicator;

	/**
	 * Constructeur.
	 */
	public LoadingComponent() {
        mDialogStage = new Stage();
		mDialogStage.initStyle(StageStyle.TRANSPARENT);
        mDialogStage.setResizable(false);
        mDialogStage.initModality(Modality.APPLICATION_MODAL);

		mProgressIndicator = new ProgressIndicator();
        mProgressIndicator.setProgress(-1F);
		mProgressIndicator.setStyle("-fx-background-color: transparent");
        
        final HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(mProgressIndicator);

        Scene scene = new Scene(hb);
        scene.setFill(Color.TRANSPARENT);
		scene.getStylesheets().add("progress.css");
        mDialogStage.setScene(scene);
		mDialogStage.setOpacity(1);
    }

	/**
	 * Gestion de la preogression.
	 * 
	 * @param task {@link Task}.
	 */
	public void activateProgressBar(final Task<?> task) {
		mProgressIndicator.progressProperty().bind(task.progressProperty());
		mDialogStage.show();
	}

	/**
	 * @return {@link Stage}.
	 */
	public Stage getDialogStage() {
		return mDialogStage;
	}
}
