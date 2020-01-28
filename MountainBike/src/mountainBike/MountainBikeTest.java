package mountainBike;

class Bicycle {
    int cadence;
    int speed;
    int gear;

    // effects: creates a new Bicycle
    Bicycle(int startCadence, int startSpeed, int startGear) {};

    // modifies: this
    // effects: this_post.cadence=newCadence, this_post.speed=newSpeed, this_post.gear=newGear
    void setParameters(int newCadence, int newSpeed, int newGear) { 
    	System.out.println("Bicycle: setParameters");
    };
 }

class MountainBike extends Bicycle {
    int height;
    
    // effects: creates a new MountainBike
    MountainBike(int startCadence, int startSpeed, int startGear, int startHeight) {
    	super(startCadence, startSpeed, startGear );
    	height = startHeight;
    	}

    // modifies: this
    // effects: this_post.height=newHeight
    void setHeight(int newHeight) {};
 }


public class MountainBikeTest {

	public static void main(String[] args) {
		Bicycle b1 = new MountainBike(1, 2, 3, 4);
		b1.setParameters(7, 8, 9);
		b1.setHeight(2);
		
		MountainBike b2 = new MountainBike(1, 2, 3, 4);
		b2.setParameters(7, 8, 9);
		b2.setHeight(2);
	}

}
