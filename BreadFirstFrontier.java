package search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadFirstFrontier implements Frontier {

	Queue<Node> queue = new LinkedList<Node>();
	private static int maxLength=0;
	
	@Override
	public void clear() {
		queue.clear();
		maxLength=0;
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public Node remove() {
		return queue.remove();
	}

	@Override
	public void add(Node node) {
		queue.add(node);
		if(queue.size() > maxLength)
			maxLength = queue.size();
	}

	@Override
	public int getMaxLength() {
		return maxLength;
	}

}
