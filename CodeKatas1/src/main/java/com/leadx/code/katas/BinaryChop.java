package com.leadx.code.katas;

/**
 * @author james.morgan <br />
 *         <a href="http://codekata.pragprog.com/2007/01/kata_two_karate.html">http://codekata.pragprog.com/2007/01/kata_two_karate.html</a>
 */
public class BinaryChop {

	public static final int NOT_FOUND = -1;

	public static int chop(final int value, final int[] array) {
		if (null == array || array.length == 0) {
			return NOT_FOUND;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return i;
			}
		}
		return NOT_FOUND;
	}
}
