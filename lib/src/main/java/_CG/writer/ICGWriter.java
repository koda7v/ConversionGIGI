package _CG.writer;

import _CG.bean.GiraphixDatas;
import _CG.exception.CGException;

/**
 * Interface permettant la gestion de l'écriture d'un XML à partir de JAXB.
 */
public interface ICGWriter {

	/**
	 * Ecriture d'un fichier XML à partir de JAXB.
	 */
	void write() throws CGException;

	/**
	 * Affectation des données.
	 * 
	 * @param giraphixDatas {@link GiraphixDatas}.
	 */
	void setDatas(GiraphixDatas giraphixDatas);
}
