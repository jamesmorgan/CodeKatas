package com.codemanship.codelab.tdd.romannumerals;

// @SuppressWarnings("unused")
public class RomanNumeralConverter {

	//@formatter:off
	/*
	 * 	1- 10 I, II, III, IV, V, VI, VII, VIII, IX, and X.
	 *  http://en.wikipedia.org/wiki/Roman_numerals
	 *  
	 * 		            	×1	×2	×3	×4	×5	×6	×7	×8		×9
	 *	Ones	            I	II	III	IV	V	VI	VII	VIII	IX
	 *	Tens	            X	XX	XXX	XL	L	LX	LXX	LXXX	XC
	 * 	Hundreds	        C	CC	CCC	CD	D	DC	DCC	DCCC	CM
	 *	Thousands	        M	MM	MMM	IV	V	VI	VII	VIII	IX
	 *	Ten thousands	    X	XX	XXX	XL	L	LX	LXX	LXXX	XC
	 *	Hundred thousands	C	CC	CCC	CD	D	DC	DCC	DCCC	CM
	 *  
	 */
	//@formatter:on

	//@formatter:off
	private static final String[] ROMAN_NUM = { "C",    "X",   "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	private static final int[] NUM_VALUE = 	  { 100000, 10000, 1000, 900, 500, 400,  100,  90,  50,   40,  10,    9,   5,   4,    1  };
	//@formatter:on

	public String convert(final int number) {
		final StringBuilder numeral = new StringBuilder();
		int numberCount = number;
		for (int i = 0; i < NUM_VALUE.length; i++) {
			while (numberCount >= NUM_VALUE[i]) {
				numberCount = reduceCountBy(numberCount, NUM_VALUE[i]);
				numeral.append(ROMAN_NUM[i]);
			}
		}
		return numeral.toString();
	}

	private int reduceCountBy(final int numberCount, final int reduceBy) {
		return numberCount - reduceBy;
	}
}
