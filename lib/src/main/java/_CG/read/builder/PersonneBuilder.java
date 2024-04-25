package _CG.read.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.poi.hssf.usermodel.HSSFCell;

import _CG.bean.CiviliteType;
import _CG.bean.FonctionType;
import _CG.bean.ObjectFactory;
import _CG.bean.PersonneType;
import _CG.read.constant.ConstantFonction;

/**
 * Constructeur de données pour {@link PersonneType}.
 */
public class PersonneBuilder extends ABuilder implements IBuilder {

	/** Personne en cours de construction. */
	protected PersonneType mPersonne;

	protected List<ImmutablePair<String, FonctionType>> mFonctions;

	/**
	 * Constructeur.
	 * 
	 * @param fabrique Fabrique permettant d'initialiser les entités de
	 *                 l'application GIRAPHIX.
	 */
	public PersonneBuilder(ObjectFactory fabrique) {
		super(fabrique);
	}

	@Override
	public void reset() {
		this.mPersonne = mFabrique.createPersonneType();

		initListFonction();

		// Mise en place des données par défaut.
		this.mPersonne.setCivilite(CiviliteType.M);
		this.mPersonne.setInterne(true);
		this.mPersonne.setActif(true);
	}

	/**
	 * Initialise la liste des différentes fonctions gérer par GIRAPHIX.
	 */
	private void initListFonction() {
		this.mFonctions = new ArrayList<ImmutablePair<String, FonctionType>>();

		// Pairs permettant la gestion des fonctions
		ImmutablePair<String, FonctionType> ingenieurPair = new ImmutablePair<String, FonctionType>(
				ConstantFonction.INGENIEUR,
				FonctionType.INGENIEURS_ET_CADRE);
		this.mFonctions.add(ingenieurPair);
		ImmutablePair<String, FonctionType> employePair = new ImmutablePair<String, FonctionType>(
				ConstantFonction.EMPLOYE,
				FonctionType.EMPLOYES);
		this.mFonctions.add(employePair);
		ImmutablePair<String, FonctionType> ouvrierPair = new ImmutablePair<String, FonctionType>(
				ConstantFonction.OUVRIER,
				FonctionType.OUVRIERS);
		this.mFonctions.add(ouvrierPair);
		ImmutablePair<String, FonctionType> technicienPair = new ImmutablePair<String, FonctionType>(
				ConstantFonction.TECHNICIEN,
				FonctionType.TECHNICIENS);
		this.mFonctions.add(technicienPair);
	}

	/**
	 * Affectation de l'identitfiant de la personne.
	 * 
	 * @param personneID Identifiant de la personne.
	 */
	public void setId(String id) {
		this.mPersonne.setId(id);
	}

	/**
	 * Affectation du nom et prénom.
	 * 
	 * @param cell Cellule où l'on va récupérer la'information.
	 */
	public void setNomPrenom(HSSFCell cell) {
		// Voir pour les nom à rallonge

		String[] split = getStringFromCell(cell).split("\\s+");

		if (split.length == 2) {
			// Classique NOM Prenom
			this.mPersonne.setNom(split[0]);
			this.mPersonne.setPrenom(split[1]);

		} else if (split.length == 1) {
			// SI une valeur trouvé, on considère que c'est le nom
			this.mPersonne.setNom(split[0]);

		} else if (split.length > 2) {
			// Si plus on gère les prénoms multiple.
			this.mPersonne.setNom(split[0]);

			// On considère que le reste des mots font parties du prénom
			List<String> allPrenom = new ArrayList<>(Arrays.asList(split));

			// Suppression du nom
			allPrenom.remove(0);

			// Ajout du prénom
			this.mPersonne.setPrenom(String.join(" ", allPrenom));
		}
	}

	/**
	 * Affectation de la date de naissance.
	 * 
	 * @param cell Cellule où l'on va récupérer la'information.
	 */
	public void setDateNaissance(HSSFCell cell) {
		long dateFromCell = getLongDateFromCell(cell);
		if (dateFromCell != 0) {
			this.mPersonne.setDateDeNaissance(dateFromCell);
		}
	}

	/**
	 * Affectation de la fonction.
	 * 
	 * @param cell Cellule où l'on va récupérer la'information.
	 */
	public void setFonction(HSSFCell cell) {

		// Valeur déterminant si une fonction équivalent est présente dans GIRAPHIX
		boolean isFounded = false;

		String[] valueSplit = getStringFromCell(cell).toLowerCase().split(" ");
		for (String currentValue : valueSplit) {

			isFounded = this.mFonctions.stream().anyMatch(fonction -> {
				if (StringUtils.indexOfIgnoreCase(StringUtils.stripAccents(currentValue),
						StringUtils.stripAccents(fonction.getKey())) != -1) {
					this.mPersonne.setFonction(fonction.getValue());
					return true;
				}
				return false;
			});
		}

		// Si aucune fonction équivalente n'est trouvé
		if (!isFounded) {

			// Valeurs par défaut
			this.mPersonne.setFonction(FonctionType.INGENIEURS_ET_CADRE);
		}
	}

	/**
	 * @return Personne en cours de création.
	 */
	public PersonneType getPersonne() {
		return this.mPersonne;
	}
}
