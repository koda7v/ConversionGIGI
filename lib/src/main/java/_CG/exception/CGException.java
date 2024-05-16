package _CG.exception;

/**
 * Encapsulation d'une erreur.
 */
public class CGException extends Exception {

	private static final long serialVersionUID = 8042381756482434422L;

	/**
	 * Constructeur.
	 * 
	 * @param msg   Message lié à l'exception.
	 * @param cause Cause de l'exception.
	 */
	public CGException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
