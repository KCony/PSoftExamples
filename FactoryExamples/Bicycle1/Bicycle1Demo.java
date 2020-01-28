package Bicycle1;

class Bicycle {
	Bicycle() {
		System.out.println("Bicycle: create generic bicycle");
	}
}

class RoadBicycle extends Bicycle {
	RoadBicycle() {
		System.out.println("RoadBicycle: create road bike");
	}
}

class MountainBicycle  extends Bicycle {
	MountainBicycle() {
		System.out.println("MountainBicycle: create mountain bike");
	}
}

class Race {
	// factory 
	Bicycle createBicycle() {
		System.out.println("Race::createBicycle: generic bike");
		return this.createBicycle();
	}

	Race createRace() {
		Bicycle bike1 = this.createBicycle(); // callback to appropriate type
		Bicycle bike2 = this.createBicycle();
		return this;  // really should do something useful here
	}
}

class TourDeFrance extends Race {
	@Override
	Bicycle createBicycle() {
		System.out.println("TourDeFrance::createBicycle: road bike");			
		return new RoadBicycle();
	}
}

class Cyclocross extends Race {
	@Override
	Bicycle createBicycle() { 
		System.out.println("Cyclocross::createBicycle: mountain bike");
		return new MountainBicycle();
	} 
}

public class Bicycle1Demo {

	public static void main(String[] args) {
		Race t = new TourDeFrance();
		t.createRace();
		System.out.println();
		Race c = new Cyclocross();
		c.createRace();

		// This causes StackOverflowError; Race should be made abstract
		 t = new Race();
		 t.createRace();
	}
}
