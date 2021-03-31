package recursion;

import java.util.Arrays;

public class SummingElements {

	public static void main(String[] args) {
		
		int[] array = {10, 2, 3, 5};
		System.out.println(sumSajat(array));
		System.out.println(sumBook(array, array.length));
	}

	public static int sumSajat(int[] array) {

		if (array.length == 1) {
			return array[0];
		} else {
			return array[0] + sumSajat(Arrays.copyOfRange(array, 1, array.length));
		}
	}
	
	public static int sumBook(int[] array, int n) {

		if (n==0) {
			return 0;
		} else {
			return sumBook(array, n-1) + array[n-1];
		}
	}
	
}
