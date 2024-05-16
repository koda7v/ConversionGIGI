package _CG.tools;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;

import _CG.bean.FonctionType;
import _CG.constant.ConstantFonction;

/**
 * Boîte à outils pour la gestion des personnes.
 */
public class PersonneTools {

	/**
	 * Crée la liste des différentes fonctions gérer par GIRAPHIX.
	 */
	public static List<ImmutablePair<String, FonctionType>> getListPairFonction() {
		List<ImmutablePair<String, FonctionType>> fonctions = new ArrayList<ImmutablePair<String, FonctionType>>();

		// Pairs permettant la gestion des fonctions
		ImmutablePair<String, FonctionType> ingenieurPair = new ImmutablePair<String, FonctionType>(
				ConstantFonction.INGENIEUR, FonctionType.INGENIEURS_ET_CADRE);
		fonctions.add(ingenieurPair);
		ImmutablePair<String, FonctionType> employePair = new ImmutablePair<String, FonctionType>(
				ConstantFonction.EMPLOYE, FonctionType.EMPLOYES);
		fonctions.add(employePair);
		ImmutablePair<String, FonctionType> ouvrierPair = new ImmutablePair<String, FonctionType>(
				ConstantFonction.OUVRIER, FonctionType.OUVRIERS);
		fonctions.add(ouvrierPair);
		ImmutablePair<String, FonctionType> technicienPair = new ImmutablePair<String, FonctionType>(
				ConstantFonction.TECHNICIEN, FonctionType.TECHNICIENS);
		fonctions.add(technicienPair);

		return fonctions;
	}

	/**
	 * Permet de récupérer le bonne affichage pour les {@link FonctionType}.
	 * 
	 * @param type {@link FonctionType}.
	 * @return Valeur à afficher.
	 */
	public static String getStringFonction(FonctionType type) {
		String valueToReturn = "";
		switch (type) {
		case EMPLOYES:
			valueToReturn = ConstantFonction.EMPLOYE_EXCEL;
			break;
		case OUVRIERS:
			valueToReturn = ConstantFonction.OUVRIER_EXCEL;
			break;
		case TECHNICIENS:
			valueToReturn = ConstantFonction.TECHNICIEN_EXCEL;
			break;
		default:
			valueToReturn = ConstantFonction.INGENIEUR_EXCEL;
			break;
		}
		return valueToReturn;

	}
}
