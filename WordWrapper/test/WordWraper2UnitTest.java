import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WordWraper2UnitTest {

	@Test
	public void wrap_EmptyString_ShouldBeEmpty() throws Exception {
		assertThat(wrap("", 1), equalTo(""));
	}

	@Test
	public void stringShorterThanColDoesNotWrap() throws Exception {
		assertThat(wrap("word", 10), equalTo("word"));
	}

	@Test
	public void splitOneWord() throws Exception {
		assertThat(wrap("word", 2), equalTo("wo\nrd"));
	}

	@Test
	public void splitOneWordManyTimes() throws Exception {
		assertThat(wrap("abcdefghij", 3), equalTo("abc\ndef\nghi\nj"));
	}

	@Test
	public void wrapOnWordBoundary() throws Exception {
		assertThat(wrap("word word", 5), equalTo("word\nword"));
	}

	@Test
	public void wrapAfterWordBoundary() throws Exception {
		assertThat(wrap("word word", 6), equalTo("word\nword"));
	}

	@Test
	public void wrapWellBeforeWordBoundary() throws Exception {
		assertThat(wrap("word word", 3), equalTo("wor\nd\nwor\nd"));
	}

	@Test
	public void wrapJustBeforeWordBoundary() throws Exception {
		assertThat(wrap("word word", 4), equalTo("word\nword"));
	}

	private static String wrap(final String s, final int col) {
		return WordWrapper2.wrap(s, col);
	}
}
