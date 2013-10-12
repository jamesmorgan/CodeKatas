import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SimpleStackTest {

	Object testObject = new Object();

	@Test
	public void emptyQueueHasSize0() {
		final IStack stack = new SimpleStack();

		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
	}

	@Test
	public void singleEntryInQueueHasSize1() {
		final IStack stack = new SimpleStack();
		stack.add(this.testObject);

		assertEquals(1, stack.size());
		assertTrue(!stack.isEmpty());
	}

	@Test
	public void multiEntryInQueueHasCorrectSize() {
		final int size = 5;

		final IStack stack = new SimpleStack();
		for (int i = 0; i < size; i++) {
			stack.add(this.testObject);
		}

		assertEquals(size, stack.size());
		assertTrue(!stack.isEmpty());
	}

	@Test
	public void topShouldReturnFirstItem() {
		final int size = 5;

		final IStack stack = new SimpleStack();
		for (int i = 0; i < size; i++) {
			stack.add(new Integer(i));
		}

		assertEquals(stack.top(), Integer.valueOf(4));
	}

	@Test(expected = RuntimeException.class)
	public void topShouldReturnThrowExceptionIfNoItems() {
		final IStack stack = new SimpleStack();
		assertTrue(stack.isEmpty());
		stack.top();
	}

	@Test(expected = RuntimeException.class)
	public void topShouldThrowExceptionIfNoItemsWhenRemoving() {
		final IStack stack = new SimpleStack();
		assertTrue(stack.isEmpty());
		stack.remove();
	}

	@Test
	public void topShouldRemoveTop() {
		final int size = 5;

		final IStack stack = new SimpleStack();
		for (int i = 0; i < size; i++) {
			stack.add(new Integer(i));
		}
		assertEquals(stack.top(), Integer.valueOf(4));
		assertEquals(stack.size(), 5);
		stack.remove();
		assertEquals(stack.top(), Integer.valueOf(3));
		assertEquals(stack.size(), 4);
	}
}
