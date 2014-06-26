package tour;

import search.Node;
import search.NodeFunction;

public class FurthestCityHeuristic implements NodeFunction{

	City goal;
	public FurthestCityHeuristic(City goal){
		this.goal = goal;
	}
	@Override
	public int getNodeValue(Node node) {
		TourState state = (TourState) node.state;
		int max = -	1;
		int distance = 0;
		for(Road road : state.currentCity.outgoingRoads) {
			if(!state.exploredPath.contains(road.targetCity) && road.length > max) {
				max = road.length;
				City furthestCity = road.targetCity;
				distance = max + furthestCity.getShortestDistanceTo(goal);
			}
		}		
		return distance;
	}

}
