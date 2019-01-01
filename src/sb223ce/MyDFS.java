package sb223ce;

import java.util.*;
import java.util.stream.Collectors;
import graphs.*;

public class MyDFS<E> implements DFS<E> {

	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
		Set<Node<E>> visited = new LinkedHashSet<>();
		this.dfs(root, visited);
		return visited.stream().collect(Collectors.toList());
	}

	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph) {
		Set<Node<E>> visited = new LinkedHashSet<>();
		// we only need heads to perform DFS as with heads we can reach all the nodes
		graph.heads().forEachRemaining(head -> this.dfs(head, visited));
		return visited.stream().collect(Collectors.toList());
	}

	private void dfs(Node<E> node, Set<Node<E>> visited) {
		if (!visited.contains(node)) {
			visited.add(node);
			node.num = visited.size(); // include visit number
			node.succsOf().forEachRemaining(successor -> this.dfs(successor, visited)); // visit successors
		}
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
		List<Node<E>> postOrder = new LinkedList<>();
		this.postOrder(root, new LinkedHashSet<>(), postOrder);
		return postOrder;
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g) {
		Set<Node<E>> visited = new LinkedHashSet<>();
		List<Node<E>> postOrder = new LinkedList<>();
		g.iterator().forEachRemaining(node -> this.postOrder(node, visited, postOrder));
		return postOrder;
	}

	private void postOrder(Node<E> node, Set<Node<E>> visited, List<Node<E>> postOrder) {
		if (!visited.contains(node)) {
			visited.add(node);
			node.succsOf().forEachRemaining(successor -> this.postOrder(successor, visited, postOrder));
			postOrder.add(node); // add node after visiting its successors
			node.num = postOrder.size();
		}
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
		Map<E, Node<E>> map = new LinkedHashMap<>(); // using map for increasing the search speed
		this.postOrder(g).forEach(node -> map.put(node.item(), node)); // get nodes in post order
		if (attach_dfs_number) {
			// do DFS and then update the visit number of each node
			this.dfs(g).forEach(node -> map.get(node.item()).num = node.num);
		}
		return map.values().stream().collect(Collectors.toList());
	}

	@Override
	public boolean isCyclic(DirectedGraph<E> graph) {
		for (Node<E> node : this.postOrder(graph)) { // get nodes in post order
			for (Iterator<Node<E>> successor = node.succsOf(); successor.hasNext();) {
				if (node.num <= successor.next().num) { // look for backward edge
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<Node<E>> topSort(DirectedGraph<E> graph) {
		List<Node<E>> postOrder = this.postOrder(graph);
		Collections.reverse(postOrder); // topological sort is reverse of post order
		return postOrder;
	}
}