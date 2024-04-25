package _CG.writer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import _CG.bean.GiraphixDatas;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

/**
 * Ecriture sous un format XML à l'aide de JAXB.
 */
public class CGWriter implements ICGWriter {

	/** Format de la date donnée dans le nom du fichier XML. */
	private static final String EXPORT_DATE_FORMAT = "ddMMyyHHmmss";
	/** Nom du fichier XMl. */
	private static final String EXPORT_TITLE_NAME = "Export_Bordeaux_giraphix";
	/** Extension donnée au fichier de sortie. */
	private static final String EXPORT_EXTENSION = ".xml";

	/** Donnée importer. */
	protected GiraphixDatas mDatas;

	/**
	 * Constructeur.
	 * 
	 * @param giraphixDatas
	 */
	public CGWriter(GiraphixDatas giraphixDatas) {
		this.mDatas = giraphixDatas;
	}

	@Override
	public void writeXML() {
		try {
			// Mis en place de l'outil JAXB
			JAXBContext jc = JAXBContext.newInstance(GiraphixDatas.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Gestion du format de la date donnée dans le nom du fichier
			Date date = new Date();
			SimpleDateFormat formater = new SimpleDateFormat(EXPORT_DATE_FORMAT);

			// Ecriture du fichier
			marshaller.marshal(mDatas, new File(EXPORT_TITLE_NAME + formater.format(date) + EXPORT_EXTENSION));

		} catch (JAXBException e) {
			System.err.println("Problème de création du contexte JAXB. \n" + e.getMessage());
		}
	}
}
