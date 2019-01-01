package sb223ce;

import java.util.*;
import graphs.*;

public class MyConnectedComponents<E> implements ConnectedComponents<E> {

	@Override
	public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
		Set<Collection<Node<E>>> components = new LinkedHashSet<>();
		Set<Node<E>> visited = new LinkedHashSet<>();
		MyDFS<E> dfs = new MyDFS<>();
		dg.iterator().forEachRemaining(node -> {
			if (!visited.contains(node)) {
				// do DFS on node to get all the reachable nodes
				Set<Node<E>> tempComponent = new LinkedHashSet<>(dfs.dfs(dg, node));
				visited.addAll(tempComponent);
				for (Collection<Node<E>> component : components) {
					if (!Collections.disjoint(component, tempComponent)) {
						component.addAll(tempComponent); // merge components
						tempComponent.clear();
						break;
					}
				}
				if (!tempComponent.isEmpty()) {
					components.add(tempComponent); // add new component
				}
			}
		});
		return components;
	}
}