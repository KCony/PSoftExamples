package funBikeFactory;

import java.util.function.Supplier;

interface Bicycle {
	Bicycle getBike();
}

class MountainBicycle implements Bicycle {
	public Bicycle getBike() {
		System.out.println("Mountain Bicycle");
		return this;
	}
}

class RoadBicycle implements Bicycle {
	public Bicycle getBike() {
		System.out.println("Road Bicycle");
		return this;
	}
}

public class FunBicycleFactory {
	
	public static void main(String[] args) {
		final Supplier<Bicycle> mountainBikeFactory = () -> {
			return new MountainBicycle();
		};
		
		final Supplier<Bicycle> roadBikeFactory = () -> {
			return new RoadBicycle();
		};
		
		Bicycle b1 = mountainBikeFactory.get().getBike();
		Bicycle b2 = roadBikeFactory.get().getBike();
	}

}
