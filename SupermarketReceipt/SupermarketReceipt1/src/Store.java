import java.util.ArrayList;
import java.util.List;

public class Store {

	public static void main(final String[] args) {

		final String input = "AABAAC";

		final Receipt receipt = new Receipt();

		final Total total = new Total(receipt);

		final Discount appleDiscount = new Discount(total, receipt, 3, 5, "Discount 3 apples for 100p");
		final Discount bananaDiscount = new Discount(total, receipt, 8, 50, "Discount 8 bananas for 150p");

		final Item apple = new Item(total, receipt, appleDiscount, "A", "Apple", 35);
		final Item banana = new Item(total, receipt, bananaDiscount, "B", "Banana", 25);
		final Item carrot = new Item(total, receipt, null, "C", "Carrot", 5);

		final List<Item> items = new ArrayList<Item>();
		items.add(apple);
		items.add(banana);
		items.add(carrot);

		final Order order = new Order(items, total, input);

		order.process();
	}

}
