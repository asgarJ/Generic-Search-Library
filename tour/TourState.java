package tour;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import search.Action;
import search.State;

public class TourState implements search.State{

	City currentCity;
	Set<City> exploredPath = new LinkedHashSet<City>();

	public TourState(City currentCity, LinkedHashSet<City> expSet){
		this.currentCity = currentCity;
		this.exploredPath = expSet;
	}

	@Override
	public Set<Action> getPossibleActions() {
		Set<Action> roads = new LinkedHashSet<Action>();
		for (Road road : currentCity.outgoingRoads){
			roads.add(road);
		}
		return roads;
	}

	@Override
	public State getActionResult(Action action) {
		Road road = (Road) action;
		LinkedHashSet<City> path = new LinkedHashSet<City>(exploredPath);
		path.add(currentCity);
		//print(exploredPath);
		//print(path);
		return new TourState(road.targetCity, path);
	}
	
	@Override
	public int hashCode() {
		return currentCity.name.hashCode() + exploredPath.hashCode();	// Maybe this.name.hashCode()
	}
	
	@Override
	public boolean equals(Object that) {
		TourState castedThat = (TourState) that;
		return (this.hashCode() == castedThat.hashCode());
	}
	


	public LinkedList<City> copyAll(LinkedList<City> path){
		for(City city : exploredPath) {
			path.add(city);
		}
		return path;
	}

	public void print(LinkedList<City> path){
		for(City city : path)
			System.out.print(city.name + " -> ");
		System.out.println();
	}
}
