
public class BasicsCollection {

	
	// primitive types:
	boolean flag = true;
	boolean verbose, debug; // two variables declared, but not yet initialized
	char grade = 'A';
	byte b = 12;
	short s = 24;
	int i, j, k = 257; // three variables declared; only k initialized
	long l = 890L; // note the use of ”L” here
	float pi = 3.1416F; // note the use of ”F” here
	double e = 2.71828, a = 6.022e23; // both variables are initialized

	
	// abstract:
	// A method of a class may be declared as abstract, in which case its signature
	// is provided but without an implementation of the method body.
	// (Inheritence-nel fontos.)
	// A class with one or more abstract methods must also be formally declared as
	// abstract, because it is essentially incomplete.

	
	// final:
	// final static short s = 24;

	
	// Wrapper type (autoboxing; unboxing):
	// Integer <-> int

	
	// Enum types:
//	public enum Day {
//		MON, TUE, WED, THU, FRI, SAT, SUN
//	};
//
//	Day today;
//	today = Day.TUE;

	
	// Switch:

//	switch (d) { 
//		case MON: 
//			System.out.println("This is tough."); 
//			break; 
//		case TUE:
//			System.out.println("This is getting better."); 
//			break; 
//		case WED:
//			System.out.println("Half way there."); 
//			break; 
//		case THU:
//			System.out.println("I can see the light."); 
//			break; 
//		case FRI:
//			System.out.println("Now we are talking."); 
//			break; 
//		default:
//			System.out.println("Day off!"); }

	
	// The continue; statement:
	// Kihagyja a ciklusban levoket, de nem a ciklus vegetol folytatja, hanem
	// visszameny a ciklus elejere.

	
	// ADT: abstract data type -> interface

	
	// Encapsulation: private / public / etc.

	// private:
	// csak az adott class latja, a subclass-ok nem.
	
	// protected:
	// az adott class, a subclass-ai es a package latja, a vilag nem.

	
	// Inheritence:
	// [A tobbi fajlban.]

	
	// Polymorphism:
	// Animal macska = new Cat("Mimi");

	
	// Abstraction:
	// public abstract void abstraction();

	
	// Exception:
	/*
	 * 
	 * if (n < 0) { throw new IllegalArgumentException("That's not positive!"); }
	 * 
	 * OR
	 * 
	 * public static int parseInt(String s) throws NumberFormatException{ return 0;
	 * }
	 * 
	 */

	
	// Equals:

//	public boolean equals(Person other) { // from Person interface 
//		if (!(other instanceof Student)) return false; // cannot possibly be equal 
//		Student s = (Student) other; // explicit cast now safe 
//		return id.equals(s.id); // compare IDs 
//	}

	
	// Composition Design Pattern:
	// Ket erteket akarunk return-olni, ezt ugy oldjuk meg, hogy csinalunk egy
	// class-ot, ami ezt a ket erteket tarolni fogja, es annak a class-nak egy
	// instance-et return-oljuk.

	
	// Generics:
	// GenericSingle.java
	// GenericsPair.java
	// GenericMethod.java
	// GenericReturn.java
	// generics and arrays: ez a konyvben van, nem irom (meg) ki, mert nem teljesen
	// tiszta a kep a fejemben rola.

	
	// Nested Classes:
	// Nesting.java


}
