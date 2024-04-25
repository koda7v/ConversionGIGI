package _CG.read.builder;

import _CG.bean.DacssiType;
import _CG.bean.ObjectFactory;

/**
 * Constructeur de données pour {@link DacssiType}.
 */
public class DacsiiBuilder extends ABuilder implements IBuilder {

	/** Entreprise courante en cours de création. */
	protected DacssiType mDacsii;

	/**
	 * Constructeur.
	 * 
	 * @param fabrique Fabrique permettant d'initialiser les entités de
	 *                 l'application GIRAPHIX.
	 */
	public DacsiiBuilder(ObjectFactory fabrique) {
		super(fabrique);
	}

	@Override
	public void reset() {
		this.mDacsii = mFabrique.createDacssiType();
	}

}
