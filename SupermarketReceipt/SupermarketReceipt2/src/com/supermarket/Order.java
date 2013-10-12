package com.supermarket;

@SuppressWarnings("unqualified-field-access")
public class Order {

	private ItemList itemList = new ItemList();
	private Receipt receipt = new Receipt();
	private Total total = new Total();

	private DeductionNotifer discounter = new DeductionNotifer() {
		@Override
		public void totalReduced(final Item item) {
			receipt.printValue(item.printDiscount());
			item.applyDiscount(total);
		}
	};

	public Order() {
		this.itemList.addItemListener(new ItemListener(new Item('A', "Apple", 35, new Discount(3, 5, "Discount: 3 Apples for 100p")), this.receipt, this.total,
				this.discounter));

		this.itemList.addItemListener(new ItemListener(new Item('B', "Banana", 25, new Discount(8, 50, "Discount: 8 Apples for 150p")), this.receipt,
				this.total, this.discounter));

		this.itemList.addItemListener(new ItemListener(new Item('C', "Carrots", 5), this.receipt, this.total, this.discounter));
	}

	public void processOrder(final String order) {

		for (final char item : order.toCharArray()) {
			this.itemList.addOrder(item);
		}

		this.receipt.printReceipt(this.total);
	}
}
