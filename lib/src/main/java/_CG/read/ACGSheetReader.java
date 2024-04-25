package _CG.read;

import org.apache.poi.hssf.usermodel.HSSFRow;

import _CG.read.builder.GiraphixDataBuilder;
import _CG.read.builder.IBuilder;

/**
 * Classe abstraite permettant la lecture d'une page d'un fichier Excel.
 */
public abstract class ACGSheetReader {

	/** Constructeur des données de haut niveau de giraphix. */
	protected GiraphixDataBuilder mGiraphixBuilder;

	/**
	 * Constructeur.
	 * 
	 * @param giraphixBuilder Constructeur des données de haut niveau de giraphix.
	 */
	public ACGSheetReader(GiraphixDataBuilder giraphixBuilder) {
		this.mGiraphixBuilder = giraphixBuilder;
	}

	/**
	 * Lecture d'une ligne. Gestion de chaque cellule à partir des colonnes.
	 * 
	 * @param row {@link HSSFRow}.
	 */
	abstract void readRow(HSSFRow row);

	/**
	 * Permet la reinitialisation des {@link IBuilder} permettant la création des
	 * objets.
	 */
	abstract void resetValue();
}
