public class Item {

	private Total total;

	private Receipt receipt;

	private Discount discount;

	private String alias;

	private String name;

	private int price;

	public Item(final Total total, final Receipt receipt, final Discount discount, final String alias, final String name, final int price) {
		super();
		this.total = total;
		this.receipt = receipt;
		this.discount = discount;
		this.alias = alias;
		this.name = name;
		this.price = price;
	}

	public void purchase(final String currentItemAlias) {
		if (this.alias.equals(currentItemAlias)) {
			this.receipt.print(this.name + " " + this.price + "p");
			this.total.add(this.price);
			if (null != this.discount) {
				this.discount.addItem();
			}
		}
	}

}
