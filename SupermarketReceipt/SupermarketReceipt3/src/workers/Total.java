package workers;

import bahaviours.Printer;

public class Total {

	private int total;

	public void printRecipt(final Printer receipt) {
		receipt.print("Total: " + this.total + "p");
	}

	public void add(final int price) {
		this.total += price;
	}

	public void deduct(final int price) {
		this.total -= price;
	}

}
