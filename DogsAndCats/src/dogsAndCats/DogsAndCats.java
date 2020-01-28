package dogsAndCats;

import java.util.ArrayList;
import java.util.List;

class Animal {
}

class Dog extends Animal {
	
}

class Cat extends Animal {
	
}

public class DogsAndCats {

	public static void main(String[] args) {
		// Illegal code - because otherwise life would be Bad
		List<Dog> dogs = new List<Dog>();  // can't instantiate List of Dogs List is an interface
		// List<Dog> dogs = new ArrayList<Dog>();  // we really have to do something like this
		List<Animal> animals = dogs; // Trouble ahead, List<Dog> is not really a subtype of List<Animal>
		animals.add(new Cat());
		Dog dog = dogs.get(0); // This should be safe, right?

	}

}
