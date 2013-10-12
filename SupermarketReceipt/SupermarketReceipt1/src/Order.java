import java.util.List;

public class Order {

	private List<Item> items;
	private Total total;
	private String orderInput;

	public Order(final List<Item> items, final Total total, final String orderInput) {
		super();
		this.items = items;
		this.total = total;
		this.orderInput = orderInput;
	}

	public void process() {

		for (int i = 0; i < this.orderInput.length(); i++) {
			final String currentItemAlias = String.valueOf(this.orderInput.charAt(i));
			for (final Item item : this.items) {
				item.purchase(currentItemAlias);
			}
		}

		this.total.checkout();
	}
}
