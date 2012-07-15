public class WordWrapper2 {

	private static final String SPACER = "\n";

	public static String wrap(final String s, final int col) {
		if (s.length() <= col) {
			return s;
		}

		final int breakIndex = s.substring(0, col)
			.lastIndexOf(' ');

		// Latest Possible split
		if (-1 != breakIndex) {
			return s.substring(0, breakIndex) + SPACER + wrap(s.substring(breakIndex + 1), col);
		}
		// Space on split
		else if (s.charAt(col) == ' ') {
			return s.substring(0, col) + SPACER + wrap(s.substring(col + 1), col);
		}
		// No spaces found
		return s.substring(0, col) + SPACER + wrap(s.substring(col), col);
	}

}
