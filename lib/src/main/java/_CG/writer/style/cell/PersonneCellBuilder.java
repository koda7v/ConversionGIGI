package _CG.writer.style.cell;

import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import _CG.bean.FonctionType;
import _CG.bean.PersonneType;
import _CG.tools.PersonneTools;

/**
 * Constructeur pour la création des cellules lié à une personne.
 */
public class PersonneCellBuilder extends DataCellBuilder {

	/** Fonction d'une personne. */
	protected List<ImmutablePair<String, FonctionType>> mFonctions;

	/**
	 * Constructeur.
	 * 
	 * @param workbook {@link Workbook}.
	 */
	public PersonneCellBuilder(Workbook workbook) {
		super(workbook);
		this.mFonctions = PersonneTools.getListPairFonction();
	}

	/**
	 * Affectation des fonctions pour une personne.
	 * 
	 * @param row             Ligne.
	 * @param indexCol        Index de la colonne.
	 * @param currentPersonne La personne.
	 */
	public void setFonctionMission(Row row, int indexCol, PersonneType currentPersonne) {
		for (ImmutablePair<String, FonctionType> fonction : mFonctions) {
			if (fonction.getValue() == currentPersonne.getFonction()) {
				createCell(row, indexCol, PersonneTools.getStringFonction(fonction.getValue()));
				break;
			}
		}
	}

	/**
	 * Affectation du nom.
	 * 
	 * @param row      Ligne.
	 * @param indexCol Index de la colonne.
	 * @param nom      Nom.
	 */
	public void setNom(Row row, int indexCol, String nom) {
		createCell(row, indexCol, nom);
	}

	/**
	 * Affectation du prénom.
	 * 
	 * @param row      Ligne.
	 * @param indexCol Index de la colonne.
	 * @param prenom   Prenom.
	 */
	public void setPrenom(Row row, int indexCol, String prenom) {
		createCell(row, indexCol, prenom);
	}

}
