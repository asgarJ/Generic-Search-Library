package search;

import java.util.HashSet;
import java.util.Set;

public class GraphSearch implements Search {

	Frontier frontier;
	private static int numberofNodes=0; 

	public GraphSearch(Frontier frontier) {
		this.frontier = frontier;
	}

	@Override
	public Node findSolution(Node initialNode, GoalTest goalTest) {

		HashSet<State> visitedStates = new HashSet<State>();

		frontier.add(initialNode);
		visitedStates.add(initialNode.state);
		numberofNodes++;

		while (!frontier.isEmpty()) {
			Node node = frontier.remove();

			if (goalTest.isGoal(node.state))
				return node;
			else {
				Set<Action> possibleActions = node.state.getPossibleActions();

				for (Action action : possibleActions) {

					State newState = node.state.getActionResult(action);
					if (!visitedStates.contains(newState)) {
						frontier.add(new Node(node, action, newState));
						visitedStates.add(newState);
						numberofNodes++;
					}
				}
			}
		}
		return null;
	}

	@Override
	public int getNumberofNodes() {
		return numberofNodes;
	}

}
