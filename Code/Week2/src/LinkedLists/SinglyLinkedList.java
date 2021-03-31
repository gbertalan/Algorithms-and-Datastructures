package LinkedLists;

public class SinglyLinkedList<E> implements Cloneable {

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

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	public SinglyLinkedList() {

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
			return head.getElement();
	}

	public E last() {
		if (isEmpty())
			return null;
		else
			return tail.getElement();
	}

	public void addFist(E e) {
		head = new Node<>(e, head);
		if (isEmpty()) {
			tail = head;
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty()) {
			head = newest;
		} else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}

	public E removeFirst() { // removes and returns first element
		if (isEmpty()) {
			return null;
		}
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0)
			tail = null;
		return answer;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		SinglyLinkedList other = (SinglyLinkedList) o;
		if (size != other.size)
			return false;
		Node walkA = head;
		Node walkB = other.head;
		while (walkA != null) {
			if (!walkA.getElement().equals(walkB.getElement()))
				return false;
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true;
	}

	public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
		SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
		if (size > 0) {
			other.head = new Node<>(head.getElement(), null);
			Node<E> walk = head.getNext();
			Node<E> otherTail = other.head;
			while (walk != null) {
				Node<E> newest = new Node<>(walk.getElement(), null);
				otherTail.setNext(newest);
				otherTail = newest;
				walk = walk.getNext();
			}
		}
		return other;
	}

	/** For testing purposes **/
	public String printList() {

		String text = "[Elements:";
		Node walk = head;
		int size = 0;
		while (walk != null) {
			text = text + " " + walk.getElement() + ",";
			walk = walk.getNext();
			++size;
		}
		if (text != null) {
			text = text.substring(0, text.length() - 1);
		}
		text = text + "   Size: " + size + " ]";
		return text;
	}

}
