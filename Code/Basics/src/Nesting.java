
class Outside {
	int a = 2;

	class Inside {
		int b = 12;
	}
	
	static class InsideTwo {
		int c =33;
	}
}

public class Nesting {
	public static void main(String[] args) {
		Outside os = new Outside();
		Outside.Inside is = os.new Inside();
		
		System.out.println(os.a);
		System.out.println(is.b);
		
		Outside.InsideTwo isTwo = new Outside.InsideTwo();
		System.out.println(isTwo.c);
		
	}
}
