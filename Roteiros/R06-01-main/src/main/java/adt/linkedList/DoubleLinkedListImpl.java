package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, null, null);
		if (isEmpty()) {
			this.head = newNode;
			this.last = newNode;
		} else {
			((DoubleLinkedListNode<T>) this.head).previous = newNode;
			newNode.next = this.head;
			this.head = newNode;
		}
	}

	@Override
	public void removeFirst() {
		if (this.head.next == null) {
			this.head.data = null;
			this.last = null;
		} else {
			this.head = this.head.next;
			((DoubleLinkedListNode<T>) this.head).previous = null;
		}
	}

	@Override
	public void removeLast() {
		if (this.head.next == null) {
			this.head.data = null;
			this.last = null;
		} else {
			this.last = this.last.previous;
			this.last.next = null;
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;
			while (aux != null && aux.getData() != element) {
				aux = (DoubleLinkedListNode<T>) aux.next;
			}
			if (aux != null) {
				if (aux == this.head ) {
					removeFirst();
				} else if (aux == this.last) {
					removeLast();
				} else {
					((DoubleLinkedListNode<T>) aux.next).previous = aux.previous;
					aux.previous.next = aux.next;
				}
			}
		}


	}

	@Override
	public void insert(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, null, null);
		if (isEmpty()) {
			this.head = newNode;
			this.last = newNode;
		} else {
			this.last.next = newNode;
			newNode.previous = this.last;
			this.last = newNode;
		}
	}

	public T getLast() {
		return last.data;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

	public T Head() {
		return head.data;
	}
}
