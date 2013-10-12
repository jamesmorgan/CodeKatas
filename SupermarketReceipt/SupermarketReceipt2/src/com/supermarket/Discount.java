package com.supermarket;

public class Discount {

	private int deduction;
	private int quantity;
	private String message;

	public Discount(final int quantity, final int deduction, final String message) {
		this.quantity = quantity;
		this.deduction = deduction;
		this.message = message;
	}

	public boolean reached(final int total) {
		return this.quantity == total;
	}

	public String print() {
		return this.message;
	}

	public void apply(final Total total) {
		total.addDiscount(this.deduction);
	}
}
