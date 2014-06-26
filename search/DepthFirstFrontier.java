package search;
import java.util.Stack;
public class DepthFirstFrontier implements Frontier {

	Stack<Node> stack = new Stack<Node>();
	private static int maxLength=0;
	
	@Override
	public void clear() {
		stack.clear();
		maxLength=0;
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public Node remove() {
		return stack.pop();
	}

	@Override
	public void add(Node node) {
		stack.add(node);
		if(stack.size() > maxLength)
			maxLength = stack.size();
	}

	@Override
	public int getMaxLength() {
		return maxLength;
	}

}
