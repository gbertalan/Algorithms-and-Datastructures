package Queues;

public class ArrayQueue<E> implements Queue<E> {

	public static final int CAPACITY = 1000;
	private E[] data;
	private int f = 0; // index of the front element [it's needed for storing circularly in the array]
	private int sz = 0; // current number of elements

	public ArrayQueue() {
		// TODO Auto-generated constructor stub
		this(CAPACITY);
	}

	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return sz;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (sz == 0);
	}

	@Override
	public void enqueue(E e) throws IllegalStateException {
		// TODO Auto-generated method stub
		if (sz == data.length) {
			throw new IllegalStateException("Queue is full");
		}
		int avail = (f + sz) % (data.length); // to wrap around (using array circularly)
		data[avail] = e;
		sz++;
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		return data[f];
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		E answer = data[f];
		data[f] = null;
		f = (f + 1) % (data.length);
		sz--;
		return answer;
	}

}
