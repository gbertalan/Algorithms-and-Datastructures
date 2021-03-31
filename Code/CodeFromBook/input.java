 /∗∗ A Union-Find structure for maintaining disjoint sets. ∗/
2 public class Partition<E> {
3 //--------------- nested Locator class -------------
4 private class Locator<E> implements Position<E> {
5 public E element;
6 public int size;
7 public Locator<E> parent;
8 public Locator(E elem) {
9 element = elem;
10 size = 1;
11 parent = this; // convention for a cluster leader
12 }
13 public E getElement( ) { return element; }
14 } //--------- end of nested Locator class ---------
15 /∗∗ Makes a new cluster containing element e and returns its position. ∗/
16 public Position<E> makeCluster(E e) {
17 return new Locator<E>(e);
18 }
19 /∗∗
20 ∗ Finds the cluster containing the element identified by Position p
21 ∗ and returns the Position of the cluster's leader.
22 ∗/
23 public Position<E> find(Position<E> p) {
24 Locator<E> loc = validate(p);
25 if (loc.parent != loc)
26 loc.parent = (Locator<E>) find(loc.parent); // overwrite parent after recursion
27 return loc.parent;
28 }
29 /∗∗ Merges the clusters containing elements with positions p and q (if distinct). ∗/
30 public void union(Position<E> p, Position<E> q) {
31 Locator<E> a = (Locator<E>) find(p);
32 Locator<E> b = (Locator<E>) find(q);
33 if (a != b)
34 if (a.size > b.size) {
35 b.parent = a;
36 a.size += b.size;
37 } else {
38 a.parent = b;
39 b.size += a.size;
40 }
41 }
42 }