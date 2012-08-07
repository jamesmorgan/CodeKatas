package workers;

import bahaviours.PriceListener;
import bahaviours.Printer;

@SuppressWarnings("unqualified-field-access")
public class Discount {

	public static final Discount NONE = new Discount(0, 0, "");

	private final int discount;
	private final int quantity;
	private final String discountLabel;

	public Discount(final int quantity, final int discount, final String discountLabel) {
		this.quantity = quantity;
		this.discount = discount;
		this.discountLabel = discountLabel;
	}

	public boolean isApplicable(final int quantityPurchased) {
		return quantity == quantityPurchased;
	}

	public void applyDiscount(final PriceListener itemListener, final Printer receipt) {
		itemListener.deducted(discount);
		receipt.print(discountLabel);
	}

}
