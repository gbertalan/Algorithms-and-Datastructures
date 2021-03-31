package Iterators;

import java.nio.channels.IllegalSelectorException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>, Iterable<E> {

	public class ArrayIterator implements Iterator<E> {

		private int j = 0;
		private boolean removable = false;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return j < size;
		}

		@Override
		public E next() throws NoSuchElementException {
			if (j == size)
				throw new NoSuchElementException("No next element");
			removable = true;
			// TODO Auto-generated method stub
			return data[j++];
		}

		@Override
		public void remove() throws IllegalStateException {
			if (!removable)
				throw new IllegalStateException("nothing to remove");
			ArrayList.this.remove(j - 1);
			j--;
			removable = false;
		}
	}
	
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}

	public static final int CAPACITY = 16;
	private E[] data;
	private int size = 0;

	public ArrayList() {
		this(CAPACITY);
	}

	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		checkIndex(i, size);
		return data[i];
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		checkIndex(i, size+1);
		if (size == data.length)
			resize(2 * data.length);
		for (int j = size - 1; j >= i; j--) { // start by shifting rightmost
			data[j + 1] = data[j];
		}
		data[i] = e;
		size++;
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		checkIndex(i, size);
		E temp = data[i];
		for (int j = i; j < size - 1; j++) { // shift elements to fill hole
			data[j] = data[j + 1];
		}
		data[size - 1] = null;
		size--;
		return temp;
	}

	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n)
			throw new IndexOutOfBoundsException("Illegal index: " + i);
	}

	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}

}
