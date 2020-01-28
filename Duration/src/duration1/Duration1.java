package duration1;

class Duration {
	private final int min;
	private final int sec;

	public Duration(int min, int sec) {
		this.min = min;
		this.sec = sec;
	}

	public boolean equals(Duration d) {
		System.out.println("Duration.equals");
		return 	this.min == d.min && this.sec == d.sec;
	}
}

public class Duration1 {

	public static void main(String[] args) {
		Duration d1 = new Duration(10,5);
		Duration d2 = new Duration(10,5);
		System.out.println(d1.equals(d2) + "\n"); 
		
		System.out.println("Reflexive");
		System.out.println(d1.equals(d1) + "\n");
		
		System.out.println("Symmetric");
		System.out.println(d2.equals(d1) + "\n");
		
		System.out.println("Transitive");
		Duration d3 = new Duration(10,5);
		System.out.println(d2.equals(d3));
		System.out.println(d1.equals(d3) + "\n");

		System.out.println("Objects");		
		Object do1 = new Duration(10,5);
		Object do2 = new Duration(10,5);
		System.out.println(do1.equals(do2)); 
	}

}
