package binding2;

// dynamic  binding example

class Animal {
	void eat() {
		System.out.println("Animal is eating...");
	}
}

public class Dog extends Animal {
	void eat() {
		System.out.println("Dog is eating...");		
	}
	
	public static void main(String[] args) {
		Animal d = new Dog();
		d.eat();
	}

}
