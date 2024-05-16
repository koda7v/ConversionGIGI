package _CG.tools;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.Logger;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * Boîte à outils de l'application.
 */
public final class Tools {

	/**
	 * Affichage d'un message.
	 * 
	 * @param msg    Message à afficher.
	 * @param type   Type de message. Voir les valeur du {@link AlertType}.
	 * @param logger Logger de la classe sur lequel on affiche le message.
	 */
	public static void displayMessage(String msg, AlertType type, Logger logger) {
		Alert alert = null;
		switch (type) {
		case INFORMATION:
			logger.info(msg);
			alert = new Alert(AlertType.INFORMATION, msg, ButtonType.OK);
			break;
		case WARNING:
			logger.warn(msg);
			alert = new Alert(AlertType.WARNING, msg, ButtonType.OK);
			break;
		case ERROR:
			logger.error(msg);
			alert = new Alert(AlertType.ERROR, msg, ButtonType.OK);
			break;
		default:
			logger.warn(msg);
			alert = new Alert(AlertType.WARNING, msg, ButtonType.OK);
			break;
		}
		alert.showAndWait();
	}

	/**
	 * Affichage d'un message.
	 * 
	 * @param msg    Message à afficher.
	 * @param error  Type de message. Voir les valeur du {@link JOptionPane}.
	 * @param logger Logger de la classe sur lequel on affiche le message.
	 * @param cause  Exception.
	 */
	public static void displayMessage(String msg, AlertType type, Logger logger, Throwable cause) {
		Alert alert = null;
		switch (type) {
		case INFORMATION:
			logger.info(msg, cause);
			alert = new Alert(AlertType.INFORMATION, msg, ButtonType.OK);
			break;
		case WARNING:
			logger.warn(msg, cause);
			alert = new Alert(AlertType.WARNING, msg, ButtonType.OK);
			break;
		case ERROR:
			logger.error(msg, cause);
			alert = new Alert(AlertType.ERROR, msg, ButtonType.OK);
			break;
		default:
			logger.warn(msg, cause);
			alert = new Alert(AlertType.WARNING, msg, ButtonType.OK);
			break;
		}
		alert.showAndWait();
	}
}
