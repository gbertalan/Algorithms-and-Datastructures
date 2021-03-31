// Strings in Java are immutable objects. Once created, an instance cannot be modified.

// immutable = unable to be changed.

public class Immutable {

	public static void main(String[] args) {
		System.out.println(repeat1('k', 8));
	}
	
	/**
	 * Uses repeated concatenation to compose a String with n copies of character c.
	 * @param c
	 * @param n
	 * @return
	 */
	public static String repeat1(char c, int n) {
		String answer = "";
		for (int i = 0; i < n; i++) {
			answer += c;
		}
		return answer;
	}
}

// answer += c nem hozzacsatolja a karaktert, hanem szetrombolja az elozot, es egy ujat epit, az uj karakterrel a vegen.
// time proportional to: 1+2+...+n = (n*(n+1))/2.
// -> O(n^2)

// Note: A StringBuilder osztalyt hasznalva csak O(n) lenne.