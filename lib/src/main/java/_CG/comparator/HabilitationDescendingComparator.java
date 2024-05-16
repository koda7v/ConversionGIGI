package _CG.comparator;

import java.util.Comparator;
import java.util.Date;

import _CG.bean.HabilitationType;

/**
 * Comparateur descendant de {@link HabilitationType}.
 */
public class HabilitationDescendingComparator implements Comparator<HabilitationType> {

	@Override
	public int compare(HabilitationType habilitation1, HabilitationType habilitation2) {
		Date date1 = new Date(habilitation1.getDateValidite());
		Date date2 = new Date(habilitation2.getDateValidite());
		return date1.compareTo(date2);
	}

}
