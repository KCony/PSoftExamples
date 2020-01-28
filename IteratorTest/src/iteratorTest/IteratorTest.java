package iteratorTest;

import java.util.ArrayList;
import java.util.Iterator;

class Pet {
	private String name;
	private int weight;
	
	public Pet(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	String getName() {
		return name;
	}
	
	int getWeight() {
		return weight;
	}
	
	void setWeight(int weight) {
		this.weight = weight;
	}
}

class PetContainer {
	private ArrayList<Pet> pets = new ArrayList<Pet>();
	
	void add(Pet p) {
		pets.add(p);
	}
	
	Iterator<Pet> iterator() { 
		return pets.iterator();
	}
}

public class IteratorTest {

	public static void main(String[] args) {
		PetContainer p = new PetContainer();
		
		p.add(new Pet("cat", 10));
		p.add(new Pet("dog", 30));
		p.add(new Pet("elephant", 1500));
		
		Iterator<Pet> it = p.iterator();
		while(it.hasNext()) {
			Pet px = it.next();
			System.out.println(px.getName() + " " + px.getWeight());
		}
		
		it = p.iterator();
		int count = 0;
		while(it.hasNext()) {
			Pet px = it.next();
			if(count == 1) {
				px.setWeight(20);
			}
			count++;
		}
		
		it = p.iterator();
		while(it.hasNext()) {
			Pet px = it.next();
			System.out.println(px.getName() + " " + px.getWeight());
		}

	}

}
