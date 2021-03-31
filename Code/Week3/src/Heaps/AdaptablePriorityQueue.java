package Heaps;

import PriorityQueues.Entry;

public interface AdaptablePriorityQueue<K, V> {
	
	public void remove(Entry<K, V> e);
	
	public void replaceKey(Entry<K,V> entry, K key) throws IllegalArgumentException;
	
	public void replaceValue(Entry<K,V> entry, V value) throws IllegalArgumentException;

}
