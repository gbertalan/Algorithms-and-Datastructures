import java.util.Arrays;

public class SmallAlgorithms {

	public static void main(String[] args) {

		int[] groupA = { 7, 8, 9 };
		int[] groupB = { 7, 8, 9 };
		int[] groupC = { 1, 2, 3 };

		disjoint2(groupA, groupB, groupC);
	}

	// The three-way set disjointness problem: determine if the intersection of the
	// three sets is empty, namely, that there is no element x such that x is in all
	// 3 (A, B, C) sets.

	public static boolean disjoint1(int[] groupA, int[] groupB, int[] groupC) {
		for (int a : groupA) {
//			BigO.lefut("for");
			for (int b : groupB) {
//				BigO.lefut("forfor");
				for (int c : groupC) {
					BigO.lefut("forforfor");
					if ((a == b) && (b == c)) {
						BigO.lefut("forforforif");
						return false;
					}
				}
			}
		}
		return true;
	}
	// disjoint1() is O(n^3).

	// We can improve this: Once inside the body of the loop over B, if selected
	// elements a and b do not match each other, it is a waste of time to iterate
	// through all values of C.

	public static boolean disjoint2(int[] groupA, int[] groupB, int[] groupC) {
		for (int a : groupA) // n (konstansokat elhagyom az egyszeruseg kedveert.)
			for (int b : groupB) { // n^2
				BigO.lefut("forfor");
				if (a == b) // n^2
					for (int c : groupC) { // n^2 (azert csak n^2, mert max n darab (a, b) par letezik, es mindegyikhez vegigmegyunk a groupC n elemen.)
						BigO.lefut("forforfor");
						if (a == c) // n^2
							return false; // 1
					}
			}
		return true; // 1
	}
	// disjoint2 is O(n^2)
	
	// Tehat mi tortenik:
	// az if statement lekorlatozza, hogy a 3-adik for ciklus hanyszor futhat le.
	// csak n-szer futhat le maximum, es a for ciklus onmagaban n operaciot jelent, ezert n^2 lesz a big-O-ja.
	// azert csak n-szer futhat le, mert csak n darab olyan eset lehet, h a == b.

	/////////////////////////////////////////////////////

	// Element uniqueness problem: we are given an array with n elements and asked
	// whether all elements of that collection are distinct from each other.

	public static boolean unique1(int[] data) {
		int n = data.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (data[i] == data[j]) {
					return false;
				}

			}

		}
		return true;

	}
	// Unique1: (n-1) + (n-2) +···+2+1 -> O(n^2)

	// Ezt az elozot ugy tudjuk felgyorsitani, ha eloszor rendezzuk az osszes
	// elemet, es akkor csak egy for ciklus kell, mert csak azt kell megneznunk,
	// hogy az egymas mellett levok kozott vannak-e megegyezoek.
	// Igy:

	public static boolean unique2(int[] data) {
		int n = data.length;
		int[] temp = Arrays.copyOf(data, n);
		Arrays.sort(temp);
		for (int i = 0; i < n - 1; i++) {
			if (temp[i] == temp[i + 1]) {
				return false;
			}
		}
		return true;
	}

}
