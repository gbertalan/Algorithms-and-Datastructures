package InsertionSort;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] array = { 5, 3, 6, 2, 9, 8, 4, 2 };
		char[] charArray = { 'h', 'e', 'l', 'l', 'o' };
		insertionSortBook(charArray);
		System.out.println(Arrays.toString(charArray));
		insertionSortUdemy(array);
		System.out.println(Arrays.toString(array));

	}

	public static void insertionSortBook(char[] array) {

		for (int i = 1; i < array.length; i++) {
			char temp = array[i];
			int j = i;
			while (j > 0 && array[j - 1] > temp) {
				array[j] = array[j - 1];
				--j;
			}
			array[j] = temp;
		}
	}

	public static void insertionSortUdemy(int[] array) {

		for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {

			int newElement = array[firstUnsortedIndex];

			int i;
			for (i = firstUnsortedIndex; (i > 0) && (array[i-1]>newElement); i--) {
				array[i] = array[i-1];
			}
			
			array[i] = newElement;
		}
	}
}
