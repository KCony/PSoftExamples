package Bicycle2;

class Bicycle {
	Bicycle() {
		System.out.println("create generic bicycle");
	}
}

class RoadBicycle extends Bicycle {
	RoadBicycle() {
		System.out.println("create road bike");
	}
}

class MountainBicycle  extends Bicycle {
	MountainBicycle() {
			System.out.println("create mountain bike");
	}
}

class BicycleFactory {
	Bicycle createBicycle() { 
		return new Bicycle();
	}
	// Frame createFrame() { }
	// Wheel createWheel() { }
}

class RoadBicycleFactory extends  BicycleFactory {
	@Override
	Bicycle createBicycle() {
	   System.out.println("road bike factory");
		return new RoadBicycle();
	}
}
class MountainBicycleFactory extends BicycleFactory {
	@Override
	Bicycle createBicycle() {
		System.out.println("mountain bike factory");
		return new MountainBicycle();
	}
}

class Race {
	BicycleFactory bfactory;
	// constructor
	Race() { 
		bfactory = new BicycleFactory();
	}

	Race createRace() {
		Bicycle bike1 = bfactory.createBicycle(); // callback to appropriate factory method 
		Bicycle bike2 = bfactory.createBicycle();
		return this;
	}
}

class TourDeFrance extends Race {
	// constructor
	TourDeFrance() { 
		bfactory = new RoadBicycleFactory(); 
	}
}
class Cyclocross extends Race { 
	// constructor
	Cyclocross() { 
		bfactory = new MountainBicycleFactory();
	}
}

public class Bicycle2Demo {

	public static void main(String[] args) {
		Race t = new TourDeFrance();
		t.createRace();
		System.out.println();
		Race c = new Cyclocross();
		c.createRace();
	}
}
