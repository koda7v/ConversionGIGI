package _CG.read.builder;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellType;

import _CG.bean.AvisHabilitationType;
import _CG.bean.DecisionType;
import _CG.bean.HabilitationType;
import _CG.bean.NatureType;
import _CG.bean.NiveauType;
import _CG.bean.ObjectFactory;
import _CG.bean.TransmissionType;
import _CG.bean.WorkflowType;
import _CG.read.constant.ConstantHabilitation;

/**
 * Constructeur de données pour {@link HabilitationType}.
 */
public class HabilitationBuilder extends ABuilder implements IBuilder {

	/** Habilitation en cours de construction. */
	protected HabilitationType mHabilitation;
	/** Workflow de l'habilitation en cours. */
	protected WorkflowType mWorkflowType;

	/**
	 * Constructeur.
	 * 
	 * @param fabrique Fabrique permettant d'initialiser les entités de
	 *                 l'application GIRAPHIX.
	 */
	public HabilitationBuilder(ObjectFactory fabrique) {
		super(fabrique);
	}

	@Override
	public void reset() {
		this.mHabilitation = mFabrique.createHabilitationType();
		this.mWorkflowType = mFabrique.createWorkflowType();
		this.isToAdded = true;
	}

	/**
	 * Affectation de l'identitfiant de la personne à qui appartient l'habilitation.
	 * 
	 * @param personneID Identifiant de la personne à qui appartient l'habilitation.
	 */
	public void setIDPersonne(String personneID) {
		this.mHabilitation.setIdPersonne(personneID);
	}

	/**
	 * Affectation du numero Interne.
	 * 
	 * @param cell Cellule où l'on va récupérer la'information.
	 */
	public void setNumeroInterne(HSSFCell cell) {
		this.mHabilitation.setNumeroInterne(getStringFromCellWithoutCarriageReturn(cell));
	}

	/**
	 * Affectation du numero sophia.
	 * 
	 * @param cell Cellule où l'on va récupérer la'information.
	 */
	public void setNumeroSophia(HSSFCell cell) {
		this.mHabilitation.setNumeroSophia(getStringFromCellWithoutCarriageReturn(cell));
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
			this.mHabilitation.setNature(NatureType.FRANCE);
			this.mHabilitation.setNiveau(NiveauType.SECRET);
			break;
		case ConstantHabilitation.CO:
		case ConstantHabilitation.OTAN:
			this.mHabilitation.setNature(NatureType.OTAN);
			this.mHabilitation.setNiveau(NiveauType.CONFIDENTIEL);
			break;
		case ConstantHabilitation.TSF:
			this.mHabilitation.setNature(NatureType.FRANCE);
			this.mHabilitation.setNiveau(NiveauType.TRES_SECRET);
			break;
		case ConstantHabilitation.SF_UE:
			this.mHabilitation.setNature(NatureType.UNION_EUROPEENNE);
			this.mHabilitation.setNiveau(NiveauType.SECRET);
			break;
		case ConstantHabilitation.SD:
		case ConstantHabilitation.SD_CEA:
			this.mHabilitation.setNature(NatureType.DEFENSE);
			this.mHabilitation.setNiveau(NiveauType.SECRET);
			break;
		case ConstantHabilitation.CD:
			this.mHabilitation.setNature(NatureType.DEFENSE);
			this.mHabilitation.setNiveau(NiveauType.CONFIDENTIEL);
			break;
		case ConstantHabilitation.CPR:
			// NE fait rien
			break;
		default:
			break;
		}
	}

	/**
	 * Affectation de la date d'envoie d'engagement de responsabilité.
	 * 
	 * @param cell Cellule où l'on va récupérer l'information.
	 */
	public void setRetourEngagementResponsabiliteSigne(HSSFCell cell) {
		long date = getShortDateFromCell(cell);
		if (date != 0) {
			this.mHabilitation.setDateEngagement(date);
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

			this.mHabilitation.setDateRemiseDossier(date);
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
			this.mHabilitation.setDateValidite(date);
			this.mHabilitation.setAvis(AvisHabilitationType.FAVORABLE);

			if (new Date(date).after(new Date())) {
				this.mHabilitation.setActif(true);
			} else {
				this.isToAdded = false;
			}
		} else if (cell.getCellType() == CellType.STRING) {
			String currentValue = getStringFromCell(cell);
			if (!currentValue.isBlank()
					&& StringUtils.indexOfIgnoreCase(StringUtils.stripAccents(currentValue),
							ConstantHabilitation.REFUS) != -1) {
				this.mHabilitation.setAvis(AvisHabilitationType.REFUS);
			}
			this.mHabilitation.setActif(false);
		} else {
			this.mHabilitation.setAvis(AvisHabilitationType.EN_ATTENTE);
			this.mHabilitation.setActif(false);
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
	 * @return Habilitation en cours de création.
	 */
	public HabilitationType getHabilitation() {
		this.mHabilitation.setWorkflow(this.mWorkflowType);

		return this.mHabilitation;
	}

}
