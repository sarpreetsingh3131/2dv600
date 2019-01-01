package sb223ce;

import java.util.*;
import graphs.*;

public class MyNode<E> extends Node<E> {

	private Set<Node<E>> predecessor;
	private Set<Node<E>> successor;

	protected MyNode(E item) {
		super(item);
		this.predecessor = new LinkedHashSet<>();
		this.successor = new LinkedHashSet<>();
	}

	@Override
	public boolean hasSucc(Node<E> node) {
		return this.successor.contains(node);
	}

	@Override
	public int outDegree() {
		return this.successor.size();
	}

	@Override
	public Iterator<Node<E>> succsOf() {
		return this.successor.iterator();
	}

	@Override
	public boolean hasPred(Node<E> node) {
		return this.predecessor.contains(node);
	}

	@Override
	public int inDegree() {
		return this.predecessor.size();
	}

	@Override
	public Iterator<Node<E>> predsOf() {
		return this.predecessor.iterator();
	}

	@Override
	protected void addSucc(Node<E> succ) {
		this.successor.add(succ);
	}

	@Override
	protected void removeSucc(Node<E> succ) {
		this.successor.remove(succ);
	}

	@Override
	protected void addPred(Node<E> pred) {
		this.predecessor.add(pred);
	}

	@Override
	protected void removePred(Node<E> pred) {
		this.predecessor.remove(pred);
	}

	@Override
	protected void disconnect() {
		this.successor.clear();
		this.predecessor.clear();
	}
}