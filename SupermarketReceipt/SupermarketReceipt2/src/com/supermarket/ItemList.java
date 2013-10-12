package com.supermarket;

import java.util.ArrayList;
import java.util.List;

public class ItemList {

	List<ItemListener> itemListeners = new ArrayList<ItemListener>();

	public void addItemListener(final ItemListener itemListener) {
		this.itemListeners.add(itemListener);
	}

	public void addOrder(final char item) {
		for (final ItemListener listener : this.itemListeners) {
			listener.purchaseItem(item);
		}
	}

}
