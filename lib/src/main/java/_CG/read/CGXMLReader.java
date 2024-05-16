package _CG.read;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import _CG.bean.GiraphixDatas;
import _CG.exception.CGException;
import _CG.tools.ApplicationLoader;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

/**
 * Lecteur d'un fichier Excel à l'aide de POI.
 */
public class CGXMLReader implements ICGReader {

	/** Logger. */
	private static final Logger LOGGER = LogManager.getLogger(CGXMLReader.class);
	/** Fichier excel. */
	protected File mXMLFile;
	/** Données du XML. */
	protected GiraphixDatas mGiraphixDatas;

	/**
	 * Constructeur.
	 * 
	 * @param file Fichier excel à lire.
	 */
	public CGXMLReader(File file) {
		this.mXMLFile = file;
	}

	@Override
	public void read() throws CGException {
		try {
			LOGGER.info("Debut de la lecture du XML :" + mXMLFile.getName());

			// Mis en place de l'outil JAXB
			JAXBContext jc = JAXBContext.newInstance(GiraphixDatas.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();

			// Chargement des données
			this.mGiraphixDatas = (GiraphixDatas) unmarshaller.unmarshal(mXMLFile);
		} catch (JAXBException e) {
			throw new CGException(ApplicationLoader.getInstance().getText("message.error.loader.data"), e);
		} finally {
			LOGGER.info("Fin de la lecture du XMl :" + mXMLFile.getName());
		}
	}

	@Override
	public GiraphixDatas getDatas() {
		return this.mGiraphixDatas;
	}
}
