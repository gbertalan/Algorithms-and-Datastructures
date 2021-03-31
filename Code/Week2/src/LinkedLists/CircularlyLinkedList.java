package LinkedLists;

// We no longer explicitly maintain the head reference. 
// So long as we maintain a reference to the tail, we can locate the head as tail.getNext( ) .

// Rotate method: the tail will point to the first node.
// Rotate method mas szavakkal: moves the first node to the end of the list. 

public class CircularlyLinkedList<E> {

	public static class Node<E> {
		private E element;
		private Node<E> next;

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	private Node<E> tail = null;
	private int size = 0;

	public CircularlyLinkedList() {

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	public E first() {
		if (isEmpty())
			return null;
		else
			return tail.getNext().getElement();
	}

	public E last() {
		if (isEmpty())
			return null;
		else
			return tail.getElement();
	}

	public void rotate() {
		if (tail != null)
			tail = tail.getNext();
	}

	public void addFist(E e) {
		if (isEmpty()) {
			tail = new Node<>(e, null);
			tail.setNext(tail);
		} else {
			Node<E> newest = new Node<>(e, tail.getNext());
			tail.setNext(newest);
		}
		size++;
	}

	public void addLast(E e) {
		addFist(e);
		tail = tail.getNext();
	}

	public E removeFirst() { // removes and returns first element
		if (isEmpty()) {
			return null;
		}
		Node<E> head = tail.getNext();
		if (head == tail) {
			tail = null;
		} else {
			tail.setNext(head.getNext());
		}
		size--;
		return head.getElement();
	}

}
