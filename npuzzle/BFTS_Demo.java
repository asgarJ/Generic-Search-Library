package npuzzle;

import search.*;

public class BFTS_Demo {
	public static void main(String[] args) {
		//System.out.println("This is a demonstration of breadth-first graph search on 8-puzzle");
		
		State initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
		
		System.out.println("A* Tree Search Results");
		
		Node firstNode = new Node(null, null, initialConfiguration);
		MisplacedTilesHeuristicFunction heuristicFunction = new MisplacedTilesHeuristicFunction();
		AStarFunction ASS = new AStarFunction(heuristicFunction);
		
		BestFirstFrontier frontier = new BestFirstFrontier(ASS);
		TreeSearch ASTreeSearch = new TreeSearch(frontier);
		Node ASsolution = ASTreeSearch.findSolution(firstNode, new GoalTesting());
		new TilesPrinting().printSolution(ASsolution);
		System.out.println("Number of Nodes generated:\t"+ASTreeSearch.getNumberofNodes());
		System.out.println("Maximum Length of Frontier:\t" + frontier.getMaxLength());
		frontier.clear();
		
		System.out.println("\n\nA* Graph Search Results");
		
		GraphSearch ASGraphSearch = new GraphSearch(frontier);
		Node ASGraphsolution = ASGraphSearch.findSolution(firstNode, new GoalTesting());
		new TilesPrinting().printSolution(ASGraphsolution);
		System.out.println("Number of Nodes generated:\t"+ASGraphSearch.getNumberofNodes());
		System.out.println("Maximum Length of Frontier:\t" + frontier.getMaxLength());
		
	}
}
