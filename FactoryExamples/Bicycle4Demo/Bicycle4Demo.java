package Bicycle4Demo;

class Bicycle implements Cloneable {
	Bicycle() {
		// System.out.println("create generic bicycle");
	}
	
	public Object clone() {
		Object clone = null;

		try {
			clone = super.clone();

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return clone;
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
class Race {
	Bicycle bProto;
	// constructor
	Race(Bicycle bProto) { 
		this.bProto = bProto;
	}

	Race createRace() {
		Bicycle bike1 = (Bicycle) bProto.clone();
		Bicycle bike2 = (Bicycle) bProto.clone();
		return this;
	}
}

class TourDeFrance extends Race {
	// constructor
	TourDeFrance(Bicycle bProto) {
		super(bProto);  // call superclass constructor and pass the appropriate factory
	}	
}

class Cyclocross extends Race { 
	// constructor
	Cyclocross(Bicycle bProto) {
		super(bProto);
	}
}

public class Bicycle4Demo {
	public static void main(String[] args) {
		Race t = new TourDeFrance(new MountainBicycle()); // we could change bike type here
		t.createRace();
	}
}
