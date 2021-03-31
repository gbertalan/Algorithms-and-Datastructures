package Queues;

public interface CircularQueue<E> extends Queue<E> {
	
	/** Rotates the front element of the queue to the back of the queue. **/
	void rotate();
	

}
