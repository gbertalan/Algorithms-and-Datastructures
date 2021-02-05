
public class GenericSingle<T> {
	T valtozo;

	public GenericSingle(T t) { // constructor
		valtozo = t;
	}

	public T getValtozo() {
		return valtozo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericSingle<String> single;
		single = new GenericSingle<>("Hello"); // itt automatikusan kitalalja a tipust a beirt ertek alapjan.
		single = new GenericSingle<String>("Hello"); // itt mi adjuk meg a tipust.

		System.out.println(single.getValtozo());

	}
}
