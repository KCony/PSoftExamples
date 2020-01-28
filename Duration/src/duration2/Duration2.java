package duration2;

class Duration {
	private final int min;
	private final int sec;

	public Duration(int min, int sec) {
		this.min = min;
		this.sec = sec;
	}

	@Override
	public boolean equals(Object o) {
		System.out.println("Duration.equals(Object)");
		if (! (o instanceof Duration) ) 
			return false;
		Duration d = (Duration) o;
		return this.min == d.min && this.sec == d.sec;  
	}
	
	// overload
	public boolean equals(Duration d) {
		System.out.println("Duration.equals(Duration)");
		return 	this.min == d.min && this.sec == d.sec;
	}
}

public class Duration2 {
	public static void main(String[] args) {
		Object d1 = new Duration(10,5);
		Object d2 = new Duration(10,5);
		System.out.println(d1.equals(d2));

		System.out.println("\nReflexive");
		System.out.println(d1.equals(d1) + "\n");
		
		System.out.println("Symmetric");
		System.out.println(d2.equals(d1) + "\n");
		
		System.out.println("Transitive");
		Duration d3 = new Duration(10,5);
		System.out.println(d2.equals(d3));
		System.out.println(d1.equals(d3) + "\n");
	}
}
