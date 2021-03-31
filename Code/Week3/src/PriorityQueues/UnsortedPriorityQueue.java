package PriorityQueues;

import java.util.Comparator;

import Iterators.LinkedPositionalList;
import Iterators.Position;
import Iterators.PositionalList;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

	private LinkedPositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

	/**
	 * Creates an empty priority queue based on the natural ordering of its keys
	 **/
	public UnsortedPriorityQueue() {
		super();
	}

	/** Creates an empty priority queue using the given comparator to order keys **/
	public UnsortedPriorityQueue(Comparator<K> comp) {
		super(comp);
	}

	private Position<Entry<K, V>> findMin() {
		Position<Entry<K, V>> small = list.first();
		for (Position<Entry<K, V>> walk : list.positions())
			if (compare(walk.getElement(), small.getElement()) < 0)
				small = walk;
		return small;
	}

	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K, V> newest = new PQEntry<>(key, value);
		list.addLast(newest);
		return newest;
	}

	public Entry<K, V> min() {
		if (list.isEmpty())
			return null;
		return findMin().getElement();
	}

	public Entry<K, V> removeMin() {
		if (list.isEmpty())
			return null;
		return list.remove(findMin());
	}

	public int size() {
		return list.size();
	}

}
