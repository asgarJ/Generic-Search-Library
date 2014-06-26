package search;

public interface Frontier {

	void clear();
	
	boolean isEmpty();
	
	Node remove();
	
	void add(Node node);
	
	int getMaxLength();
}
