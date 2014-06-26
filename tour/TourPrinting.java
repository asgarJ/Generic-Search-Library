package tour;

import java.io.PrintStream;
import java.util.Stack;

import search.Printing;
import search.Node;

public class TourPrinting implements Printing {

	int cost = 0;
	PrintStream ps = new PrintStream(System.out);

	@Override
	public void printSolution(Node solution) {

		if (solution == null)
			ps.println("No Solution");

		Stack<Node> stack = new Stack<Node>();
		Node node = solution;

		while (node != null) {
			stack.push(node);
			node = node.parent;
		}

		while (!stack.isEmpty()) {
			node = stack.pop();
			if (node.parent == null) {
				ps.println("Start :");
			} else {
				cost += ((Road) node.action).cost();
				ps.println(((TourState) node.state).currentCity.getName()
						+ " --> " + cost);
			}
		}

	}
}