package workers;

import java.util.ArrayList;
import java.util.List;

public class ItemDetails {

	private List<ItemDetail> details = new ArrayList<ItemDetail>();

	public void add(final ItemDetail itemDetail) {
		this.details.add(itemDetail);
	}

	public void addOrder(final char ordItm) {
		for (final ItemDetail item : this.details) {
			item.purchased(ordItm);
		}
	}

}
