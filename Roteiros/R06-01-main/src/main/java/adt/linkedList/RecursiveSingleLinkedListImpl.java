package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			return 1 + next.size();
		}
	}

	@Override
	public T search(T element) {
		T output = null;
		if (!isEmpty()) {
			if (this.data == element) {
				output = this.data;
			} else {
				output = next.search(element);
			}
		}
		return output;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			this.data = element;
			this.next = new RecursiveSingleLinkedListImpl<T>();
		} else if (this.next.data == null) {
			this.next.data = element;
			this.next.next  = new RecursiveSingleLinkedListImpl<>();
		} else {
			this.next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if (this.data == element) {
				this.data = this.next.data;
				this.next = this.next.next;
			}

			if (this.next != null && this.next.data == element) {
				this.next = this.next.next;
			} else if (this.next != null){
				this.next.remove(element);
			}
		}
	}

	private void toArray(T[] result, RecursiveSingleLinkedListImpl<T> node, int index) {
		if (!node.isEmpty()) {
			result[index] = node.data;
			toArray(result, node.next, index += 1);
		}
	}

	@Override
	public T[] toArray() {
		Object[] output = (T[]) new Object[size()];
		toArray((T[]) output, this, 0);
		return (T[]) output;
	}


	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
