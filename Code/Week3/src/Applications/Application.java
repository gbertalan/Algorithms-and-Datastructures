package Applications;

import java.util.ArrayList;

import PositionalLists.Position;
import Trees.LinkedGeneralTree;
import Trees.Tree;

public class Application {

	public static void main(String[] args) {
		tableOfContents();
		
	}

	public static void tableOfContents() {
		LinkedGeneralTree<String> tree = new LinkedGeneralTree<String>();

		System.out.println("** Kilistazas preorder szerint, O(n) **");
		Position<String> root = tree.addRoot("Book");

		Position<String> elso = tree.addChild(root, "Elso fejezet");

		Position<String> masodik = tree.addChild(root, "Masodik fejezet");
		Position<String> harmadik = tree.addChild(root, "Harmadik fejezet");
		tree.addChild(elso, "Getting started");
		tree.addChild(elso, "Classes and objects");

		tree.addChild(masodik, "Inheritence");

		tree.addChild(harmadik, "Singly Linked Lists");
		tree.addChild(harmadik, "Circularly Linked Lists");
		tree.addChild(harmadik, "Doubly Linked Lists");

		for (Position<String> p : tree.preorder())
			System.out.println(p.getElement());

		System.out.println();

		System.out.println("** Kilistazas space-ekkel, de O(n^2) **");

		for (Position<String> p : tree.preorder())
			System.out.println(spaces(2 * tree.depth(p)) + p.getElement());

		System.out.println();

		System.out.println("** Kilistazas space-ekkel, rekurzioval, O(n) **");

		printPreorderIndent(tree, root, 0);

		System.out.println();

		System.out.println("** Labelled: **");

		printPreorderLabeled(tree, root, new ArrayList<Integer>());
		
		System.out.println();

		System.out.println("** Parenthesize(talan postorder): **");
		
		parenthesize(tree, root);
		
		System.out.println();
		System.out.println();

		System.out.println("** (inorder, binaryTree-vel): **");
	}

	private static <E> void parenthesize(Tree<E> tree, Position<E> p) {
		// TODO Auto-generated method stub
		System.out.print(p.getElement());
		if(tree.isInternal(p)) {
			boolean firstTime = true;
			for(Position<E> c : tree.children(p)) {
				System.out.print((firstTime ? " (":", "));
				firstTime = false;
				parenthesize(tree, c);
			}
			System.out.print(")");
		}
	}

	public static StringBuilder spaces(int number) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < number; i++) {
			sb.append(" ");
		}
		return sb;
	}

	private static <E> void printPreorderIndent(Tree<E> tree, Position<E> p, int d) {
		System.out.println(spaces(2 * d) + (String)p.getElement());
		for (Position<E> c : tree.children(p))
			printPreorderIndent(tree, c, d + 1);
	}

	public static <E> void printPreorderLabeled(Tree<E> tree, Position<E> p, ArrayList<Integer> path) {
		int d = path.size(); // depth equals the length of the path
		System.out.print(spaces(2 * d)); // print indentation(spaces)
		for (int i = 0; i < d; i++) {
			System.out.print(path.get(i) + (i == d - 1 ? " " : "."));
		}
		System.out.println(p.getElement());
		path.add(1); // add path entry for first child
		for (Position<E> c : tree.children(p)) {
			printPreorderLabeled(tree, c, path);
			path.set(d, 1 + path.get(d)); // increment last entry of path
		}
		path.remove(d); // restore path to its incoming state
	}

}
