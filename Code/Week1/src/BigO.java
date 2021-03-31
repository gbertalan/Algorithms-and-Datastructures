
public class BigO {

	static int[] array = {2, 4, 6, 8, 7, 5, 3}; // n = 7
	
	static int counter = 1;
	
	public static void main(String[] args) {
		System.out.println(getMax(array));
	}
	
	public static int getMax(int[] array) {
		int max = array[0];
		BigO.lefut("konstans");
		for (int i = 0; i < array.length; i++) {
			BigO.lefut("for");
			if(array[i] > max) {
				max = array[i];
			}
		}
		
		return max;
		
	}
	
	public static void lefut(String text) {
		System.out.println(text + ": " + counter);
		++counter;
	}
}
