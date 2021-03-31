/*
 * For the code snippet below, express the time complexity in terms of a polynomial representation. 
 * Simplify your polynomial representation to derive the time complexity in Big Oh notation.
 * Explain your answer by counting the primitives per line that you used in the polynomial expression.
 */

public class CodeToBigO {

	public static int product(int[] arr) { // call the method -> 1
		int n = arr.length; // get the length of the array, initialize n, assign to n -> 3
		int total = 1; // initialize total and assign to it -> 2
		for (int j = 0; j < n; j++) { // 2 [init j and assign to it] + 3(n+1) [3 is from reading j, reading n, then
										// comparing them; n+1 is the number of comparisons. n times till the end, and
										// one more that gives false.] + 3 n [3 is from j=j+1: read j, add 1, assign to
										// j.] -> 2 + 3(n+1) + 3n = 2 + 3n + 3 + 3n = 5 + 6n

			total *= arr[j]; // read j, read j-th value, read total, multiply, assign. all this n times. ->
								// 5n
		}
		return total; // read total, return. -> 2
	}
}
// Polynomial representation:
// T(n) = 1 + 3 + 2 + 5 + 6n + 5n + 2 = 11n + 13
// We can drop the constants, as they make little difference as n increases.
// T(n) is O(n). 