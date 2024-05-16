package _CG.tools;

/**
 * {@link Loader} permettant la récupération des données pour la gestion des
 * données de l'application.
 */
public class GuiLoader extends Loader {
	/**
	 * Contient les informations sur la configuration de l'application.
	 */
	protected static GuiLoader instance;

	/**
	 * Singleton qui charge les éléments qui sont contenus dans le fichier de
	 * configuration de l'application, afin de les rendre manipulables dans la
	 * classe.
	 */
	private GuiLoader() {
		loadProperties(ConstantLoader.GUI_FILE);
	}

	/**
	 * LazyLoading, il va permettre de charger la classe ConfigurationLoader et la
	 * créer si nécessaire.
	 * 
	 * @return L'instance qui va permettre la manipulation des informations liées à
	 *         la configuration de l'application.
	 */
	public static GuiLoader getInstance() {
		if (instance == null) {
			instance = new GuiLoader();
		}
		return instance;
	}
}
