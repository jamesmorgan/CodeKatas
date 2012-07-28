public class CopyOfSimpleStack implements IStack {

	private Link headLink;

	private int total = 0;

	@Override
	public boolean isEmpty() {
		return null == this.headLink;
	}

	@Override
	public int size() {

		return this.total;
	}

	@Override
	public void add(final Object itemVal) {
		if (this.headLink == null) {
			this.headLink = new Link(itemVal);
		}
		else {
			this.headLink.add(itemVal);
		}
		this.total++;
	}

	@Override
	public Object top() {
		if (this.headLink == null) {
			throw new RuntimeException("No Items");
		}
		return this.headLink.getObject();
	}

	@Override
	public void remove() {
		if (this.headLink == null) {
			throw new RuntimeException("No Items");
		}

		this.headLink = this.headLink.getItem();
		this.total--;
	}

	private class Link {

		private Link item;
		private final Object object;

		public Link(final Object object) {
			this.object = object;
		}

		public void add(final Object objectVal) {
			if (this.item == null) {
				this.item = new Link(objectVal);
			}
			else {
				this.item.add(objectVal);
			}
		}

		public Object getObject() {
			return this.object;
		}

		public Link getItem() {
			return this.item;
		}

	}

}
