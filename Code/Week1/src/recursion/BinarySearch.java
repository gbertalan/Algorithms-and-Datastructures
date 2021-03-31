package recursion;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 2, 2, 5, 7, 8 };
		System.out.println(linearSearch(array, 7));
		System.out.println(binarySearch(array, 7, 0, array.length-1));
	}

	public static int linearSearch(int[] array, int number) {
		for (int i = 0; i < array.length; i++) {
			if (number == array[i]) {
				return i;
			}
		}
		return -1;
	}

	// figyelem: csak non-decreasing tombon mukodik. tehat sorted-on.
	public static boolean binarySearch(int[] array, int number, int low, int high) {
		if (low > high) {
			return false;
		} else {
			int mid = (low + high) / 2;
			if (array[mid] == number) {
				return true;
			} else if (array[mid] > number) {
				return binarySearch(array, number, low, mid - 1);
			} else
				return binarySearch(array, number, mid + 1, high);
		}
	}

}
