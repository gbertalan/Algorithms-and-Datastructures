package Iterators;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(17);

		list.add(0, "a");
		list.add(1, "b");
		list.add(2, "c");

		Iterator iter = list.iterator();

		while (iter.hasNext()) {
			System.out.println("Element: " + iter.next());
		}
		for (String s : list) {// az Iterable<E> interface-t kell hasznalnom.
			System.out.println("Foreach: " + s);
		}
		System.out.println(
				"Az ArrayList-hez rosszul irtak meg a kodot a konyvben. Mert hozza lehet adni barmelyik posiciohoz, es no a size is ettol, de ez gondokat okoz.");

		Iterator iter2 = list.iterator(); // Uj iteratort kell csinalnom!
		while (iter2.hasNext()) {
			if (iter2.next() == "b")
				iter2.remove();
		}
		System.out.println("Size after remove: " + list.size());
		
		System.out.println();
		
		LinkedPositionalList<String> pList = new LinkedPositionalList<String>();
		
		pList.addLast("a");
		pList.addLast("b");
		pList.addLast("c");
		
		Iterable pIter = pList.positions(); // positions iterator
		Iterator eIter = pList.iterator(); // element iterator
		
		for(Position<String> p: pList.positions()) {
			System.out.println("Position: "+p.getElement());
		}
		
		while (eIter.hasNext()) {
			System.out.println("Element: " + eIter.next());
		}
		for (String s : pList) {// az Iterable<E> interface-t kell hasznalnom.
			System.out.println("Foreach: " + s);
		}
		System.out.println("Vigyazz! Ez utobbinal ha beteszem az Iterable<E> interface-t, azt nem en irtam meg, lehet, h vizsgan nem lesz megengedett!");
		System.out.println("Ha muszaj nekem megirnom, akkor talan lehet ugy, mint ahogy a masikhoz megirtuk az Iterable tipusu metodust!");

	}

}
