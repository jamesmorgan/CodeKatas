public class Discount {

	private Total total;

	private Receipt receipt;

	private int quantity;

	private int reduction;

	private int tally;

	private String name;

	public Discount(final Total total, final Receipt receipt, final int quantity, final int reduction, final String name) {
		super();
		this.total = total;
		this.receipt = receipt;
		this.quantity = quantity;
		this.reduction = reduction;
		this.tally = 0;
		this.name = name;
	}

	public void addItem() {
		this.tally++;

		if (this.tally % this.quantity == 0) {
			this.total.subtract(this.reduction);
			this.receipt.print(this.name);
		}
	}
}
