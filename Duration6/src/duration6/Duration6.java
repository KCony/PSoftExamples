package duration6;

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
	
	public boolean equals(Duration d) {
		System.out.println("Duration.equals(Duration)");
		return 	this.min == d.min && this.sec == d.sec;
	}
}

// mouse over equals to see what compiler thinks should be called
public class Duration6 {

	public static void main(String[] args) {
		Object d1 = new Duration(10,5);
		Duration d2 = new Duration(10,5);
		System.out.println(d1.equals(d2));
	}

}
