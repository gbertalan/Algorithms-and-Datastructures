package Trees;

import java.util.ArrayList;
import java.util.List;

import PositionalLists.Position;
import Trees.LinkedBinaryTree.Node;

public class LinkedGeneralTree<E> extends AbstractTree<E>{
	
	
	protected static class Node<E> implements Position<E> {
		
	private E element;
	private Node<E> parent;
	private ArrayList<Node<E>> children;
	
	public Node(E e, Node<E> p, ArrayList<Node<E>> cn) {
		element = e;
		parent = p;
		children = cn;
	}
	
	public E getElement() {
		return element;
	}
	
	public Node<E> getParent() {
		return parent;
	}

	public ArrayList<Node<E>> getChildren() {
		return children;
	}

	public void setElement(E e) {
		element = e;
	}

	public void setParent(Node<E> parentNode) {
		parent = parentNode;
	}

	public void setChildren(ArrayList<Node<E>> cn) {
		children = cn;
	}
	
	}
	
	
	protected Node<E> createNode(E e, Node<E> parent, ArrayList<Node<E>> cn) {
		return new Node<E>(e, parent, cn);
	}
	
	protected Node<E> root = null;
	private int size = 0;

	public LinkedGeneralTree() {

	}

	protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("Not valid position type");
		Node<E> node = (Node<E>) p;
		if (node.getParent() == node)
			throw new IllegalArgumentException("p is no longer in the tree");
		return node;
	}
	

	@Override
	public Position<E> root() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return node.getParent();
	}

	@Override
	public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		
		List<Position<E>> snapshot = new ArrayList<>();
		for (int i = 0; i < node.getChildren().size(); i++) {
			snapshot.add(node.getChildren().get(i));
		}

		return snapshot;
	}

	@Override
	public int numChildren(Position<E> p) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return node.children.size();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public Position<E> addRoot(E e) throws IllegalStateException {
		if (!isEmpty())
			throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, new ArrayList<Node<E>>());
		size = 1;
		return root;
	}
	
	public Position<E> addChild(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		
		Node<E> child = createNode(e, parent, new ArrayList<Node<E>>());
		
		parent.getChildren().add(child);
		
		size++;
		return child;
	}

}
