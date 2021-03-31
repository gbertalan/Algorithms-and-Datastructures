package recursion;

import java.util.Arrays;

public class RecursiveAlgsToKnowByHeart {

	public static void main(String[] args) {

		// throw new IllegalArgumentException, ha szukseges.

		int[] array = { 5, 3, 6, 2, 9, 8, 4, 2 };

		int[] sorted = array.clone();
		Arrays.sort(sorted);

		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(sorted));

		System.out.println(binarySearch(array, 8, 0, sorted.length));
		System.out.println(binarySearchIndex(sorted, 8, 0, sorted.length));
		System.out.println(linearSum(sorted, sorted.length));

		reverseArray(array, 0, 5);
		System.out.println(Arrays.toString(array));
		System.out.println(power1(2, 4));
		System.out.println(power2(2, 4));
		System.out.println(binarySum(sorted, 0, sorted.length - 1));

		drawRuler(2, 5);
		System.out.println("\n"+ "Fibonacci input: 7");
		System.out.println(fibonacciBad(7));
		System.out.println(fibonacciGood(7)[0]);
	}

	/**
	 * binarySearch: rendezett tombben keresd meg a targetet O(logn) time-mal
	 * (rendezes nelkuli ido), es return-olj true-t, ha benne van.
	 * 
	 * @param array
	 * @param target
	 * @param min
	 * @param max
	 * @return
	 */
	private static boolean binarySearch(int[] array, int target, int min, int max) {
		// array is sorted!
		if (max < min) {
			return false;
		} else {

			int mid = (max + min) / 2;
			if (target == array[mid]) {
				return true;
			} else if (target < array[mid]) {
				return binarySearch(array, target, min, mid - 1);
			} else {
				return binarySearch(array, target, mid + 1, max);
			}
		}
	}

	/**
	 * Ua, mint elozo, de az elem indexet add vissza (A SORTED array-ben levo
	 * indexet.). Vagy ha nincs benne, akkor -1 -et.
	 * 
	 * @param array
	 * @param target
	 * @param min
	 * @param max
	 * @return
	 */
	private static int binarySearchIndex(int[] array, int target, int min, int max) {
		// array is sorted!
		if (max < min) {
			return -1;
		} else {

			int mid = (max + min) / 2;
			if (target == array[mid]) {
				return mid;
			} else if (target < array[mid]) {
				return binarySearchIndex(array, target, min, mid - 1);
			} else {
				return binarySearchIndex(array, target, mid + 1, max);
			}
		}
	}

	/**
	 * Add ossze egy array elemeit, rekurzivan.
	 */
	private static int linearSum(int[] array, int end) {
		if (end == 0) {
			return 0;
		} else {
			return linearSum(array, end - 1) + array[end - 1];
		}
	}

	/**
	 * Megforditja egy subarray-nek az elemeit, low-tol high-ig (inkluziv).
	 */
	public static void reverseArray(int[] array, int low, int high) {
		if (high > low) {// legalabb ket elemnek kell lennie a subarray-ben a cserehez, azert nem 0,
							// hanem 1.
			int temp = array[low];
			array[low] = array[high];
			array[high] = temp;
			reverseArray(array, ++low, --high);
		}
	}

	/**
	 * Hatvanyozas1 O(n)
	 */
	public static int power1(int a, int n) {
		if (n == 0) {
			return 1;
		} else {
			return a * power1(a, n - 1);
		}
	}

	/**
	 * Hatvanyozas2 O(logn)
	 */
	public static int power2(int a, int n) {
		if (n == 0) {
			return 1;
		} else {
			if (n % 2 == 1) {
				int result = power2(a, n / 2);
				result = result * result * a;
				return result;
			} else {
				int result = power2(a, n / 2);
				result = result * result;
				return result;
			}
		}
	}

	/**
	 * Binary recursion-t alkalmazva adjuk ossze most a tomb szamait. O(n) time
	 * O(logn) space
	 */
	public static int binarySum(int[] array, int min, int max) {
		if (max < min) { // zero elements in subarray
			return 0;
		} else if (min == max) { // one element in subarray
			return array[min];
		} else {
			int mid = (min + max) / 2;
			return binarySum(array, min, mid) + binarySum(array, mid + 1, max);
		}
	}

	/**
	 * English ruler. For given number of inches and majortick length.
	 */

	public static void drawRuler(int nInches, int majorLength) {
		drawLine(majorLength, 0);
		for (int i = 1; i <= nInches; i++) {
			drawInterval(majorLength - 1);
			drawLine(majorLength, i);
		}
	}

	private static void drawInterval(int centralLength) {
		// TODO Auto-generated method stub
		if (centralLength >= 1) {
			drawInterval(centralLength - 1); // recursively draw top interval
			drawLine(centralLength, -1);
			drawInterval(centralLength - 1); // recursively draw bottom interval
		}

	}

	private static void drawLine(int tickLength, int tickLabel) {
		for (int i = 0; i < tickLength; i++) {
			System.out.print("-");
		}
		if (tickLabel >= 0) {
			System.out.print(" " + tickLabel);
		}
		System.out.println();
	}

	/**
	 * Fibonacci exponencialis idovel
	 * 
	 * @param n
	 * @return
	 */
	public static int fibonacciBad(int n) {
		lefut();
		if (n <= 1) {
			return n;
		} else {
			return fibonacciBad(n - 2) + fibonacciBad(n - 1);
		}
	}

	/**
	 * Fibonacci O(n) idovel
	 */
	public static int[] fibonacciGood(int n) {
		lefut();
		if (n <= 1) {
			int[] answer = { n, 0 };
			return answer;
		} else {
			int[] temp = fibonacciGood(n - 1); // returns {F(n-1), F(n-2)}
			int[] answer = { temp[0] + temp[1], temp[0] }; // we want {F(n), F(n-1)}
			return answer;
		}
	}

	/**
	 * non-recursive Binary Search. A tail-recursive metodusokat elvileg konnyen at
	 * tudjuk forditani iterativva.
	 */

	public static boolean binarySearchIterative(int[] array, int target) {
		int min = 0;
		int max = array.length - 1;
		while (min <= max) {
			int mid = (min + max) / 2;
			if (target == array[mid])
				return true;
			else if (target < array[mid])
				max = mid - 1;
			else
				min = mid + 1;
		}
		return false;
	}

	/**
	 * A kovetkezi kis metodussal tudom a lefutasok szamat megsaccolni, az
	 * megmutathatja a time-ot (de nem a space-t).
	 */
	public static void lefut() {
		System.out.print("X");
	}

}
