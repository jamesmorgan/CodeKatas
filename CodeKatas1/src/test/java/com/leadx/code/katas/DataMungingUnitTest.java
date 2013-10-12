package com.leadx.code.katas;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.junit.Ignore;
import org.junit.Test;

public class DataMungingUnitTest {

	private static final String REGEX = "\\s+";

	@Test
	@Ignore
	public void sholdMatchDayField() {
		final String INPUT = "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5";
		final Pattern p = Pattern.compile(REGEX);
		final String[] items = p.split(INPUT);
		for (final String string : items) {
			System.out.println("-" + string + "-");
		}
		final String str = "Testing split using two  whitespace characters";
		final String[] tokens = str.split("\\s+");
		for (final String token : tokens) {
			System.out.println("-" + token + "-");
		}
	}

	@Test
	public void shouldFindSmallestTemperatureSpread() throws IOException {
		final File file = new File("src/test/resources/weather.dat");
		final DataMunging dataMunging = new DataMunging(file);
		final String smallestTemperatureSpread = dataMunging.partOnefindDayWithSmallestTemperatureSpread();
		System.out.println("Day with smallest temp = " + smallestTemperatureSpread);
		assertThat(smallestTemperatureSpread, is("14"));
	}

	@Test
	public void shouldFindTeamWithTheSmallestDifferenceInForAndAgainstGoals() throws IOException {
		final File file = new File("src/test/resources/football.dat");
		final DataMunging dataMunging = new DataMunging(file);
		final String teamWithTheSmallestDifferenceInForAndAgainstGoals =
				dataMunging.partTwoFindTeamWithTheSmallestDifferenceInForAndAgainstGoals();
		assertThat(teamWithTheSmallestDifferenceInForAndAgainstGoals, is("Aston_Villa"));
	}

}
