package tour;

import java.util.LinkedHashSet;

import search.*;

public class Demo {

	public static void main(String[] args){

		new SetUpRomania();
		Cities start = SetUpRomania.getRomaniaMapSmall();
		City test = start.citiesByName.get("Bucharest");
		
		State initialConfiguration = new TourState(start.getState("Bucharest"), new LinkedHashSet<City>());

		
		System.out.println("A Star Tree Search\n");

		Node initialNode = new Node(null, null, initialConfiguration);
		FurthestCityHeuristic heuristic = new FurthestCityHeuristic(test);
		AStarFunction ASfunc = new AStarFunction(heuristic);
		
		BestFirstFrontier frontier = new BestFirstFrontier(ASfunc);
		
		TreeSearch TS = new TreeSearch(frontier);
		
		Node AStarSolution = TS.findSolution(initialNode, new TourGoalTest());
		new TourPrinting().printSolution(AStarSolution);
		
		System.out.println("Number of nodes generated:\t"+TS.getNumberofNodes());
		System.out.println("Maximum Length of frontier:\t"+frontier.getMaxLength());
		frontier.clear();
		
		System.out.println("\n\nA Star Graph Search\n");
		
		GraphSearch GS = new GraphSearch(frontier);
		
		Node AStarSolutionG = GS.findSolution(initialNode, new TourGoalTest());
		new TourPrinting().printSolution(AStarSolutionG);
		
		System.out.println("Number of nodes generated:\t"+GS.getNumberofNodes());
		System.out.println("Maximum Length of frontier:\t"+frontier.getMaxLength());
	}
}
