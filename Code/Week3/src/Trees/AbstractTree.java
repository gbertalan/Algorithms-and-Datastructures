package Trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import PositionalLists.Position;

public abstract class AbstractTree<E> implements Tree<E> {

	public boolean isInternal(Position<E> p) {
		return numChildren(p) > 0;
	}

	public boolean isExternal(Position<E> p) {
		return numChildren(p) == 0;
	}

	public boolean isRoot(Position<E> p) {
		return p == root();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int depth(Position<E> p) {
		if (isRoot(p)) {
			return 0;
		} else {
			return 1 + depth(parent(p));
		}
	}

	public int height(Position<E> p) {
		int h = 0; // base case if p is external
		for (Position<E> c : children(p)) {
			h = Math.max(h, 1 + height(c));
		}
		return h;
	}

	/** Nested class: **/
	private class ElementIterator implements Iterator<E> {

		Iterator<Position<E>> posIterator = positions().iterator();

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return posIterator.hasNext();
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return posIterator.next().getElement();
		}

		@Override
		public void remove() {
			posIterator.remove();
		}
	}

	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	/**
	 * Defining preorder as the default traversal algorithm for the public positions
	 * method of an abstract tree:
	 **/
	public Iterable<Position<E>> positions() {
		return preorder();
	}

	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		snapshot.add(p);
		for (Position<E> c : children(p))
			preorderSubtree(c, snapshot);
	}

	// Egy iteralhato arraylist-et ad vissza, benne az elemekkel, preorder szerint.
	public Iterable<Position<E>> preorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty())
			preorderSubtree(root(), snapshot);
		return snapshot;
	}

	private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		for (Position<E> c : children(p))
			postorderSubtree(c, snapshot);
		snapshot.add(p);
	}

	// Egy iteralhato arraylist-et ad vissza, benne az elemekkel, postorder szerint.
	public Iterable<Position<E>> postorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty())
			postorderSubtree(root(), snapshot);
		return snapshot;
	}

	public Iterable<Position<E>> breadthfirst() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			Queue<Position<E>> fringe = new LinkedQueue<>(); // itt a sajat linkedqueue implementacionkat hasznaljuk, de
																// barmilyen mas queue implementacio is jo volna.
			fringe.enqueue(root());
			while (!fringe.isEmpty()) {
				Position<E> p = fringe.dequeue();
				snapshot.add(p);
				for (Position<E> c : children(p))
					fringe.enqueue(c);
			}
		}
		return snapshot;
	}

}
