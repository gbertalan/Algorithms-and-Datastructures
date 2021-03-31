package Deques;

import LinkedLists.DoublyLinkedList;

public class LinkedDeque<E> implements Deque<E> {
	
	private DoublyLinkedList<E> list = new DoublyLinkedList<>();

	public LinkedDeque() {
		
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		return list.first();
	}

	@Override
	public E last() {
		// TODO Auto-generated method stub
		return list.last();
	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		list.addFirst(e);
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		list.addLast(e);
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return list.removeLast();
	}

}
