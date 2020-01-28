package quiz4;

class Duration {
	private final int min;
	private final int sec;
	public Duration(int min, int sec) {
		this.min = min;
		this.sec = sec;
	}
	public boolean equals(Object o) {
		System.out.println("Duration.equals");
		if (! (o instanceof Duration) )  return false;
		Duration d = (Duration) o;
		return this.min == d.min && this.sec == d.sec;  
	}
}

class NanoDuration extends Duration {
	private final int nano;
	public NanoDuration(int min, 
			int sec, 
			int nano){
		super(min,sec);// initializes min&sec
		this.nano = nano;
	}
	public boolean equals(Object o) {
		System.out.println("NanoDuration.equals");
		if (! (o instanceof Duration) )  return false;
		if (! (o instanceof NanoDuration) ) return super.equals(o);
		NanoDuration nd = (NanoDuration) o;
		return super.equals(nd) && nd.nano == nano;  
	}
}

public class TestDuration2 {
	public static void main(String[] args) {
		Duration d1 = new NanoDuration(5,10,15);
		Object d2 = new Duration(5,10);
		Object d3 = new NanoDuration(5,10,30);
		System.out.println(d1.equals(d2)); 
		System.out.println(d2.equals(d3));
		System.out.println(d1.equals(d3));
	}
}
