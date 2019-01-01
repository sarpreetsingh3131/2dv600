package sb223ce_assign2.ex5;

import java.util.Iterator;

public class TreeWordSet implements WordSet {

	private Node root;
	private int size;

	public TreeWordSet() {
		this.root = null;
		this.size = 0;
	}

	@Override
	public void add(Word word) {
		Node node = new Node(word);
		if (this.size() == 0) {
			this.root = node; // if empty add it as a root
			this.size++;
		} else if (!this.root.contains(node)) {
			this.root.add(node); // if not contains add it to the tree
			this.size++;
		}
	}

	@Override
	public boolean contains(Word word) {
		// isEmpty -> false, tree does not contains -> false ELSE true
		return this.size() != 0 && this.root.contains(new Node(word));
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Iterator<Word> iterator() {
		return new TreeIterator();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		this.iterator().forEachRemaining(word -> sb.append(word + ", "));
		String str = sb.toString();
		return str.isEmpty() ? "{}" : "{" + str.substring(0, str.length() - 2) + "}";
	}

	// a very simple stack that is used to iterate over the tree
	private class WordStack {

		Word[] words;
		int index;

		WordStack() {
			this.words = new Word[size]; // the same size as this tree word set
			this.index = 0;
		}

		void push(Word word) {
			this.words[this.index++] = word;
		}

		Word pop() {
			return this.words[--this.index];
		}

		boolean isEmpty() {
			return this.index == 0;
		}
	}

	private class TreeIterator implements Iterator<Word> {

		WordStack stack;

		TreeIterator() {
			this.stack = new WordStack();
			root.doInOrderTraverse(this.stack); // fill the stack
		}

		@Override
		public boolean hasNext() {
			return !this.stack.isEmpty();
		}

		@Override
		public Word next() {
			return this.stack.pop();
		}
	}

	private class Node {

		Word word;
		Node left;
		Node right;

		Node(Word word) {
			this.word = word;
			this.left = null;
			this.right = null;
		}

		void add(Node node) {
			if (this.word.compareTo(node.word) < 0 && this.left == null) {
				this.left = node; // add to left because it is smaller than the parent node
			} else if (this.word.compareTo(node.word) < 0 && this.left != null) {
				this.left.add(node); // find empty node
			} else if (this.word.compareTo(node.word) > 0 && this.right == null) {
				this.right = node;// add to right because it is greater than the parent node
			} else if (this.word.compareTo(node.word) > 0 && this.right != null) {
				this.right.add(node); // find empty node
			}
		}

		// value = 0 -> true (node = root)
		// value < 0 -> left node = null -> false ELSE recursively compareTo with it
		// value > 0 -> right node = null -> false ELSE recursively compareTo with it
		boolean contains(Node node) {
			int value = this.word.compareTo(node.word);
			return value == 0 || (value < 0 ? this.left != null && this.left.contains(node)
					: this.right != null && this.right.contains(node));
		}

		// recursively do in order traverse (Left, Parent, Right)
		// and save words in stack
		void doInOrderTraverse(WordStack stack) {
			if (this.left != null) {
				this.left.doInOrderTraverse(stack);
			}
			stack.push(word);
			if (this.right != null) {
				this.right.doInOrderTraverse(stack);
			}
		}
	}
}
