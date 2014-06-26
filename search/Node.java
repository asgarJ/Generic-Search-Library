package search;

public class Node {
	
	public final Node parent;
	public final Action action;
	public final State state;
	public int depth;
	protected int value=0;
	protected int actualCost;
	
	public Node(Node parent, Action a, State s){
		this.parent = parent;
		this.action = a;
		this.state = s;
		if (parent == null) this.actualCost = 0;
		else
		this.actualCost = this.parent.actualCost + this.action.getActionCost(); 
	}
	public Node(Node parent, Action a, State s, int depth) {
		this.parent = parent;
		this.action = a;
		this.state = s;
		this.depth = depth;
	}

}
