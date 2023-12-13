package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element != null) {

			if (isFull()) {
				throw new QueueOverflowException();
			}
			if (isEmpty()) {
				this.head = 0;
				this.tail = 0;
				this.array[head] = element;
			} else {
				this.tail = (tail + 1) % array.length;
				this.array[tail] = element;
			}
			this.elements += 1;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}

		T output = array[head];
		if (this.elements == 1) {
			this.head = -1;
			this.tail = -1;
		} else {
			this.head = (this.head + 1) % this.array.length;
		}
		this.elements -= 1;
		return output;
	}

	@Override
	public T head() {
		return this.array[head];
	}

	@Override
	public boolean isEmpty() {
		return (this.head == -1 && this.tail == -1);
	}

	@Override
	public boolean isFull() {
		return ((this.tail + 1) % this.array.length) == this.head;
	}

}
