package com.supermarket;

public class ItemListener {

	private Item item;
	private Total total;
	private Receipt receipt;
	private DeductionNotifer discounter;

	private int totalQuantity;

	public ItemListener(final Item item, final Receipt receipt, final Total total, final DeductionNotifer discounter) {
		this.item = item;
		this.receipt = receipt;
		this.total = total;
		this.discounter = discounter;
	}

	public void purchaseItem(final char i) {
		if (this.item.isSame(i)) {

			this.totalQuantity++;

			this.total.addItem(this.item);
			this.receipt.printValue(this.item);

			if (this.item.isValidForDiscount(this.totalQuantity)) {
				this.discounter.totalReduced(this.item);
			}

		}
	}
}
