package ques12;

import java.util.List;
import java.util.ArrayList;

class Vehicle {
	int wheels = 4;
}

class Automobile extends Vehicle {
	String color;
	
	String getColor() { return color; }
	// other methods
}

class SmartCar extends Automobile {
	String description = "small";
	
}


public class Ques12 {
	
	static <A> boolean FindTheCar(List<? super A> cars, A theCar) {
		for(int i = 0; i < cars.size(); i++) {
			if(cars.get(i) == theCar) {
				return true;
			}
		}
		return false;
	}
	
	

	public static void main(String[] args) {
		List<Vehicle> lv = new ArrayList<Vehicle>();
		List<Automobile> la = new ArrayList<Automobile>();
		List<? extends Automobile> la2 = new ArrayList<Automobile>();

		Vehicle v = new Vehicle();
		Automobile a = new Automobile();
		SmartCar s = new SmartCar();
		
		FindTheCar(lv, v);
		FindTheCar(la, v);
		FindTheCar(la2, v);

		FindTheCar(lv, a);
		FindTheCar(la, a);
		FindTheCar(la2, a);
		
		FindTheCar(lv, s);
		FindTheCar(la, s);
		FindTheCar(la2, s);

}

}
