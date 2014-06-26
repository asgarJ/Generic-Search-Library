package search;

public interface Search {

	Node findSolution(Node initialNode, GoalTest goalTest);
	
	int getNumberofNodes();
	
}
