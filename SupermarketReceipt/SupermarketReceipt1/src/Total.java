public class Total {

	private Receipt receipt;

	private int total;

	public Total(final Receipt receipt) {
		super();
		this.receipt = receipt;
	}

	public void checkout() {
		this.receipt.print("Total " + this.total + "p");

	}

	public void add(final int price) {
		this.total += price;

	}

	public void subtract(final int reduction) {
		this.total -= reduction;
	}
}
