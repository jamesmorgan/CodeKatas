import org.junit.Test;

import workers.Order;


public class StoreTest {

	@Test
	public void shouldProcessOrder() {
		final Order store = new Order();
		store.processOrder("AABACA");
	}

}
