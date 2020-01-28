package wildCardTest2;

import java.util.ArrayList;
import java.util.List;

class Fruit {
	Fruit() { }
}

class Apple extends Fruit {
	Apple() { }
}

class GreenApple extends Apple {
	GreenApple() { }
}

class Strawberry extends Fruit {
	Strawberry() { }
}

public class WildCardTest2 {

	public static void main(String[] args) {
		List<? super Fruit> fruits = new ArrayList<Fruit>();
		
		fruits.add(new Apple());
		fruits.add(new GreenApple());
		fruits.add(new Fruit());
		
		// compile error
		// fruits.add(new Object());

		// compile error
		//Fruit f = fruits.get(0);

		for(Object f2 : fruits) {
			System.out.println(f2);
		}

	}

}
