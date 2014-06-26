package npuzzle;

import search.Node;
import search.NodeFunction;

public class MisplacedTilesHeuristicFunction implements NodeFunction{

	@Override
	public int getNodeValue(Node node) {
		Tiles tiles = (Tiles) node.state;	// Changed node.state from final to static
		int res = 0;
		for(int i=0; i<tiles.width*tiles.width-1; i++) {
			if(tiles.tiles[i] != (i+1))
				res++;
		}
		return (tiles.tiles[tiles.width-1] == 0 ? res : res+1);
	}

}
