package _CG.read;

import _CG.bean.GiraphixDatas;

/**
 * Implementation de l'interface permettant la lecture d'un fichier Excel en
 * lien avec des habilitations.
 */
public interface ICGReader {

	/**
	 * Lecture du fichier Excel (format XLS).
	 */
	void readXLS();

	/**
	 * @return Récupération des données récupérer par le fichier.
	 */
	GiraphixDatas getDatas();
}
