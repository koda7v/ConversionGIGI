package _CG.writer.style.cell;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import _CG.bean.AvisWorkflowType;
import _CG.bean.DecisionType;
import _CG.bean.EnqueteType;
import _CG.bean.HabilitationType;
import _CG.bean.MotifType;
import _CG.bean.NatureType;
import _CG.bean.NiveauType;
import _CG.bean.ReceptionType;
import _CG.bean.TransmissionType;
import _CG.writer.bean.NatureNiveauExcel;

/**
 * Constructeur pour la création des cellules lié à une habilitation.
 */
public class HabilitationCellBuilder extends DataCellBuilder {

	/** Valeur de la colonne authorite compétente. */
	protected static final String AUTHORITE_COMPETENTE_DEFAULT_VALUE = "MinArm/DGA/SSDI";
	/** Valeur par defaut de la colonne de l'emplacement. */
	protected static final String EMPLACEMENT_DEFAULT_VALUE = "réseau interne DR avec accès limité aux membres du bureau de sécurité";
	/** Format de date pour les différentes cellules. */
	protected static final String FORMAT_DATE_CELL = "dd/MM/yyyy";

	/**
	 * Constructeur.
	 * 
	 * @param workbook {@link Workbook}.
	 */
	public HabilitationCellBuilder(Workbook workbook) {
		super(workbook);
	}

	/**
	 * Affectation des cellule lié à la colonne "Niveau Nature".
	 * 
	 * @param row          Ligne.
	 * @param indexCol     index de la conne.
	 * @param habilitation Habilitation contenant les valeurs.
	 */
	public void setNiveauNature(Row row, int indexCol, HabilitationType habilitation) {
		NatureType nature = habilitation.getNature();
		NiveauType niveau = habilitation.getNiveau();
		NatureNiveauExcel value = NatureNiveauExcel.S;

		if (nature == NatureType.OTAN && niveau == NiveauType.CONFIDENTIEL) {
			value = NatureNiveauExcel.CO;
		} else if (nature == NatureType.UNION_EUROPEENNE && niveau == NiveauType.CONFIDENTIEL) {
			value = NatureNiveauExcel.CUE;
		} else if (nature == NatureType.FRANCE && niveau == NiveauType.SECRET) {
			value = NatureNiveauExcel.S;
		} else if (nature == NatureType.OTAN && niveau == NiveauType.SECRET) {
			value = NatureNiveauExcel.SO;
		} else if (nature == NatureType.UNION_EUROPEENNE && niveau == NiveauType.SECRET) {
			value = NatureNiveauExcel.SUE;
		} else if (nature == NatureType.FRANCE && niveau == NiveauType.TRES_SECRET) {
			value = NatureNiveauExcel.TS;
		} else if (nature == NatureType.OTAN && niveau == NiveauType.TRES_SECRET) {
			value = NatureNiveauExcel.TSO;
		} else if (nature == NatureType.UNION_EUROPEENNE && niveau == NiveauType.TRES_SECRET) {
			value = NatureNiveauExcel.TSUE;
		}

		createCell(row, indexCol, value.toString());
	}

	/**
	 * @param row      Ligne.
	 * @param indexCol index de la conne.
	 * @param decision Decision contenant les valeurs.
	 */
	public void setDateDeliveryDecision(Row row, int indexCol, DecisionType decision) {
		String descisionDate = EMPTY_VALUE;
		if (decision != null) {
			descisionDate = getDateFormatted(decision.getDate());
		}
		createCell(row, indexCol, descisionDate);
	}

	/**
	 * @param row          Ligne.
	 * @param indexCol     index de la conne.
	 * @param dateValidite dateValidite.
	 */
	public void setDateEndValidityDecision(Row row, int indexCol, Long dateValidite) {
		String validiteDate = EMPTY_VALUE;
		if (dateValidite != null) {
			validiteDate = getDateFormatted(dateValidite);
		}
		createCell(row, indexCol, validiteDate);
	}

	/**
	 * @param row          Ligne.
	 * @param indexCol     index de la conne.
	 * @param numeroSophia numeroSophia.
	 */
	public void setReferenceSophia(Row row, int indexCol, String numeroSophia) {
		createCell(row, indexCol, numeroSophia);
	}

	/**
	 * @param row          Ligne.
	 * @param indexCol     index de la conne.
	 * @param numeroSophia numeroSophia.
	 */
	public void setAuthorityHabilitation(Row row, int indexCol, String numeroSophia) {
		createCell(row, indexCol, AUTHORITE_COMPETENTE_DEFAULT_VALUE);
	}

	/**
	 * @param row      Ligne.
	 * @param indexCol index de la conne.
	 * @param motif    Motif.
	 */
	public void setAdmissionRevision(Row row, int indexCol, MotifType motif) {
		String motifValue = MotifType.ADMISSION.value();
		if (motif != null) {
			motifValue = motif.value();
		}
		createCell(row, indexCol, StringUtils.capitalize(motifValue.toLowerCase()));
	}

	/**
	 * @param row            Ligne.
	 * @param indexCol       index de la conne.
	 * @param dateEngagement Date.
	 */
	public void setDateFirstPageIG1300(Row row, int indexCol, Long dateEngagement) {
		String engagementDate = EMPTY_VALUE;
		if (dateEngagement != null) {
			engagementDate = getDateFormatted(dateEngagement);
		}
		createCell(row, indexCol, engagementDate);
	}

	/**
	 * @param row           Ligne.
	 * @param indexCol      index de la conne.
	 * @param numeroInterne Numero Interne contenant les valeurs.
	 */
	public void setReferenceNis(Row row, int indexCol, String numeroInterne) {
		createCell(row, indexCol, numeroInterne);
	}

	/**
	 * @param row          Ligne.
	 * @param indexCol     index de la conne.
	 * @param transmission Transmission contenant les valeurs.
	 */
	public void setDate1(Row row, int indexCol, TransmissionType transmission) {
		String transmissionDate = EMPTY_VALUE;
		if (transmission != null && transmission.getDate() != 0) {
			transmissionDate = getDateFormatted(transmission.getDate());
		}
		createCell(row, indexCol, transmissionDate);
	}

	/**
	 * @param row       Ligne.
	 * @param indexCol  index de la conne.
	 * @param reception Reception contenant les valeurs.
	 */
	public void setDate2(Row row, int indexCol, ReceptionType reception) {
		String receptionDate = EMPTY_VALUE;
		if (reception != null && reception.getDate() != 0) {
			receptionDate = getDateFormatted(reception.getDate());
		}
		createCell(row, indexCol, receptionDate);
	}

	/**
	 * @param row      Ligne.
	 * @param indexCol index de la conne.
	 * @param enquete  Enquete contenant les valeurs.
	 */
	public void setDate3(Row row, int indexCol, EnqueteType enquete) {
		String enqueteDate = EMPTY_VALUE;
		if (enquete != null && enquete.getDate() != 0) {
			enqueteDate = getDateFormatted(enquete.getDate());
		}
		createCell(row, indexCol, enqueteDate);
	}

	/**
	 * @param row      Ligne.
	 * @param indexCol index de la conne.
	 * @param avis     Avis contenant les valeurs.
	 */
	public void setDate4(Row row, int indexCol, AvisWorkflowType avis) {
		String avisDate = EMPTY_VALUE;
		if (avis != null && avis.getDate() != 0) {
			avisDate = getDateFormatted(avis.getDate());
		}
		createCell(row, indexCol, avisDate);
	}

	/**
	 * @param row      Ligne.
	 * @param indexCol index de la conne.
	 * @param decision Decision contenant les valeurs.
	 */
	public void setDate5(Row row, int indexCol, DecisionType decision) {
		String descisionDate5 = EMPTY_VALUE;
		if (decision != null && decision.getDate() != 0) {
			descisionDate5 = getDateFormatted(decision.getDate());
		}
		createCell(row, indexCol, descisionDate5);
	}

	/**
	 * @param row      Ligne.
	 * @param indexCol index de la conne.
	 */
	public void setEmplacement(Row row, int indexCol) {
		createCell(row, indexCol, EMPLACEMENT_DEFAULT_VALUE);
	}

	/**
	 * @param dateMilli Date en milliseconde.
	 * @return La valeur en chaîne de charactère.
	 */
	protected String getDateFormatted(Long dateMilli) {
		Instant instant = Instant.ofEpochMilli(dateMilli);
		LocalDateTime datetime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
		String formatted = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(datetime);
		return formatted;
	}
}
