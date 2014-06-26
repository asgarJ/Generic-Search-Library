package search;

import java.util.Set;

public class IterativeDeepingTreeSearch implements Search {

	private final int maxDepth = 20; 
	private static int numberofNodes = 0;
	Frontier frontier;
	
	public IterativeDeepingTreeSearch() {
		this.frontier = new DepthFirstFrontier();
	}
	
	@Override
	public Node findSolution(Node initialNode, GoalTest goalTest) {
		
		for (int limit = 1; limit <= maxDepth; limit++) {
			frontier.add(initialNode);
			numberofNodes++;
			
			while(!frontier.isEmpty()) {
				
				Node node = frontier.remove();
				
				if(goalTest.isGoal(node.state))
					return node;
				
				if(node.depth == limit)
					continue;
				
				Set<Action> possibleActions = node.state.getPossibleActions();
				for(Action action : possibleActions) {
					State state = node.state.getActionResult(action);
					frontier.add(new Node(node, action, state, node.depth+1));
					numberofNodes++;
				}
			}
		
		}
		return null;
	}

	public int getMaxLength() {
		return frontier.getMaxLength();
	}
	
	@Override
	public int getNumberofNodes() {
		return numberofNodes;
	}

}
