
public interface PriorityQueue<T> {
	
	void insert(int key, T value);
	void removeMin();
	int min();
	int size();
	int isEmpty();
}
