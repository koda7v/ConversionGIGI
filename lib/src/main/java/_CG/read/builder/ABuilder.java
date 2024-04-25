package _CG.read.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;

import _CG.bean.ObjectFactory;

/**
 * Classe abstraite des différents constructeurs de données pour GIRAPHIX.
 */
public abstract class ABuilder {

	/** Format de la date avec les 4 chiffres de l'année. */
	protected SimpleDateFormat mLongDateFormat;
	/** Format de la date avec les 2 chiffres de l'année. */
	protected SimpleDateFormat mShortDateFormat;
	/** Usine permettant la création des bean de giraphix. */
	protected ObjectFactory mFabrique;
	/** L'entité est-elle à ajouter ? */
	protected boolean isToAdded;

	/**
	 * Constructeur.
	 * 
	 * @param fabrique Fabrique permettant d'initialiser les entités de
	 *                 l'application GIRAPHIX.
	 */
	public ABuilder(ObjectFactory fabrique) {
		this.mLongDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.mShortDateFormat = new SimpleDateFormat("dd/MM/yy");
		this.mFabrique = fabrique;
		this.isToAdded = true;
	}

	/**
	 * Récupération d'une date présente dans une cellule.
	 * 
	 * @param cell Cellule à gérer.
	 * @return Date convertie en long, 0 si aucune date n'est trouvé.
	 */
	protected long getLongDateFromCell(HSSFCell cell) {
		if (cell.getCellType() == CellType.NUMERIC) {
			DataFormatter df = new DataFormatter();
			String CellValue = df.formatCellValue(cell);

			Date currentDate;
			try {
				currentDate = mLongDateFormat.parse(CellValue);
				if (currentDate != null) {
					return currentDate.getTime();
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * Récupération d'une date présente dans une cellule.
	 * 
	 * @param cell Cellule à gérer.
	 * @return Date convertie en long, 0 si aucune date n'est trouvé.
	 */
	protected long getShortDateFromCell(HSSFCell cell) {
		if (cell.getCellType() == CellType.NUMERIC) {
			DataFormatter df = new DataFormatter();
            String CellValue = df.formatCellValue(cell);

			Date currentDate;
			try {
				currentDate = mShortDateFormat.parse(CellValue);
				if (currentDate != null) {
					return currentDate.getTime();
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (cell.getCellType() == CellType.STRING) {
			String[] split = cell.getStringCellValue()
					.split("\\n+");
			if (split.length > 1) {
				Date currentDate;
				try {
					currentDate = mLongDateFormat.parse(split[0]);
					if (currentDate != null) {
						return currentDate.getTime();
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	/**
	 * Récupération d'une chaine de charactère présente dans une cellule.
	 * 
	 * @param cell Cellule à gérer.
	 * @return La chaine de caratère, vide si la cellule est vide.
	 */
	protected String getStringFromCell(HSSFCell cell) {
		String stringCellValue = "";
		if (cell.getCellType() == CellType.STRING) {
			stringCellValue = cell.getStringCellValue();
		}
		return stringCellValue;
	}

	/**
	 * Récupération d'une chaine de charactère présente dans une cellule.
	 * 
	 * @param cell Cellule à gérer.
	 * @return La chaine de caratère, vide si la cellule est vide.
	 */
	protected String getStringFromCellWithoutCarriageReturn(HSSFCell cell) {
		String stringCellValue = "";
		if (cell.getCellType() == CellType.STRING) {
			stringCellValue = cell.getStringCellValue();
			String[] split = stringCellValue.split("\\n+");
			if (split.length > 1) {
				stringCellValue = split[0];
			}
		}
		return stringCellValue;
	}

	/**
	 * @return Est-ce que l'entité est à ajouter.
	 */
	public boolean isEntityToAdded() {
		return this.isToAdded;
	}

}
