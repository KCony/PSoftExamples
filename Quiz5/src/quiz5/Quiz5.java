package quiz5;

class Duration {
	private final int min;
	private final int sec;
	public Duration(int min, int sec) {
		this.min = min;
		this.sec = sec;
	}
	public boolean equals(Object o) {
		if (o instanceof Duration) {
			Duration d = (Duration) o;
			return this.min == d.min && this.sec == d.sec;
		}
		else
			return false;
	}
}

public class Quiz5 {

	public static void main(String[] args) {
		Object d1 = new Duration(10,5);
		Object d2 = new Duration(10,5);
		System.out.println(d1.equals(d2));
	}

}
