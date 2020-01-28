package contraVariance;

class Animal {
	String name;
	
	Animal(String name) {
		this.name = name;
	}
	
	// change to Animal
	void sayHello(Giraffe g) {
		System.out.println("Animal.sayHello: My name is " + name);
	}
}

class Giraffe extends Animal {
	Giraffe(String name) {
		super(name);
	}
	
	@Override
	void sayHello(Animal g) {
		System.out.println("Giraffe.sayHello: My name is " + name);
	}
}

public class ContraVariance {

	public static void main(String[] args) {
		Animal a = new Animal("Generic Animal");
		Animal g = new Giraffe("Alice");
		
		g.sayHello(a);	  // compiler error
		g.sayHello(g);  // also an error
		a.sayHello(g);  // error
		a.sayHello(a);  // error
	}

}
