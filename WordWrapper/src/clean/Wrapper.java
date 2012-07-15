package clean;

public class Wrapper {

	public static String wrap(final String s, final int col) {
		return new Wrapper(col).wrap(s);
	}

	private int col;

	private Wrapper(final int col) {
		this.col = col;
	}

	private String wrap(final String s) {
		if (s.length() <= this.col) {
			return s;
		}
		final int space = (s.substring(0, this.col).lastIndexOf(' '));
		if (space != -1) {
			return breakLine(s, space, 1);
		}
		else if (s.charAt(this.col) == ' ') {
			return breakLine(s, this.col, 1);
		}
		return breakLine(s, this.col, 0);
	}

	private String breakLine(final String s, final int pos, final int gap) {
		return s.substring(0, pos) + "\n" + wrap(s.substring(pos + gap), this.col);
	}
}
