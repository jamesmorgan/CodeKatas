import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WordWraper1UnitTest {

	@Test
	public void emptyString() throws Exception {
		assertThat(wrap("", 1), equalTo(""));
	}

	@Test
	public void stringShorterThanCol() throws Exception {
		assertThat(wrap("word", 10), equalTo("word"));
	}

	@Test
	public void wrapTwoWordsAfterSpace() throws Exception {
		assertThat(wrap("word word", 6), equalTo("word\nword"));
	}

	@Test
	public void wrapThreeWordsAfterFirstSpace() throws Exception {
		assertThat(wrap("word word word", 6), equalTo("word\nword\nword"));
	}

	@Test
	public void wrapThreeWordsAfterSecondSpace() throws Exception {
		assertThat(wrap("word word word", 11), equalTo("word word\nword"));
	}

	private static String wrap(final String s, final int col) {
		return WordWrapper1.wrap(s, col);
	}
}
