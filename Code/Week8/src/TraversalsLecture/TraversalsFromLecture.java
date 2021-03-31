package TraversalsLecture;

import TraversalsBook.Edge;
import TraversalsBook.Graph;
import TraversalsBook.LinkedPositionalList;
import TraversalsBook.Map;
import TraversalsBook.PositionalList;
import TraversalsBook.Set;
import TraversalsBook.Vertex;

public class TraversalsFromLecture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static <V, E> void depthFirst(Graph<V, E> g, Vertex<V> u, Set<Vertex<V>> known) {
		visit(u);
		known.add(u); // u has been discovered
		for (Edge<E> e : g.outgoingEdges(u)) { // for every outgoing edge from u
			Vertex<V> v = g.opposite(u, e);
			// check whether v has already been discovered
			if (!known.contains(v)) {

				depthFirst(g, v, known); // recursively explore from v
			}
		}
	}

	public static <V, E> void breadthFirst(Graph<V, E> g, Vertex<V> s) {
		Set<Vertex<V>> known = new Set();

		Queue<Position<E>> q = new Queue();
		q.enqueue(s);
		known.add(s);

		while (!q.isEmpty()) {
			Vertex<V> u = q.dequeue();
			visit(u);
			for (Edge<E> e : g.outgoingEdges(u)) {
				Vertex<V> v = g.opposite(u, e);
				if (!known.contains(v)) {
					q.enqueue(v);
					known.add(v);
				}
			}
		}
	}
	
	public static <V, E> int connectedComponents(Graph<V, E> g) {
		Set<Vertex<V>> known = new Set();
		int num = 0;
		for(Vertex<V> u : g.vertices())
			if(!known.contains(u)) {
				num++;
				depthFirst(g, u, known);
			}
		return num;
	}
	
	/** Path finding using DFS **/
	public static <V, E> boolean pathBetween (Graph<V, E> g, Vertex<V> u1, Vertex<V> u2, Set<Vertex<V>> known) {
		known.add(u1);
		
		if(u1 == u2)
			return true;
		
		for(Edge<E> e : g.outgoingEdges(u1)) {
			Vertex<V> v = g.opposite(u1, e);
			if(!known.contains(v)) {
				if(pathBetween(g, v, u2, known))
					return true;
			}
		}
		return false;
	}
	
}
