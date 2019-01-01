package sb223ce;

import java.util.*;

import graphs.*;

public class MyGML<E> extends GML<E> {

	public MyGML(DirectedGraph<E> dg) {
		super(dg);
	}

	@Override
	public String toGML() {
		StringBuilder str = new StringBuilder();
		List<Node<E>> nodes = new LinkedList<>();
		str.append("graph\n[\n\thierarchic\t1\n\tlabel\t\"\"\n\tdirected\t1\n");

		super.graph.allItems().forEach(item -> { // write nodes
			nodes.add(super.graph.getNodeFor(item));
			str.append("\tnode\n\t[\n");
			str.append("\t\tid\t" + nodes.size() + "\n");
			str.append("\t\tlabel\t\"" + item.toString() + "\"\n");
			str.append("\t\tgraphics\n\t\t[\n\t\t\ttype\t\"rectangle\"\n\t\t\tfill\t\"#FFCC00\"\n\t\t]\n");
			str.append("\t]\n");
		});

		nodes.forEach(node -> { // write edges
			node.succsOf().forEachRemaining(successor -> {
				str.append("\tedge\n\t[\n");
				str.append("\t\tsource\t" + (nodes.indexOf(node) + 1) + "\n");
				str.append("\t\ttarget\t" + (nodes.indexOf(successor) + 1) + "\n");
				str.append("\t\tgraphics\n\t\t[\n\t\t\tfill\t\"#000000\"\n\t\t\ttargetArrow\t\"standard\"\n\t\t]\n");
				str.append("\t]\n");
			});
		});
		return str.toString() + "]";
	}
}