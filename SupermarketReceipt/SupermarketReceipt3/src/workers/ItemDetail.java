package workers;

import bahaviours.PriceListener;
import bahaviours.Printer;

public class ItemDetail {

	private Item item;
	private Printer receipt;
	private PriceListener itemListener;

	private int quantityPurchased;

	public ItemDetail(final Item item, final PriceListener itemListener, final Printer receipt) {
		this.item = item;
		this.itemListener = itemListener;
		this.receipt = receipt;
	}

	public void purchased(final char ordItm) {
		if (this.item.isBeingPruchrased(ordItm)) {
			this.quantityPurchased++;

			if (this.item.isDiscounted(this.quantityPurchased)) {
				this.item.applyDiscount(this.itemListener, this.receipt);
			}
			else {
				this.item.applyCost(this.itemListener);
				this.item.printReceipt(this.receipt);
			}
		}
	}
}
