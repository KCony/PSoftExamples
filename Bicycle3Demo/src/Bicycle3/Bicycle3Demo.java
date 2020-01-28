package Bicycle3;

class Bicycle {
	Bicycle() {
		// System.out.println("create generic bicycle");
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
	Bicycle createBicycle() {
	   System.out.println("road bike");
		return new RoadBicycle();
	}
}
class MountainBicycleFactory extends BicycleFactory {
	Bicycle createBicycle() {
		System.out.println("mountain bike");
		return new MountainBicycle();
	}
}

class Race {
	BicycleFactory bfactory;
	// constructor
	Race(BicycleFactory bfactory) { 
		this.bfactory = bfactory;
	}

	Race createRace() {
		Bicycle bike1 = bfactory.createBicycle();
		Bicycle bike2 = bfactory.createBicycle();
		return this;
	}
}

class TourDeFrance extends Race {
	// constructor
	TourDeFrance(BicycleFactory bfactory) {
		super(bfactory);  // call superclass constructor and pass the appropriate factory
	}	
}

class Cyclocross extends Race { 
	// constructor
	Cyclocross(BicycleFactory bfactory) {
		super(bfactory);
	}
}

public class Bicycle3Demo {

	public static void main(String[] args) {
		Race t = new TourDeFrance(new MountainBicycleFactory()); // we could change bike type here
		t.createRace();
	}
}
