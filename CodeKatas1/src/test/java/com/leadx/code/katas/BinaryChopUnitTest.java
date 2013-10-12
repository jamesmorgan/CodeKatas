package com.leadx.code.katas;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BinaryChopUnitTest {

	private static int[] ONE_TO_TEN_ARRAY = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
	private static int[] RANDOM_ARRAY = new int[] { 72, 349, 12, 5, -1, 0, 52, 56, 10, 30, 76, 99, 659, 987 };

	@Test
	public void shouldFindCorrectPositionOnArray() {
		assertThat(-1, is(BinaryChop.chop(3, new int[] {})));
		assertThat(-1, is(BinaryChop.chop(3, new int[] { 1 })));
		assertThat(0, is(BinaryChop.chop(1, new int[] { 1 })));

		assertThat(0, is(BinaryChop.chop(1, new int[] { 1, 3, 5 })));
		assertThat(1, is(BinaryChop.chop(3, new int[] { 1, 3, 5 })));
		assertThat(2, is(BinaryChop.chop(5, new int[] { 1, 3, 5 })));
		assertThat(-1, is(BinaryChop.chop(0, new int[] { 1, 3, 5 })));
		assertThat(-1, is(BinaryChop.chop(2, new int[] { 1, 3, 5 })));
		assertThat(-1, is(BinaryChop.chop(4, new int[] { 1, 3, 5 })));
		assertThat(-1, is(BinaryChop.chop(6, new int[] { 1, 3, 5 })));

		assertThat(0, is(BinaryChop.chop(1, new int[] { 1, 3, 5, 7 })));
		assertThat(1, is(BinaryChop.chop(3, new int[] { 1, 3, 5, 7 })));
		assertThat(2, is(BinaryChop.chop(5, new int[] { 1, 3, 5, 7 })));
		assertThat(3, is(BinaryChop.chop(7, new int[] { 1, 3, 5, 7 })));
		assertThat(-1, is(BinaryChop.chop(0, new int[] { 1, 3, 5, 7 })));
		assertThat(-1, is(BinaryChop.chop(2, new int[] { 1, 3, 5, 7 })));
		assertThat(-1, is(BinaryChop.chop(4, new int[] { 1, 3, 5, 7 })));
		assertThat(-1, is(BinaryChop.chop(6, new int[] { 1, 3, 5, 7 })));
		assertThat(-1, is(BinaryChop.chop(8, new int[] { 1, 3, 5, 7 })));
	}
}
