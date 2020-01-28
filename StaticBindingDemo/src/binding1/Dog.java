package binding1;

// static binding example

class Animal {
	static void eat() {
		System.out.println("Animal is eating...");
	}
}

public class Dog extends Animal {

	static void eat() {
		System.out.println("Dog is eating....");
	}

	public static void main(String args[]) {
		Animal d1 = new Dog();
		d1.eat();  // accesses Animal.eat(), uses compile time binding
	}
}
