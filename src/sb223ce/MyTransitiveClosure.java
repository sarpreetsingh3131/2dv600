package sb223ce;

import java.util.*;
import graphs.*;

public class MyTransitiveClosure<E> implements TransitiveClosure<E> {

	@Override
	public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
		Map<Node<E>, Collection<Node<E>>> closure = new LinkedHashMap<>();
		MyDFS<E> myDFS = new MyDFS<>();
		// do DFS to find all the reachable nodes from a node
		dg.iterator().forEachRemaining(node -> closure.put(node, myDFS.dfs(dg, node)));
		return closure;
	}
}