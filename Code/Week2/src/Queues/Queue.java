package Queues;

public interface Queue<E> {

	int size();

	boolean isEmpty();

	void enqueue(E e);

	/** Returns (but does not remove) the first element **/
	E first();

	/** Removes and returns the first element **/
	E dequeue();
}
