package Deques;

public class ArrayDeque<E> implements Deque<E> {

	public static final int CAPACITY = 1000;
	private E[] data;
	private int f = 0; // index of the front element [it's needed for storing circularly in the array]
	private int sz = 0; // current number of elements

	public ArrayDeque() {
		// TODO Auto-generated constructor stub
		this(CAPACITY);
	}

	public ArrayDeque(int capacity) {
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
	public E first() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		return data[f];
	}

	@Override
	public E last() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		return data[f + sz - 1];
	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		if (sz == data.length) {
			throw new IllegalStateException("Deque is full");
		}
		f = (f - 1 + data.length) % (data.length); // to wrap around (using array circularly); also avoiding negatives.
		int avail = f;
		data[avail] = e;
		sz++;
	}

	@Override
	public void addLast(E e) throws IllegalStateException {
		// TODO Auto-generated method stub
		if (sz == data.length) {
			throw new IllegalStateException("Deque is full");
		}
		int avail = (f + sz) % (data.length); // to wrap around (using array circularly)
		data[avail] = e;
		sz++;
	}

	@Override
	public E removeFirst() {
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

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		E answer = data[(f + sz - 1) % data.length];
		data[(f + sz - 1) % data.length] = null;

		sz--;
		return answer;
	}

}
