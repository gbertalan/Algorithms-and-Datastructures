package Trees;

import java.util.Iterator;

import PositionalLists.Position;

public interface Tree<E> extends Iterable<E> {

	Position<E> root(); // Returns the position of the root of the tree (or null if empty)

	Position<E> parent(Position<E> p) throws IllegalArgumentException;

	Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

	int numChildren(Position<E> p) throws IllegalArgumentException;

	boolean isInternal(Position<E> p) throws IllegalArgumentException;

	boolean isExternal(Position<E> p) throws IllegalArgumentException;

	boolean isRoot(Position<E> p) throws IllegalArgumentException;

	int size();

	boolean isEmpty();

	Iterator<E> iterator();

	Iterable<Position<E>> positions();
}
