package sb223ce;

import java.util.*;
import java.util.stream.Collectors;
import graphs.*;

public class MyBFS<E> implements BFS<E> {

	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
		Set<Node<E>> visited = new LinkedHashSet<>();
		this.bfs(root, visited);
		return visited.stream().collect(Collectors.toList());
	}

	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph) {
		Set<Node<E>> visited = new LinkedHashSet<>();
		// we only need heads to perform BFS as with heads we can reach all the nodes
		graph.heads().forEachRemaining(head -> this.bfs(head, visited));
		return visited.stream().collect(Collectors.toList());
	}

	private void bfs(Node<E> node, Set<Node<E>> visited) {
		Queue<Node<E>> queue = new LinkedList<>();
		queue.add(node);
		visited.add(node);
		node.num = visited.size(); // include visit number
		while (!queue.isEmpty()) {
			// dequeue node and visit its successors
			queue.poll().succsOf().forEachRemaining(successor -> {
				if (!visited.contains(successor)) {
					visited.add(successor);
					successor.num = visited.size();
					queue.add(successor); // save successor to visit its successors
				}
			});
		}
	}
}