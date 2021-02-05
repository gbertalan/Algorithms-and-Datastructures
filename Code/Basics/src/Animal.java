
public abstract class Animal implements MyInterface{

	private String name;

	public Animal(String name) {
		this.name = name;
	}

	public void animalSound() {
		System.out.println("The animal makes a sound");
	}
	
	public abstract void abstraction();
}
