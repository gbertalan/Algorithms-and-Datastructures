package Deques;

public class Main {

	public static void main(String[] args) {
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		for (int i = 0; i < 10; i++) {
			deque.addFirst(i);
		}
		/*
		deque.addLast(10);
		deque.addLast(11);
		deque.addLast(12);
		
		deque.removeFirst();
		deque.removeLast();
		deque.removeLast();
		*/
		System.out.println("size: " + deque.size());
		
		deque.removeLast();
		System.out.println(deque.first());
		System.out.println(deque.last());
		
		
		/*
		for (int i = 0; i < deque.size(); i++) {
			System.out.println(deque.removeFirst());
		}
		*/
		
		System.out.println("-----");
		
		LinkedDeque<Integer> d = new LinkedDeque<Integer>();
		
		d.addLast(5);
		d.addFirst(3);
		d.addFirst(7);
		System.out.println(d.first());
		d.removeLast();
		System.out.println(d.size());
		
	}
	
}
