package sb223ce_assign2.ex5;

import sb223ce_assign2.ex4.QueueImpl;

import java.util.Iterator;

public class HashWordSet implements WordSet {

	private int size;
	private Node[] buckets;

	public HashWordSet() {
		this.size = 0;
		this.buckets = new Node[20];
	}

	@Override
	public void add(Word word) {
		if (!this.contains(word)) { // must not contain duplicates
			Node node = new Node(word);
			int bucketIndex = this.getBucketIndex(word);
			node.next = this.buckets[bucketIndex]; // shift existing node to right
			this.buckets[bucketIndex] = node; // add node
			if (++this.size >= this.buckets.length) { // look for rehash
				this.rehash();
			}
		}
	}

	@Override
	public boolean contains(Word word) {
		Node node = this.buckets[this.getBucketIndex(word)]; // get index
		while (node != null) { // iterate through all nodes
			if (node.word.equals(word)) {
				return true;
			} else {
				node = node.next;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Iterator<Word> iterator() {
		return new HashIterator();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		this.iterator().forEachRemaining(word -> sb.append(word + ", "));
		String str = sb.toString();
		return str.isEmpty() ? "{}" : "{" + str.substring(0, str.length() - 2) + "}";
	}

	private int getBucketIndex(Word word) {
		return word.hashCode() % this.buckets.length; // must be within bounds
	}

	private void rehash() {
		Node[] temp = this.buckets; // copy
		this.buckets = new Node[2 * this.buckets.length]; // increase the size 2 times
		this.size = 0; // size must be 0 as we will re-add all the nodes
		for (Node node : temp) { // go through each node and add it again
			while (node != null) {
				this.add(node.word);
				node = node.next;
			}
		}
	}

	private class Node {

		Word word;
		Node next;

		Node(Word word) {
			this.word = word;
			this.next = null;
		}
	}

	private class HashIterator implements Iterator<Word> {

		QueueImpl<Word> queue;

		HashIterator() {
			this.queue = new QueueImpl<>();
			Node node = null;

			// visit all buckets including their nodes and save them in queue
			for (int i = 0; i < buckets.length; i++) {
				if ((node = buckets[i]) != null) {
					this.queue.enqueue(node.word);
					while ((node = node.next) != null) {
						this.queue.enqueue(node.word);
					}
				}
			}
		}

		@Override
		public boolean hasNext() {
			return !this.queue.isEmpty();
		}

		@Override
		public Word next() {
			return this.queue.dequeue();
		}
	}
}
