
public class GenericsPair<A, B> {
	A first;
	B second;

	public GenericsPair(A a, B b) { // constructor
		first = a;
		second = b;
	}

	public A getFirst() {
		return first;
	}

	public B getSecond() {
		return second;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericsPair<String, Double> pair;
		pair = new GenericsPair<>("Hello", 1.0); // itt automatikusan kitalalja a tipusokat a beirt ertekek alapjan.
		pair = new GenericsPair<String, Double>("Hello", 1.0); // itt mi adjuk meg a tipust.

		System.out.println(pair.getFirst());
		System.out.println(pair.getSecond());

	}
}
