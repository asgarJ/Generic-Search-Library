package search;

import java.util.Set;

public interface State {
	
	Set<Action> getPossibleActions();
	
	State getActionResult(Action action);
	
	boolean equals(Object that);
	
	int hashCode();
}
