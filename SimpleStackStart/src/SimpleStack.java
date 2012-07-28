public class SimpleStack implements IStack {

	private Link headLink = new NullLink();
	private int total = 0;

	@Override
	public boolean isEmpty() {
		return this.headLink.empty();
	}

	@Override
	public int size() {
		return this.total;
	}

	@Override
	public void add(final Object itemVal) {
		this.headLink = new Link(this.headLink, itemVal);
		this.total++;
	}

	@Override
	public Object top() {
		return this.headLink.getObject();
	}

	@Override
	public void remove() {
		this.headLink = this.headLink.getItem();
		this.total--;
	}

	private class Link {

		private Link headLink;
		private final Object object;

		public Link(final Link headLink, final Object object) {
			this.headLink = headLink;
			this.object = object;
		}

		public boolean empty() {
			return false;
		}

		public void add(final Object objectVal) {
			this.headLink.add(objectVal);
		}

		public Object getObject() {
			return this.object;
		}

		public Link getItem() {
			return this.headLink;
		}
	}

	private class NullLink extends Link {

		public NullLink() {
			super(null, null);
		}

		@Override
		public Object getObject() {
			throw new RuntimeException("No Items");
		}

		@Override
		public Link getItem() {
			throw new RuntimeException("No Items");
		}

		@Override
		public boolean empty() {
			return true;
		}
	}

}
