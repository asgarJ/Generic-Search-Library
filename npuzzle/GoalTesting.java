package npuzzle;

import search.GoalTest;
import search.State;

public class GoalTesting implements GoalTest {

	protected Tiles state;

	public boolean isGoal(State tiles) {
		this.state = (Tiles) tiles;
		int lastTileIndex = state.width* state.width - 1;
		for (int index = lastTileIndex - 1; index >=0; --index)
			if (state.tiles[index] != index + 1)
				return false;
		return state.tiles[lastTileIndex] == Tiles.EMPTY_TILE;
	}
}
