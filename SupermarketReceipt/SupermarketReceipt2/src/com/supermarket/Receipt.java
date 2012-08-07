package com.supermarket;

public class Receipt {

	private StringBuilder rceipt = new StringBuilder();

	public void printReceipt() {
		System.out.println(this.rceipt.toString());
	}

	public void printReceipt(final Total total) {
		System.out.println(this.rceipt.toString());
		System.out.println(total.print());
	}

	public void printValue(final Item item) {
		this.rceipt.append(item.reciptValue());
	}

	public void printValue(final String printDiscount) {
		this.rceipt.append(printDiscount)
			.append("\n");
	}

}
