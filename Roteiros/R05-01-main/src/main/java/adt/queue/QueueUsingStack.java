package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element != null) {

			if (isFull()) throw new QueueOverflowException();

			try {
				stack1.push(element);
			} catch (StackOverflowException e) {
				throw new QueueOverflowException();
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (stack1.isEmpty()) throw new QueueUnderflowException();

		try {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}

			T output = stack2.pop();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}

			return output;
		} catch (StackOverflowException | StackUnderflowException e) {
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		try {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			T head = stack2.top();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}

			return head;
		} catch (StackOverflowException | StackUnderflowException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}
}
