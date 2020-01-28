package animalList;

import java.util.ArrayList;
import java.util.List;

class Animal { }
class Cat extends Animal { }
class Mouse extends Animal { }

public class AnimalListDemo {

	public static void main(String[] args) {
		ArrayList<Mouse> mice = new ArrayList<Mouse>();
		mice.add(new Mouse());   // add some mice
		mice.add(new Mouse());
		
		List<? extends Animal> miceList = mice;
		
		// why isn't this legal?
		// miceList.add(new Cat());
				
		List<? super  Animal> animalList = new ArrayList<Animal>();
		animalList.add(new Animal());
		animalList.add(new Cat());
		// animalList.add(new Object()); // can't add this
		

		// Why isn't this legal?
		// Animal a = animalList.get(0);  
		
		Object o = animalList.get(0);
		
		animalList = new ArrayList<Object>(); // this is legal
	}

}
