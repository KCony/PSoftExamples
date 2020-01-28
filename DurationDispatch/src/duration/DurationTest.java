package duration;

class Object {
	public boolean equals(Object o) {
		System.out.println("Object.equals");  
		return this == o;
	}
}

class Duration extends Object {
	private int min;
	private int sec;

	public Duration(int min, int sec) {
		this.min = min;
		this.sec = sec;
	}
	public boolean equals(Object o) {
		System.out.println("Duration.equals(Object 0)");  
		return this == o;		   
	}

	public boolean equals(Duration d) {
		System.out.println("Duration.equals(Duration d)");
		return this.min == d.min && this.sec == d.sec;
	}
}

public class DurationTest {

	public static void main(String[] args) {
		Duration d1 = new Duration(10,5);
		Duration d2 = new Duration(10,5);
		System.out.println(d1.equals(d2) + "\n");

		Object d3 = new Duration(10,5);
		Duration d4 = new Duration(10,5);
		System.out.println(d3.equals(d4) + "\n");

		Object d5 = new Duration(10,5);
		Object d6 = new Duration(10,5);
		System.out.println(d5.equals(d6) + "\n");

		Duration d7 = new Duration(10,5);
		Object d8 = new Duration(10,5);
		System.out.println(d7.equals(d8) + "\n");
}

}
