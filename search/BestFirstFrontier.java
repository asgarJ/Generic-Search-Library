package search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirstFrontier implements Frontier {
	
	protected int maxlength=0;
	PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(1000, new Comparator<Node>() {
		
		@Override
		public int compare(Node o1, Node o2) {
			return nodeFunction.getNodeValue(o1) - nodeFunction.getNodeValue(o2);
		}
	});
	NodeFunction nodeFunction;
	
	public BestFirstFrontier(NodeFunction nodeFunction) {
		this.nodeFunction = nodeFunction;
	}

	@Override
	public void clear() {
		priorityQueue.clear();
	}

	@Override
	public boolean isEmpty() {
		return priorityQueue.isEmpty();
	}

	@Override
	public Node remove() {
		return priorityQueue.remove();
	}

	@Override
	public void add(Node node) {
		priorityQueue.add(node);
		if(maxlength < priorityQueue.size())
			maxlength = priorityQueue.size();
	}

	@Override
	public int getMaxLength() {
		return maxlength;
	}
}
