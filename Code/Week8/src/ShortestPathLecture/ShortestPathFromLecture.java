package ShortestPathLecture;

public class ShortestPathFromLecture {
	public static void main(String[] args) {

	}

	// ++++++++++++Kommentek a videoban levo kodban, segithetnek a megertesben!
	
	public static int[] dijkstra(Graph<Integer, Integer> g, Vertex<Integer> src) {
		int[] res = new int[g.numVertices()];
		boolean[] visited = new boolean[g.numVertices()];
		
		AdaptablePriorityQueue<Integer, Vertex<Integer>> pq = new HeapAdaptablePriorityQueue<>();
		Entry<Integer, Vertex<Integer>>[] pqTokens = new Entry<Integer, Vertex<Integer>>[g.numVertices()];
		
		for(Vertex<Integer> v : g.vertices()) {
			res[v.getElement()] = v == src ? 0 : Integer.MAX_VALUE;
			pqTokens[v] = pq.insert(res[v.getElement()], v);
		}
		
		while(!pq.isEmpty()) {
			Vertex<Integer> u = pq.removeMin().getValue();
			visited[u] = true;
			for(Edge<E> e : g.outgoingEdges(u)) {
				Vertex<Integer> v = g.opposite(u, e);
				if(!visited[v] && res[u] + e.getElement() < res[v]) {
					res[v] = res[u] + e.getElement();
					pq.replaceKey(pqTokens[v], res[v]);
				}
			}
		}
		return res;
	}
}
