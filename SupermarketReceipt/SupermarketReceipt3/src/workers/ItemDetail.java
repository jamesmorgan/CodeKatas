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
		if (item.isBeingPruchrased(ordItm)) {
			quantityPurchased++;

			if (item.isDiscounted(quantityPurchased)) {
				item.applyDiscount(itemListener, receipt);
			}
			else {
				item.applyCost(itemListener);
				item.printReceipt(receipt);
			}
		}
	}
}
