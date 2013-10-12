package com.leadx.code.katas;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.leadx.code.katas.exceptions.MaxThreeNumbers;
import com.leadx.code.katas.exceptions.NegativesNotAllowedException;

/**
 * @author james.morgan
 *         <p>
 *         http://katas.softwarecraftsmanship.org/?p=80
 *         </p>
 *         <p>
 *         http://codelikebozo.com/string-calculator-kata-with-no-ifs
 *         </p>
 */
public class StringCalculator {

	private static String DELIMITER;

	public int add(final String value) {
		if (StringUtils.isEmpty(value)) {
			return 0;
		}

		DELIMITER = determineDelimiter(value);

		final String processedString = cleanUp(value);

		final String[] split = splitValues(processedString);
		throwExceptionIfMoreThanThreeNumbers(split);

		final List<Integer> numbers = convertStringArrayToIntList(split);
		throwExceptionIfContainsNegatives(numbers);

		try {
			return Integer.parseInt(processedString);
		}
		catch (final Exception e) {
			// Can't parse single number -> must more multiple
		}

		int addition = 0;
		for (final Integer integer : numbers) {
			addition += integer;
		}

		return addition;
	}

	private String cleanUp(final String value) {
		return value.replace("\n", DELIMITER)
			.replace("//", DELIMITER);
	}

	private String determineDelimiter(final String value) {
		final String deliminater = StringUtils.substringBetween(value, "//", "\n");
		return null != deliminater
				? deliminater
				: ",";
	}

	private String[] splitValues(final String value) {
		return StringUtils.split(value, DELIMITER);
	}

	private void throwExceptionIfMoreThanThreeNumbers(final String[] split) {
		final List<Integer> numbers = convertStringArrayToIntList(split);
		if (numbers.size() > 3) {
			throw new MaxThreeNumbers(numbers);
		}
	}

	private void throwExceptionIfContainsNegatives(final List<Integer> numbers) {
		final List<Integer> negativesFound = new ArrayList<Integer>();
		for (final Integer number : numbers) {
			if (number < 0) {
				negativesFound.add(number);
			}
		}
		if (!negativesFound.isEmpty()) {
			throw new NegativesNotAllowedException(negativesFound);
		}
	}

	private List<Integer> convertStringArrayToIntList(final String[] split) {
		final List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < split.length; i++) {
			numbers.add(getNum(split, i));
		}
		return numbers;
	}

	private int getNum(final String[] split, final int i) {
		try {
			return Integer.parseInt(split[i]);
		}
		catch (final Exception e) {
			return 0;
		}
	}
}
