package _CG.tools;

/**
 * {@link Loader} permettant la récupération des données pour la gestion des
 * données de l'application.
 */
public class ApplicationLoader extends Loader {
	/**
	 * Contient les informations sur la configuration de l'application.
	 */
	protected static ApplicationLoader instance;

	/**
	 * Singleton qui charge les éléments qui sont contenus dans le fichier de
	 * configuration de l'application, afin de les rendre manipulables dans la
	 * classe.
	 */
	private ApplicationLoader() {
		loadProperties(ConstantLoader.APPLICATION_FILE);
	}

	/**
	 * LazyLoading, il va permettre de charger la classe ConfigurationLoader et la
	 * créer si nécessaire.
	 * 
	 * @return L'instance qui va permettre la manipulation des informations liées à
	 *         la configuration de l'application.
	 */
	public static ApplicationLoader getInstance() {
		if (instance == null) {
			instance = new ApplicationLoader();
		}
		return instance;
	}
}
