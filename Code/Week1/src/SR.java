import java.util.ArrayList;
import java.util.List;

public class SR {

	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {

		list.add(51);
		list.add(7);
		list.add(11);
		list.add(25);
		list.add(1);
		list.add(80);

		System.out.println(split(list).toString());
		System.out.println(SRDifference1(list));
		System.out.println(SRDifference2(list));
		System.out.println(SRDifference3(list));

	}

	public static List split(List<Integer> list) {

		List<Integer> lower = new ArrayList<Integer>(); // 1 (assignment)
		List<Integer> upper = new ArrayList<Integer>(); // 1 (assignment)

		for (int i = 0; i < list.size(); i++) { // 1 + (n+1) + 2n (assignment + evaluations + n addition and n
												// assignment)
			if (list.get(i) < 50) { // 2n (get(i) is one, evaluation, but both happens n times because they are in a
									// loop)
				lower.add(list.get(i)); // n (adding i is 1 operation, but n times because it is in a loop)
			} else {
				upper.add(list.get(i)); // n (adding i is 1 operation, but n times because it is in a loop)
			}
		}

		return lower;

	} // Total: 1+1+1+(n+1)+2n+2n+n+n = 4+7n.

	/*
	 * 
	 * Primitive operations:
	 * 
	 */

//	 * • Assigning a value to a variable 
//	 * • Following an object reference 
//	 * • Performing an arithmetic operation (for example, adding two numbers) 
//	 * • Comparing two numbers 
//	 * • Accessing a single element of an array by index 
//	 * • Calling a method 
//	 * • Returning from a method 
//	 * • etc.

	public static int SRDifference1(List<Integer> list) {
		int diff = 0;// 1

		for (int i = 0; i < list.size(); i++) { // 1 + (n+1) + 2n
			for (int j = 0; j < list.size(); j++) { // (1 + (n+1) + 2n) * n

				int currentDiff = Math.abs(list.get(i) - list.get(j)); // 5n^2
				if (currentDiff > diff) { // 3n^2
					diff = currentDiff; // 2n^2
				}

			}
		}

		return diff; // 1

	} // sum: 2 + (n+1) + 2n + (1 + (n+1) + 2n) * n + 10n^2 =
		// 4n + 3 + 3n^2 + + 10n = 14n^2 + 15n + 2

	public static int SRDifference2(List<Integer> list) {

		int diff = 0;

		for (int i = 0; i < list.size(); i++) {
			for (int j = i; j < list.size(); j++) {

				int currentDiff = Math.abs(list.get(i) - list.get(j));
				if (currentDiff > diff) {
					diff = currentDiff;
				}

			}
		}

		return diff;

	}

	public static int SRDifference3(List<Integer> list) {

		int min = list.get(0);
		int max = list.get(0);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < min) {
				min = list.get(i);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}
		}

		return max - min;

	}
	
	/**
	 * Algorithm that splits a sorted list into two lists in O(logn) time.
	 * Ugy osztjuk el 2 reszre, h lesz egy amiben az 50-nel kevesebb pontok vannak,
	 * es lesz egy, amiben a legalabb 50-et elertek vannak.
	 * @param list
	 */
	public static void splitNew(List<Integer> list) {
		
	}

}
