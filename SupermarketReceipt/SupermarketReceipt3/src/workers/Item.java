package workers;

import bahaviours.PriceListener;
import bahaviours.Printer;

public class Item {

	private final Discount discount;
	private final char alais;
	private final String name;
	private final int price;

	public Item(final char alais, final String name, final int price, final Discount discount) {
		this.alais = alais;
		this.name = name;
		this.price = price;
		this.discount = discount;
	}

	public boolean isBeingPruchrased(final char ordItm) {
		return this.alais == ordItm;
	}

	public void printReceipt(final Printer receipt) {
		receipt.print(new StringBuilder().append(this.name)
			.append(" ")
			.append(this.price)
			.append("p")
			.toString());
	}

	public boolean isDiscounted(final int quantityPurchased) {
		return this.discount.isApplicable(quantityPurchased);
	}

	public void applyDiscount(final PriceListener itemListener, final Printer receipt) {
		this.discount.applyDiscount(itemListener, receipt);
	}

	public void applyCost(final PriceListener itemListener) {
		itemListener.added(this.price);
	}
}
