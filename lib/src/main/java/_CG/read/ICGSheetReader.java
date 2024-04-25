package _CG.read;

import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 * Implementation de l'interface permettant la lecture d'une page d'un fichier
 * Excel.
 */
public interface ICGSheetReader {
	/**
	 * Lecture des différentes lignes pour la page données.
	 * 
	 * @param sheet Page à gérer.
	 */
	void readRows(HSSFSheet sheet);
}
