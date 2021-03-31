package josephusHotPotato;

import Queues.LinkedCircularQueue;

public class Josephus<E> {
	
	public static void main(String[] args) {
		String[ ] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
		String[ ] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
		String[ ] a3 = {"Mike", "Roberto"};
		System.out.println("First winner is " + josephus(buildQueue(a1), 3));
		System.out.println("Second winner is " + josephus(buildQueue(a2), 10));
		System.out.println("Third winner is " + josephus(buildQueue(a3), 7));
	}
	
	public static <E> LinkedCircularQueue<E> buildQueue(E[] list) {
		
		LinkedCircularQueue<E> queue = new LinkedCircularQueue<E>();
		
		for (int i = 0; i < list.length; i++) {
			queue.enqueue(list[i]);
		}
		
		return queue;
	}
	
	public static <E> E josephus(LinkedCircularQueue<E> queue, int k) {
		if (queue.isEmpty())
			return null;
		
		while(queue.size()>1) {
			for (int i = 0; i < k-1; i++) {
				queue.rotate();
			}
			E element = queue.dequeue();
			System.out.println(element + " is out");
		}
		
		return queue.dequeue();
		
	}
	

}
