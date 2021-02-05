
public class GenericMethod {
	public static void main(String[] args) {

		Integer[] iray = { 1, 2, 3, 4, 5 };
		Character[] cray = { 'b', 'u', 'c', 'k', 'y' };
		String[] anyray = { "g", "a", "r", "r", "y" };

		printMe(iray);
		printMe(cray);
		printMe(anyray);
	}

	private static void printMe(Integer[] iray) {
		for (Integer integer : iray) {
			System.out.printf("%s", integer);
		}
		System.out.println();
	}

	private static void printMe(Character[] iray) {
		for (Character character : iray) {
			System.out.printf("%s", character);
		}
		System.out.println();
	}

	// generic method:
	private static <T> void printMe(T[] anyray) {
		for (T something : anyray) {
			System.out.printf("%s", something);
		}
		System.out.println();
	}

}
