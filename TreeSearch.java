package search;

import java.util.Set;

public class TreeSearch implements Search {

	Frontier frontier;
	private static int numberofNodes=0;
	
	public TreeSearch(Frontier frontier) {
		this.frontier = frontier;
	}
	
	@Override
	public Node findSolution(Node initialNode, GoalTest goalTest) {
		frontier.add(initialNode);
		numberofNodes++;
		
		while(!frontier.isEmpty()) {
			Node node = frontier.remove();
			
			if(goalTest.isGoal(node.state)) {
				return node;
			}
			else {
				Set<Action> possibleActions = node.state.getPossibleActions();
				for(Action action : possibleActions) {
					frontier.add(new Node(node, action, node.state.getActionResult(action)));
					numberofNodes++;
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
