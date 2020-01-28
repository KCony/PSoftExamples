package wildcard;

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

public class WildCardTest {

	public static void main(String[] args) {
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple());
		apples.add(new GreenApple());

		List<? extends Fruit> fruits = apples;
		
		
		// compile error
//		apples.add(new Fruit());
		
		// compile error
//		fruits.add(new Apple());
		
		// compile error
//		fruits.add(new GreenApple());
		
		// compile error
//		fruits.add(new Strawberry());

		// compile error
//		fruits.add(new Fruit());
		
		for(Fruit f : fruits) {
			System.out.println(f);
		}
	}

}
