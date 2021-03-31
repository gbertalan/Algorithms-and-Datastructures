package PositionalLists;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<String> list = new LinkedPositionalList<String>();
		
		System.out.println(list.addFirst("a"));
		System.out.println(list.addLast("b"));
		System.out.println(list.first());
		System.out.println(list.last());
		
		System.out.println(list.first().getElement());
		System.out.println(list.last().getElement());
	}

}
