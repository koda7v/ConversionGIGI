package _CG.read;

import _CG.bean.GiraphixDatas;
import _CG.exception.CGException;

/**
 * Implementation de l'interface permettant la lecture d'un fichier en lien avec
 * des habilitations.
 */
public interface ICGReader {

	/**
	 * Lecture d'un fichier.
	 */
	void read() throws CGException;

	/**
	 * @return Récupération des données récupérer par le fichier.
	 */
	GiraphixDatas getDatas();
}
