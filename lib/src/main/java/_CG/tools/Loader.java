package _CG.tools;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Les différentes méthodes permettant l'utilisation des loaders.
 */
public abstract class Loader {
	/** Logger. */
	private static final Logger LOGGER = LogManager.getLogger(Loader.class);
	/**
	 * Attribut dans lequel se charge les informations pour le fichier de
	 * configuration.
	 */
	protected Properties fileProperties;

	/**
	 * Chargement des différentes informations.
	 * 
	 * @param file
	 */
	protected void loadProperties(String file) {
		fileProperties = new Properties();
		try (InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream(file)) {
			if (inputStream != null) {
				fileProperties.load(inputStream);
			} else {
				LOGGER.error("Le fichier de configuration " + file
						+ " prévu pour le chargement des configurations n'a pas été trouvé");
			}

		} catch (IOException e) {
			LOGGER.error("Le fichier n'a pas pu être chargé", e);
		}
	}

	/**
	 * Récupération d'un texte à partir d'une clef.
	 * 
	 * @param key Une chaîne de caractères qui va permettre la récupération d'une
	 *            configuration précise.
	 * @return Une chaîne de caractères correspond à une configuration nécessaire à
	 *         l'application.
	 */
	public String getText(String key) {

		String text = null;
		if (fileProperties.containsKey(key)) {
			text = fileProperties.getProperty(key);
		} else {
			LOGGER.error("La clef" + key + " n'a pas de valeur associée");
			text = key;
		}

		return text;
	}

	/**
	 * Récupération d'un texte à partir d'une clef.
	 * 
	 * @param key Une chaîne de caractères qui va permettre la récupération d'une
	 *            configuration précise.
	 * @return Une chaîne de caractères correspond à une configuration nécessaire à
	 *         l'application.
	 */
	public String getText(String key, String... arguments) {

		String text = null;
		if (fileProperties.containsKey(key)) {
			text = MessageFormat.format(fileProperties.getProperty(key), (Object[]) arguments);
		} else {
			LOGGER.error("La clef " + key + " n'a pas de valeur associée");
			text = key;
		}

		return text;
	}

}
