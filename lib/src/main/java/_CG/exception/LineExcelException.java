package _CG.exception;

/**
 * Exception permettant d'ignorer la ligne excel.
 */
public class LineExcelException extends Exception {

	private static final long serialVersionUID = -888563505857946838L;

	/**
	 * Constructeur.
	 * 
	 * @param msg Message décrivant la raison pour laquelle la ligne est passée.
	 */
	public LineExcelException(String msg) {
		super(msg);
	}

}
