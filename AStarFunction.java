package search;

public class AStarFunction implements NodeFunction {

	NodeFunction heuristicFunction;
	public AStarFunction(NodeFunction heuristicFunction) {
		this.heuristicFunction = heuristicFunction;
	}
	
	@Override
	public int getNodeValue(Node node) {
		return (node.actualCost + heuristicFunction.getNodeValue(node));
	}

}
