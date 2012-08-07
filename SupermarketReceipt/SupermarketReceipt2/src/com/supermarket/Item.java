package com.supermarket;

public class Item {

	private String name;
	private int price;
	private char aliais;
	private Discount discount;

	public Item(final char aliais, final String name, final int price) {
		this.aliais = aliais;
		this.name = name;
		this.price = price;
	}

	public Item(final char aliais, final String name, final int price, final Discount discount) {
		this.aliais = aliais;
		this.name = name;
		this.price = price;
		this.discount = discount;
	}

	public boolean isSame(final char item) {
		return this.aliais == item;
	}

	public boolean isValidForDiscount(final int total) {
		if (null == this.discount) {
			return false;
		}
		return this.discount.reached(total);
	}

	public StringBuilder reciptValue() {
		return new StringBuilder().append(this.name)
			.append(" ")
			.append(this.price)
			.append("p")
			.append("\n");
	}

	public String printDiscount() {
		return this.discount.print();
	}

	public int plusTotal(final int total) {
		return this.price + total;
	}

	public void applyDiscount(final Total total) {
		this.discount.apply(total);
	}

}
