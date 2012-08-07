package com.supermarket;

public class Total {

	private int total = 0;

	public void addItem(final Item item) {
		this.total = item.plusTotal(this.total);
	}

	public void addDiscount(final int recuction) {
		this.total -= recuction;
	}

	public String print() {
		return "Total: " + this.total + "p";
	}
}
