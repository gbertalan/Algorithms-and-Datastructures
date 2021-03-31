package DirectedAcyclicGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import Graphs.Graph;
import Graphs.LinkedPositionalList;
import Graphs.PositionalList;
import Graphs.Vertex;


// ++++++++++ Ez a lecture-ben csak pseudo-code!!!
public class TopologicalSortingLecture {
	public static void main(String[] args) {

	}

/** Returns a list of verticies of directed acyclic graph g in topological order. */
public static <V,E> PositionalList<Vertex<V>> topologicalSort(Graph<V,E> g) {
// list of vertices placed in topological order
List<Vertex<V>> topo = new ArrayList<>( );
// container of vertices that have no remaining constraints
Stack<Vertex<V>> ready = new Stack<>( );
// map keeping track of remaining in-degree for each vertex
Map<Vertex<V>, Integer> inCount = new HashMap<>( );

for (Vertex<V> u : V) {
inCount.put(u, g.inDegree(u)); // initialize with actual in-degree
if (inCount.get(u) == 0) // if u has no incoming edges,
ready.push(u); // it is free of constraints
}
while (!ready.isEmpty( )) {
Vertex<V> u = ready.pop( );
topo.add(u);
for (Edge<E> e : g.outgoingEdges(u)) { // consider all outgoing neighbors of u
Vertex<V> v = g.opposite(u, e);
inCount.put(v, inCount.get(v) - 1); // v has one less constraint without u
if (inCount.get(v) == 0)
ready.push(v);
}
}
return topo;
}

}