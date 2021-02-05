
public class Cat extends Animal implements MyInterface{

	public Cat(String name) {
		super(name);
	}

	public void animalSound() {
		System.out.println("The cat says: meow");
	}

	@Override
	public void abstraction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String interfaceMethod() {
		// TODO Auto-generated method stub
		return null;
	}
}
