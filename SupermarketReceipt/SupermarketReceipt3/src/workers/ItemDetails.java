package workers;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unqualified-field-access")
public class ItemDetails {

	private List<ItemDetail> details = new ArrayList<ItemDetail>();

	public void add(final ItemDetail itemDetail) {
		details.add(itemDetail);
	}

	public void addOrder(final char ordItm) {
		for (final ItemDetail item : details) {
			item.purchased(ordItm);
		}
	}

}
