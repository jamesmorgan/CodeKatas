package workers;

import bahaviours.PriceListener;
import bahaviours.Printer;

public class Order {

	public static void main(final String[] args) {
		new Order().processOrder("AABAAC");
	}

	private Total total = new Total();

	private ItemDetails availableItems = new ItemDetails();

	private PriceListener itemListener = new PriceListener() {
		@Override
		public void deducted(final int price) {
			total.deduct(price);
		}

		@Override
		public void added(final int price) {
			total.add(price);
		}
	};

	private Printer receipt = new Printer() {
		@Override
		public void print(final String message) {
			System.out.println(message);
		}
	};

	public Order() {
		availableItems.add(new ItemDetail(new Item('A', "Apple", 35, new Discount(3, 10, "Discount: 3 Apples for 100p")), itemListener, receipt));
		availableItems.add(new ItemDetail(new Item('B', "Banana", 25, new Discount(8, 50, "Discount: 8 Apples for 150p")), itemListener, receipt));
		availableItems.add(new ItemDetail(new Item('C', "Carrot", 35, Discount.NONE), itemListener, receipt));
	}

	public void processOrder(final String orderKeys) {
		for (final char ordItm : orderKeys.toCharArray()) {
			availableItems.addOrder(ordItm);
		}
		total.printRecipt(receipt);
	}
}
