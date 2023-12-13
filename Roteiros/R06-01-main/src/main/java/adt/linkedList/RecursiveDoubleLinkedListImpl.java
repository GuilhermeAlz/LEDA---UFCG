package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		if (isEmpty()) {
			this.data = element;
			this.next = new RecursiveDoubleLinkedListImpl<T>();
			this.previous = null;
		} else {
			RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<T>();
			aux.next = this.next;
			aux.data = this.data;
			aux.previous = this;
			this.next = aux;
			this.data = element;
			this.previous = null;
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			this.data = this.next.data;
			this.next = this.next.next;
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			if (next.isEmpty()) {
				this.previous.next = new RecursiveDoubleLinkedListImpl<T>();
			} else {
				((RecursiveDoubleLinkedListImpl<T>) next).removeLast();
			}
		}
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			this.data = element;
			this.next = new RecursiveSingleLinkedListImpl<T>();
			this.previous = null;
		} else if (this.next.isEmpty()) {
			this.next.data = element;
			this.next.next  = new RecursiveSingleLinkedListImpl<>();
			((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(this);
		} else {
			this.next.insert(element);
		}
	}


	@Override
	public void remove(T element) {
		if (isEmpty()) {

		} else {
			if (data == element) {
				if (previous.isEmpty() && next.isEmpty()) {
					data = null;
					next = null;
					previous = null;
				} else {
					data = next.data;
					next = next.next;
					if (next != null) {
						((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(this);
					}
				}
			} else {
				next.remove(element);
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
