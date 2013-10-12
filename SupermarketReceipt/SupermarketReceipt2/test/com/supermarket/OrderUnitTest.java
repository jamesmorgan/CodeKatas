package com.supermarket;

import org.junit.Test;

public class OrderUnitTest {

	@Test
	public void shouldPurchaseOrder() {
		final Order order = new Order();
		order.processOrder("AABAAC");
	}

}
