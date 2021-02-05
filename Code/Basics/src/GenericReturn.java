
// Olyan metodust irunk, ami egy generic (tehat mondjuk T) tipusu dolgot fog visszaadni.

public class GenericReturn {
	public static void main(String[] args) {
		System.out.println(maximum(23, 42, 1));
		System.out.println(maximum("alma", "korte", "eper"));
	}
	
	public static <T extends Comparable<T>> T maximum(T a, T b, T c){
		T max = a;
		
		if(b.compareTo(a) > 0) {
			max = b;
		}
		if(c.compareTo(max) > 0) {
			max = c;
		}
		
		return max;
	}
	
}
