package Applications;

import PositionalLists.Position;
import Trees.LinkedBinaryTree;

public class LinkedBTreeUsage {

	public static void main(String[] args) {
		
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		
		
		Position<String> root = tree.addRoot("Book");
		Position<String> bal1 = tree.addLeft(root, "bal1");
		Position<String> jobb1 = tree.addRight(root, "jobb1");
		
		System.out.println(tree.depth(bal1));
		
		System.out.println(tree.size());
		
	}
	
}
