package LinkedLists;

import Stacks.LinkedStack;

public class Main {

	public static void main(String[] args) {
		CircularlyLinkedList<Integer> lista = new CircularlyLinkedList<Integer>();
		lista.addLast(19);
		lista.addLast(87);

		System.out.println("CircularlyLinkedList: " + lista.first());

		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		stack.push(3);
		stack.push(5);
		System.out.println("LinkedStack " + stack.pop());
		System.out.println("LinkedStack " + stack.pop());
	}

}
