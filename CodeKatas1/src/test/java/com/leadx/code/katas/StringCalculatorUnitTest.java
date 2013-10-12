package com.leadx.code.katas;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.hamcrest.core.Is;
import org.junit.Test;

import com.leadx.code.katas.exceptions.MaxThreeNumbers;
import com.leadx.code.katas.exceptions.NegativesNotAllowedException;

public class StringCalculatorUnitTest {

	StringCalculator stringCalculator = new StringCalculator();

	@Test
	public void testNull() {
		assertThat(this.stringCalculator.add(null), Is.is(0));
	}

	@Test
	public void testZero() {
		assertThat(this.stringCalculator.add("0"), Is.is(0));
	}

	@Test
	public void testTakingOneNumber() {
		for (int i = 0; i < 100;) {
			assertThat(this.stringCalculator.add(Integer.toString(i)), Is.is(i));
			i++;
		}
	}

	@Test
	public void testTakingTwoNumbers() {
		assertThat(this.stringCalculator.add("1,1"), Is.is(2));
	}

	@Test
	public void testTakingTwoBigNumbers() {
		assertThat(this.stringCalculator.add("99,101"), Is.is(200));
	}

	@Test
	public void testTakingThreeNumbers() {
		assertThat(this.stringCalculator.add("99,101,800"), Is.is(1000));
	}

	@Test
	public void testTakingMoreThanThreeNumbers() {
		try {
			this.stringCalculator.add("99,101,800,100");
			fail("Should have thrown an excpetion");
		}
		catch (final MaxThreeNumbers e) {
			assertThat(e.getMessage(), Is.is("Max three numbers to add: [99, 101, 800, 100]"));
		}

	}

	@Test
	public void testTakingThreeNumbersWithTraillingComma() {
		assertThat(this.stringCalculator.add("99,101,800,"), Is.is(1000));
	}

	@Test
	public void testWithJustCommas() {
		assertThat(this.stringCalculator.add(",,,,"), Is.is(0));
	}

	@Test
	public void testShouldThrowExceptionOnNegativeNumbers() {
		try {
			this.stringCalculator.add("-1,-2,3");
			fail("Should have thrown an excpetion");
		}
		catch (final NegativesNotAllowedException e) {
			assertThat(e.getMessage(), Is.is("negatives not allowed: [-1, -2]"));
		}
	}

	@Test
	public void testWithLinesBetweenNumbers() {
		assertThat(this.stringCalculator.add("1\n2,3"), Is.is(6));
	}

	@Test
	public void testWithLinesAfterNumber() {
		assertThat(this.stringCalculator.add("1,\n"), Is.is(1));
	}

	@Test
	public void testWithAlternativeDelimiter() {
		assertThat(this.stringCalculator.add("//;\n1;2"), Is.is(3));
	}

	@Test
	public void testWithRandomAlternativeDelimiter() {
		assertThat(this.stringCalculator.add("//----\n1----2----8"), Is.is(11));
	}

}
