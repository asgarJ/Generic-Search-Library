package tour;

import search.GoalTest;
import search.State;

public class TourGoalTest implements GoalTest{
	
	public boolean isGoal(State state){
		
		TourState checkState = (TourState) state;
		
		if(checkState.currentCity.name.equals("Bucharest")){
			
			return (checkState.exploredPath.size() == 10);
				
		}
		else return false;
	} 

}
