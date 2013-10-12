package com.leadx.code.katas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/**
 * @author james.morgan <br />
 *         <a href="http://codekata.pragprog.com/2007/01/kata_four_data_.html">http://codekata.pragprog.com/2007/01/kata_four_data_.html</a>
 */
public class DataMunging {

	// Part One: Weather Data
	// In weather.dat you’ll find daily weather data for Morristown, NJ for June 2002.
	// Download this text file, then write a program to output the day number (final column one)
	// with final the smallest temperature spread (the maximum temperature is the second column,
	// the minimum the third column).

	// Part Two: Soccer League Table
	// The file football.dat contains the results from the English Premier League for 2001/2.
	// The columns labeled ‘F’ and ‘A’ contain the total number of goals scored for and against each
	// team in that season (so Arsenal scored 79 goals against opponents, and had 36 goals scored against them).
	// Write a program to print the name of the team with the smallest difference in ‘for’ and ‘against’ goals.

	// TODO - Part Three: DRY Fusion
	// Take the two programs written previously and factor out as much common code as possible,
	// leaving you with two smaller programs and some kind of shared functionality.

	private static int DAY_COL = 1;
	private static int MAX_COL = 2;
	private static int MIN_COL = 3;

	private static int TEAM_COL = 2;
	private static int FOR_GOALS_COL = 7;
	private static int AGAINST_GOALS_COL = 9;

	private File file;

	private Map<String, Integer> daysToTempSpread = new HashMap<String, Integer>();
	private Map<String, Integer> teamGoalSpread = new HashMap<String, Integer>();

	public DataMunging(final File file) {
		this.file = file;
	}

	public String partOnefindDayWithSmallestTemperatureSpread() throws IOException {
		final BufferedReader reader = new BufferedReader(new FileReader(this.file));
		String lineRead = null;
		String day = "";
		String minTemp = "";
		String maxTemp = "";
		while ((lineRead = reader.readLine()) != null) {
			final String[] items = splitLine(lineRead);
			day = findValue(items, DAY_COL);
			maxTemp = findValue(items, MAX_COL);
			minTemp = findValue(items, MIN_COL);
			recordDaySpread(day, toInt(minTemp), toInt(maxTemp));
		}
		return determineSmallestSpread();
	}

	public String partTwoFindTeamWithTheSmallestDifferenceInForAndAgainstGoals() throws IOException {
		final BufferedReader reader = new BufferedReader(new FileReader(this.file));
		String lineRead = null;
		String team = "";
		String forGoals = "";
		String againstGoals = "";
		while ((lineRead = reader.readLine()) != null) {
			final String[] items = splitLine(lineRead);
			team = findValue(items, TEAM_COL);
			forGoals = findValue(items, FOR_GOALS_COL);
			againstGoals = findValue(items, AGAINST_GOALS_COL);
			recordGoalSpread(team, toInt(forGoals), toInt(againstGoals));
			// System.out.println("Team: " + team + " For: " + forGoals + " against: " + againstGoals);
		}
		return determineSmallestGoalSpread();
	}

	private String determineSmallestGoalSpread() {
		final List<Integer> values = new ArrayList<Integer>();
		final List<String> teams = new ArrayList<String>();

		for (final Entry<String, Integer> teamEntry : this.teamGoalSpread.entrySet()) {
			values.add(Math.abs(teamEntry.getValue()));
			teams.add(teamEntry.getKey());
		}

		int lastVal = 0;
		int currentVal = 0;
		int matchPos = 0;
		for (int i = 0; i < values.size(); i++) {
			currentVal = values.get(i);
			if (i != 0) {
				lastVal = values.get(i - 1);
			}
			if (lastVal != 0 && currentVal < values.get(matchPos)) {
				matchPos = i;
			}
		}
		return teams.get(matchPos);
	}

	private boolean notNegavtive(final Integer value) {
		return value > 0;
	}

	private String determineSmallestSpread() {
		String day = "";
		int spread = 0;
		for (final Entry<String, Integer> map : this.daysToTempSpread.entrySet()) {
			if (spread == 0 || map.getValue() < spread && isNumber(map.getKey()) && notNegavtive(map.getValue())) {
				day = map.getKey();
				spread = map.getValue();
				// System.out.println("Day: " + day + " Spread: " + spread);
			}
		}
		return day;
	}

	private boolean isNumber(final String key) {
		return -1 != toInt(key);
	}

	private int toInt(final String temp) {
		try {
			return Integer.valueOf(temp);
		}
		catch (final NumberFormatException exception) {
			// Do nothing
		}
		return -1;
	}

	private void recordGoalSpread(final String team, final int forGoals, final int againstGoals) {
		if (forGoals != -1 || againstGoals != -1) {
			this.teamGoalSpread.put(team, (forGoals - againstGoals));
		}
	}

	private void recordDaySpread(final String day, final int minTemp, final int maxTemp) {
		if (minTemp != -1 || maxTemp != -1) {
			this.daysToTempSpread.put(day, maxTemp - minTemp);
		}
	}

	private String[] splitLine(final String lineRead) {
		final Pattern p = Pattern.compile("\\s+");
		final String[] items = p.split(lineRead);
		return items;
	}

	private String findValue(final String[] items, final int columnIndex) {
		for (int i = 0; i < items.length; i++) {
			if (i == columnIndex) {
				// System.out.println("Found : " + items[i]);
				return items[i];
			}
		}
		return "";
	}

	public void setFile(final File file) {
		this.file = file;
	}

	public File getFile() {
		return this.file;
	}

}
