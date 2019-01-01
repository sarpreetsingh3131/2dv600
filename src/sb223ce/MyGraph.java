package sb223ce;

import java.util.*;
import java.util.stream.Collectors;

import graphs.*;

public class MyGraph<E> implements DirectedGraph<E> {

	private Map<E, Node<E>> nodes;

	public MyGraph() {
		nodes = new LinkedHashMap<>();
	}

	private Node<E> getNode(E item) {
		// Java 8 feature that throw exception if item is null, else return E or null
		return this.nodes.get(Optional.of(item).get());
	}

	@Override
	public Node<E> addNodeFor(E item) {
		Node<E> node = this.getNode(item); // look if node already exists
		if (node == null) {
			node = new MyNode<E>(item);
			this.nodes.put(item, node); // add new node
		}
		return node;
	}

	@Override
	public Node<E> getNodeFor(E item) {
		// if this.getNote() return null throw exception, else return Node<E>
		return Optional.of(this.getNode(item)).get();
	}

	@Override
	public boolean addEdgeFor(E from, E to) {
		MyNode<E> source = (MyNode<E>) this.addNodeFor(from);
		MyNode<E> target = (MyNode<E>) this.addNodeFor(to);
		boolean hasEdge = source.hasSucc(target);
		if (!hasEdge) { // add edge
			source.addSucc(target);
			target.addPred(source);
		}
		return !hasEdge; // true if there was no edge, else false
	}

	@Override
	public boolean containsNodeFor(E item) {
		return this.nodes.containsKey(Optional.of(item).get());
	}

	@Override
	public int nodeCount() {
		return this.nodes.size();
	}

	@Override
	public Iterator<Node<E>> iterator() {
		return this.nodes.values().iterator();
	}

	@Override
	public Iterator<Node<E>> heads() {
		return this.nodes.values().stream().filter(node -> node.isHead()).iterator();
	}

	@Override
	public int headCount() {
		return (int) this.nodes.values().stream().filter(node -> node.isHead()).count();
	}

	@Override
	public Iterator<Node<E>> tails() {
		return this.nodes.values().stream().filter(node -> node.isTail()).iterator();
	}

	@Override
	public int tailCount() {
		return (int) this.nodes.values().stream().filter(node -> node.isTail()).count();
	}

	@Override
	public List<E> allItems() {
		return this.nodes.keySet().stream().collect(Collectors.toList());
	}

	@Override
	public int edgeCount() {
		return (int) this.nodes.values().stream().mapToInt(node -> node.outDegree()).sum();
	}

	@Override
	public void removeNodeFor(E item) {
		MyNode<E> node = (MyNode<E>) this.getNode(item);
		node.predsOf().forEachRemaining(n -> ((MyNode<E>) n).removeSucc(node));
		node.succsOf().forEachRemaining(n -> ((MyNode<E>) n).removePred(node));
		node.disconnect();
		this.nodes.remove(item);
	}

	@Override
	public boolean containsEdgeFor(E from, E to) {
		Node<E> source = this.getNode(from);
		Node<E> target = this.getNode(to);
		return source != null && source.hasSucc(target);
	}

	@Override
	public boolean removeEdgeFor(E from, E to) {
		if (this.containsEdgeFor(from, to)) {
			MyNode<E> source = (MyNode<E>) this.getNode(from);
			MyNode<E> target = (MyNode<E>) this.getNode(to);
			source.removeSucc(target);
			target.removePred(source);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("{\n\tTotal nodes = " + this.nodeCount() + "\n");
		str.append("\tTotal edges = " + this.edgeCount() + "\n");
		str.append("\tNodes:\t\n");
		this.nodes.values().forEach(node -> {
			str.append("\t\tNode = " + node.toString() + "\n");
			str.append("\t\tPredecessors = ");
			node.predsOf().forEachRemaining(predecessor -> str.append("Node" + predecessor.toString() + " "));
			str.append("\n\t\tSuccessors = ");
			node.succsOf().forEachRemaining(successor -> str.append("Node" + successor.toString() + " "));
			str.append("\n\n");
		});
		return str.toString().substring(0, str.length() - 2) + "\n}";
	}
}