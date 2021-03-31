package Queues;

import LinkedLists.CircularlyLinkedList;

public class LinkedCircularQueue<E> implements CircularQueue<E> {

	private CircularlyLinkedList<E> list = new CircularlyLinkedList<>();

	public LinkedCircularQueue() {
		// TODO Auto-generated constructor stub
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
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		list.addLast(e);
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		return list.first();
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		list.rotate();
	}

}
