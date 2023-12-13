package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedListImpl<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element != null) {
			if (isFull()) {
				throw new QueueOverflowException();
			}
			this.list.insert(element);
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T output = head();
		this.list.removeFirst();
		return output;
	}

	@Override
	public T head() {
		T output = null;
		if (!isEmpty()) {
			output = this.list.Head();
		}
		return output;
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.size == this.list.size();
	}

}
