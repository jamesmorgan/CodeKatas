package com.leadx.code.katas;

/**
 * @author james.morgan <br />
 */
public class DoubleBinaryChop {

	public static final int NOT_FOUND = -1;

	public static int chop(final int[] arrayStart, final int[] arrayMatch) {
		if (null == arrayStart || null == arrayMatch) {
			return NOT_FOUND;
		}
		if (arrayStart.length == 0 || arrayMatch.length == 0) {
			return NOT_FOUND;
		}
		if (arrayStart.length <= arrayMatch.length) {
			return NOT_FOUND;
		}
		final boolean found = false;

		for (int origIndex = 0; origIndex < arrayStart.length; origIndex++) {

			if (arrayMatch.length >= origIndex - 1 && arrayStart[origIndex] == arrayMatch[1]) {

				for (int matchIndex = 0; matchIndex <= (arrayStart.length - arrayMatch.length); matchIndex++) {

					System.out.println("orig " + arrayStart[origIndex++] + " | match " + arrayMatch[matchIndex]);

					if (arrayStart[origIndex++] == arrayMatch[matchIndex]) {

					}

				}

			}

		}

		return NOT_FOUND;
	}
}
