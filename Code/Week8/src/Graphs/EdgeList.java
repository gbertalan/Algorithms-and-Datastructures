package Graphs;

public class EdgeList<V, E> implements Graph<V, E> {

	class InnerVertex<V> implements Vertex<V> {
		private V elem;
		private Position<InnerVertex<V>> pos;

		@Override
		public V getElement() {
			// TODO Auto-generated method stub
			return elem;
		}
	}

	class InnerEdge<V, E> implements Edge<E> {
		private E elem;
		private InnerVertex<V> begin;
		private InnerVertex<V> end;
		private Position<InnerEdge<V, E>> pos;
		@Override
		public E getElement() {
			// TODO Auto-generated method stub
			return elem;
		}
	}
	
	private LinkedPositionalList<InnerVertex<V>> vertices;
	private LinkedPositionalList<InnerEdge<V, E>> edges;
	
	// az alabbiak nincsenek meg megirva!
	@Override
	public int numVertices() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Iterable<Vertex<V>> vertices() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int numEdges() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Iterable<Edge<E>> edges() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterable<Edge<E>> incomingEdges(Vertex<V> v) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Vertex<V> insertVertex(V x) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E x) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void removeVertex(Vertex<V> v) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeEdge(Edge<E> e) {
		// TODO Auto-generated method stub
		
	} 

}
