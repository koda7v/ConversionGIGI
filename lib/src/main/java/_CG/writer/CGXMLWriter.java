package _CG.writer;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.SystemProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import _CG.bean.GiraphixDatas;
import _CG.exception.CGException;
import _CG.tools.ApplicationLoader;
import _CG.tools.Tools;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import javafx.scene.control.Alert.AlertType;

/**
 * Ecriture sous un format XML à l'aide de JAXB.
 */
public class CGXMLWriter implements ICGWriter {

	/** Logger. */
	private static final Logger LOGGER = LogManager.getLogger(CGXMLWriter.class);
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
	public CGXMLWriter() {
	}

	@Override
	public void write() throws CGException {
		try {
			// Mis en place de l'outil JAXB
			JAXBContext jc = JAXBContext.newInstance(GiraphixDatas.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Gestion du format de la date donnée dans le nom du fichier
			Date date = new Date();
			SimpleDateFormat formater = new SimpleDateFormat(EXPORT_DATE_FORMAT);

			// Vérification des droits
			marshaller.marshal(mDatas, new File(SystemProperties.getUserDir() + File.separator + EXPORT_TITLE_NAME
					+ formater.format(date) + EXPORT_EXTENSION));

			Thread t = new Thread() {
				@Override
				public void run() {
					try {
						Desktop.getDesktop().open(new File(SystemProperties.getUserDir()));
					} catch (IOException e) {
						Tools.displayMessage(ApplicationLoader.getInstance().getText("message.error.writer.desktop"),
								AlertType.WARNING, LOGGER, e);
					}
				}
			};
			t.start();

		} catch (JAXBException e) {
			throw new CGException(ApplicationLoader.getInstance().getText("message.error.loader.data"), e);
		}
	}

	@Override
	public void setDatas(GiraphixDatas giraphixDatas) {
		this.mDatas = giraphixDatas;
	}
}
