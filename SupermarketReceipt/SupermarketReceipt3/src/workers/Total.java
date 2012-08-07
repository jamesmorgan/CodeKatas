package workers;

import bahaviours.Printer;

@SuppressWarnings("unqualified-field-access")
public class Total {

	private int total;

	public void printRecipt(final Printer receipt) {
		receipt.print("Total: " + total + "p");
	}

	public void add(final int price) {
		total += price;
	}

	public void deduct(final int price) {
		total -= price;
	}

}
