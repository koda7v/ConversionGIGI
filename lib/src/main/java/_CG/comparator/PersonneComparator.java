package _CG.comparator;

import java.util.Comparator;

import _CG.bean.PersonneType;

/**
 * Comparateur de {@link PersonneType}.
 */
public class PersonneComparator implements Comparator<PersonneType> {

	@Override
	public int compare(PersonneType personne1, PersonneType personne2) {

		int resultValue = -1;

		if (personne1.getNom().equals(personne2.getNom()) && personne1.getPrenom().equals(personne2.getPrenom())) {
			resultValue = 0;
		}

		return resultValue;
	}
}
