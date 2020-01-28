package birds;

abstract class Bird {
	public abstract void speak();
	public void move() { System.out.println("flap flap!"); }
	public void move(int n) { move(); speak(); }
}

class Sparrow extends Bird {
	public void speak() { System.out.println("chirp!"); }
	public void move(int n) { speak(); speak(); }
}

class Duck extends Bird {
	public void speak() { System.out.println("quack!"); }
}

class RubberDuck extends Duck {
	public void speak() { System.out.println("squeak!"); }
	public void move() { speak(); swim(); }
	public void swim() { System.out.println("paddle!"); }
}

public class Birds {
	public static void main(String[] args) {
		System.out.println("a");
		Bird b = new Bird();
		b.move();
		System.out.println();

		System.out.println("b");
		Bird b = new Sparrow();
		b.move(1);
		System.out.println();
		
		System.out.println("c");
		b.move();
		System.out.println();
		
		System.out.println("d");
		Bird b2  = new Duck();
		b2.move(2);
		System.out.println();
		
//		System.out.println("e");
//		Bird b3 = new RubberDuck();
//		b3.move();
//		System.out.println();
		
		System.out.println("e");
		Duck donald = new RubberDuck();
		donald.swim();
		System.out.println();
		
		System.out.println("f");
		Duck daisy = new RubberDuck();
		daisy.move();
	}	
}
