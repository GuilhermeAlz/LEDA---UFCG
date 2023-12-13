package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.getData() == null;
	}

	@Override
	public int size() {
		int size = 0;

		if (!isEmpty()) {
			SingleLinkedListNode<T> aux = this.head;
			while (aux != null) {
				aux = aux.next;
				size += 1;
			}
		}
		return size;
	}

	@Override
	public T search(T element) {
		T output = null;

		if (!isEmpty()) {
			SingleLinkedListNode<T> aux = this.head;
			while (aux != null) {
				if (aux.getData() == element) {
					output = aux.getData();
					break;
				}
				aux = aux.next;
			}
		}
		return output;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			this.head = new SingleLinkedListNode<T>(element, null);
		} else {
			SingleLinkedListNode<T> aux = this.head;
			while (aux.next != null) {
				aux = aux.next;
			}
			aux.next = new SingleLinkedListNode<T>(element, null);
		}
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> aux = this.head;
		while (aux.next != null && aux.next.data != element) {
			aux = aux.next;
		}
		if (aux.next != null) {
			aux.next = aux.next.next;
		}
	}

	@Override
	public T[] toArray() {
		SingleLinkedListNode<T> aux = this.head;
		int tamanho = size();
		Object[] output = (T[]) new Object[tamanho];

		for (int i = 0; i < tamanho; i++) {
			output[i] = aux.getData();
			aux = aux.next;
		}

		return (T[]) output;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
