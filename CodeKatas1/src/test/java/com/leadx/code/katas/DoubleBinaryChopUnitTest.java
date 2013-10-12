package com.leadx.code.katas;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Test;

public class DoubleBinaryChopUnitTest {

	@Test
	public void shoulNotMatchCorrectlyNullArrays() {
		int location = DoubleBinaryChop.chop(null, new int[] {});
		assertThat(location, Is.is(-1));
		location = DoubleBinaryChop.chop(new int[] {}, null);
		assertThat(location, Is.is(-1));
	}

	@Test
	public void shoulNotMatchCorrectlyEmptyArrays() {
		final int location = DoubleBinaryChop.chop(new int[] {}, new int[] {});
		assertThat(location, Is.is(-1));
	}

	@Test
	public void shoulNotMatchCorrectlyIfSecondArrayLongerThanOrginal() {
		final int location = DoubleBinaryChop.chop(new int[] {}, new int[] { 1 });
		assertThat(location, Is.is(-1));
	}

	@Test
	public void shoulMatchCorrectly() {
		final int location = DoubleBinaryChop.chop(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 3, 4 });
		assertThat(location, Is.is(2));
	}

	@Test
	public void shoulMatchCorrectly2() {
		final int location = DoubleBinaryChop.chop(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 5, 6 });
		assertThat(location, Is.is(4));
	}
}
