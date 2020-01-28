package injection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Class;

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

public class InjectionDemo {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
	       try {
	            File f = new File("bikefactory");
	            BufferedReader b = new BufferedReader(new FileReader(f));
	            String factory = b.readLine();
	            if(factory != null) {
	            	Class factoryClazz = Class.forName(factory);
	            	BicycleFactory bfactory = (BicycleFactory) factoryClazz.newInstance();
	        		Race t = new TourDeFrance(bfactory); // we could change bike type here
	        		t.createRace();
	            }
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

	}

}
