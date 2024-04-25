package _CG.read.builder;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellType;

import _CG.bean.AvisHabilitationType;
import _CG.bean.DacssiType;
import _CG.bean.DecisionType;
import _CG.bean.NatureType;
import _CG.bean.NiveauType;
import _CG.bean.ObjectFactory;
import _CG.bean.TransmissionType;
import _CG.bean.WorkflowDacssiType;
import _CG.read.constant.ConstantHabilitation;

/**
 * Constructeur de données pour {@link DacssiType}.
 */
public class DacsiiBuilder extends ABuilder implements IBuilder {

	/** Entreprise courante en cours de création. */
	protected DacssiType mDacsii;
	/** Workflow de l'habilitation en cours. */
	protected WorkflowDacssiType mWorkflowType;

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
		this.mWorkflowType = mFabrique.createWorkflowDacssiType();
		this.isToAdded = true;
	}

	/**
	 * Affectation de l'identitfiant de la personne à qui appartient l'habilitation.
	 * 
	 * @param personneID Identifiant de la personne à qui appartient l'habilitation.
	 */
	public void setIDPersonne(String personneID) {
		this.mDacsii.setIdPersonne(personneID);
	}

	/**
	 * Affectation du numero Interne.
	 * 
	 * @param cell Cellule où l'on va récupérer la'information.
	 */
	public void setNumeroInterne(HSSFCell cell) {
		this.mDacsii.setNumeroInterne(getStringFromCellWithoutCarriageReturn(cell));
	}

	/**
	 * Affectation du numero sophia.
	 * 
	 * @param cell Cellule où l'on va récupérer la'information.
	 */
	public void setNumeroSophia(HSSFCell cell) {
		this.mDacsii.setNumeroSophia(getStringFromCellWithoutCarriageReturn(cell));
	}

	/**
	 * Affectation du type d'habilitation.
	 * 
	 * @param cell Cellule où l'on va récupérer la'information.
	 */
	public void setTypeHabilitation(HSSFCell cell) {
		String cellValue = getStringFromCell(cell);

		switch (cellValue) {
		case ConstantHabilitation.SF:
			this.mDacsii.setNature(NatureType.FRANCE);
			this.mDacsii.setNiveau(NiveauType.SECRET);
			break;
		case ConstantHabilitation.CO:
			this.mDacsii.setNature(NatureType.OTAN);
			this.mDacsii.setNiveau(NiveauType.CONFIDENTIEL);
			break;
		default:
			break;
		}
	}

	/**
	 * Affectation de la date d'envoie DIRPSD.
	 * 
	 * @param cell Cellule où l'on va récupérer l'information.
	 */
	public void setDateEnvoiDIRPSD(HSSFCell cell) {
		long date = getShortDateFromCell(cell);
		if (date != 0) {
			TransmissionType transmissionType = this.mFabrique.createTransmissionType();
			transmissionType.setDate(date);
			this.mWorkflowType.setTransmission(transmissionType);

			this.mDacsii.setDateRemiseDossier(date);
		}
	}

	/**
	 * Affectation de la date de retour de décision.
	 * 
	 * @param cell Cellule où l'on va récupérer l'information.
	 */
	public void setDateRetourDecision(HSSFCell cell) {
		long date = getShortDateFromCell(cell);
		if (date != 0) {
			DecisionType decisionType = this.mFabrique.createDecisionType();
			decisionType.setDate(date);
			this.mWorkflowType.setDecision(decisionType);
		}
	}

	/**
	 * Affectation de la date de validité d'habilitation.
	 * 
	 * @param cell Cellule où l'on va récupérer l'information.
	 */
	public void setValiditeHabilitation(HSSFCell cell) {
		long date = getShortDateFromCell(cell);
		if (date != 0) {
			this.mDacsii.setDateValidite(date);
			this.mDacsii.setAvis(AvisHabilitationType.FAVORABLE);

			if (new Date(date).before(new Date())) {
				this.isToAdded = false;
			}
		} else if (cell.getCellType() == CellType.STRING) {
			String currentValue = getStringFromCell(cell);
			if (!currentValue.isBlank() && StringUtils.indexOfIgnoreCase(StringUtils.stripAccents(currentValue),
					ConstantHabilitation.REFUS) != -1) {
				this.mDacsii.setAvis(AvisHabilitationType.REFUS);
			}
		} else {
			this.mDacsii.setAvis(AvisHabilitationType.EN_ATTENTE);
		}
	}

	/**
	 * @return DACSII en cours de création.
	 */
	public DacssiType getDacssi() {
		this.mDacsii.setWorkflow(this.mWorkflowType);

		return this.mDacsii;
	}

}
