package birdQues;

abstract class Bird {
	public abstract void speak();
	public void move() { System.out.println("flap flap!"); }
	public void move(int n) { move(); speak(); }
}

class Canary extends Bird {
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

public class SampleBirdQues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Bird b = new Bird();
//		b.move();
		
		Bird b2 = new Canary();
		b2.move(17);
		
		Bird b3 = new Duck();
		b3.move(42);
		
		Bird b4 = new RubberDuck();
		b4.move(3);
		
//		Duck donald = new RubberDuck();
//		donald.swim();
		
		Duck donald2 = new RubberDuck();
		donald2.move();
	}

}
