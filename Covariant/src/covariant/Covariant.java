package covariant;

class Animal {
	String name;
	
	Animal(String name) {
		this.name = name;
	}
	
	Animal cloneIt() {
		System.out.println("Animal.cloneIt");
		return new Animal(name);
	}
	
	void sayHello() {
		System.out.println("Animal.sayHello: My name is " + name);
	}
}

class Giraffe extends Animal {
	Giraffe(String name) {
		super(name);
	}
	
	@Override
	Giraffe cloneIt() {
		System.out.println("Giraffe.cloneIt");
		return new Giraffe(name);
	}
	
	void sayHello() {
		System.out.println("Giraffe.sayHello: My name is " + name);
	}
}

public class Covariant {

	public static void main(String[] args) {
		Animal a = new Giraffe("Alice");
		Animal g = a.cloneIt();
		
		g.sayHello();
	}

}
