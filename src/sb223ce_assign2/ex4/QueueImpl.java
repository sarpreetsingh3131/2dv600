package sb223ce_assign2.ex4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl<E> implements Queue<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public QueueImpl() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public void enqueue(E element) {
		Node<E> node = new Node<E>(element);
		if (this.isEmpty()) { // if empty add it as head
			this.head = node;
			this.tail = this.head; // only 1 element -> head and tail is same
		} else {
			this.tail.next = node; // add it after last element
			this.tail = this.tail.next; // now this is the tail
		}
		this.size++;
	}

	@Override
	public E dequeue() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException("Queue is Empty!!");
		}
		E value = this.head.value; // get value
		this.head = this.head.next; // now next node is head as we are removing the value
		this.size--;
		return value;
	}

	@Override
	public E first() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException("Queue is Empty!!");
		}
		return this.head.value;
	}

	@Override
	public E last() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException("Queue is Empty!!");
		}
		return this.tail.value;
	}

	@Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	@Override
	public String toString() {
		Iterator<E> iterator = this.iterator();
		StringBuilder sb = new StringBuilder();
		iterator.forEachRemaining(element -> sb.append(element + ", "));
		String str = sb.toString();
		return str.isEmpty() ? "{}" : "{" + str.substring(0, str.length() - 2) + "}";
	}

	private class Node<T> {

		T value;
		Node<T> next;

		Node(T value) {
			this.value = value;
			this.next = null;
		}
	}

	private class QueueIterator implements Iterator<E> {

		Node<E> node;

		QueueIterator() {
			this.node = head; // start from head
		}

		@Override
		public boolean hasNext() {
			return this.node != null;
		}

		@Override
		public E next() {
			E value = this.node.value; // get value
			this.node = this.node.next; // move to next node
			return value;
		}
	}
}
