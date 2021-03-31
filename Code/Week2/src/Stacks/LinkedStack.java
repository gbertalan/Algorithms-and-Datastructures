package Stacks;

import LinkedLists.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {
	
	SinglyLinkedList<E> list = new SinglyLinkedList<>();
	
	public LinkedStack() {
		
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
	public void push(E e) {
		// TODO Auto-generated method stub
		list.addFist(e);
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		return list.first();
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}
	
	

}
