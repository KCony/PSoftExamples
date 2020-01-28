package ques8;

import java.util.ArrayList;
import java.util.List;

class Animal {
	void eat() {
		System.out.println("chomp");		
	}
}

class Cat extends Animal {
	void speak() {
		System.out.println("meow");
	}
}

class Kitten extends Cat {
	private int cuteness = 1000;
	int get_cuteness() {
		return cuteness;
	}
}

public class FinalQues8 {
	
//	static void speakThenAdd(List<Cat> cats, Cat newCat) {
//		for(Cat c : cats)
//			c.speak();
//		newCat.speak();
//		cats.add(newCat);
//	}

	static <C extends Cat>  void speakThenAdd(List<C> cats, C newCat) {
		for(C c : cats)
			c.speak();
		newCat.speak();
		cats.add(newCat);
	}

	public static void main(String[] args) {
		List<Animal> la = new ArrayList<Animal>();
		List<Cat> lc = new ArrayList<Cat>();
//		List<Kitten> lk = new ArrayList<Kitten>();
		List<? extends Cat> lk = new ArrayList<Cat>();
		
		Animal a = new Animal();
		Cat c = new Cat();
		Kitten k = new Kitten();
		
		speakThenAdd(la, a);
		speakThenAdd(lc, a);
		speakThenAdd(lk, a);

		speakThenAdd(la, c);	
		speakThenAdd(lc, c);
		speakThenAdd(lk, c);

		speakThenAdd(la, k);
		speakThenAdd(lc, k);
		speakThenAdd(lk, k);
	}

}
