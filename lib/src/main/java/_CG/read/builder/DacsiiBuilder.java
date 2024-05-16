package _CG.read.builder;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellType;

import _CG.bean.AvisHabilitationType;
import _CG.bean.DacssiType;
import _CG.bean.DecisionType;
import _CG.bean.EtatDacssiType;
import _CG.bean.FonctionDacssiType;
import _CG.bean.MotifDacssiType;
import _CG.bean.NatureType;
import _CG.bean.NiveauType;
import _CG.bean.ObjectFactory;
import _CG.bean.ReceptionType;
import _CG.bean.TransmissionType;
import _CG.bean.WorkflowDacssiType;
import _CG.constant.ConstantHabilitation;
import _CG.exception.LineExcelException;
import _CG.tools.ApplicationLoader;

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

		this.mDacsii.setEtat(EtatDacssiType.TRANSMISE);
		this.mDacsii.setMotif(MotifDacssiType.ADMISSION);
		this.mDacsii.setFonction(FonctionDacssiType.OSSI);
		this.mDacsii.setIdAnnexe("");
		this.mDacsii.setIdFormation("");
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
			this.mDacsii.setEtat(EtatDacssiType.TRANSMISE);
		} else {
			this.mDacsii.setEtat(EtatDacssiType.NON_TRANSMISE);
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
			this.mDacsii.setEtat(EtatDacssiType.DECISION);
		} else {
			if (!this.mDacsii.getNumeroSophia().isBlank()) {
				this.mDacsii.setEtat(EtatDacssiType.RECUE);

				ReceptionType receptionType = this.mFabrique.createReceptionType();
				this.mWorkflowType.setReception(receptionType);
			}
		}
	}

	/**
	 * Affectation de la date de validité d'habilitation.
	 * 
	 * @param cell Cellule où l'on va récupérer l'information.
	 * @throws LineExcelException
	 */
	public void setValiditeHabilitation(HSSFCell cell) throws LineExcelException {
		long date = getShortDateFromCell(cell);
		if (date != 0) {
			this.mDacsii.setDateValidite(date);
			this.mDacsii.setAvis(AvisHabilitationType.FAVORABLE);

			if (new Date(date).before(new Date())) {
				this.isToAdded = false;
				throw new LineExcelException(ApplicationLoader.getInstance().getText(
						"message.error.line.not.added.date.validation", Integer.toString(cell.getRowIndex() - 1)));
			}
		} else if (cell.getCellType() == CellType.STRING) {
			String currentValue = getStringFromCell(cell);
			if (!currentValue.isBlank() && StringUtils.indexOfIgnoreCase(StringUtils.stripAccents(currentValue),
					ConstantHabilitation.REFUS) != -1) {
				this.mDacsii.setAvis(AvisHabilitationType.REFUS);
				this.mDacsii.setEtat(EtatDacssiType.CLOS);
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
