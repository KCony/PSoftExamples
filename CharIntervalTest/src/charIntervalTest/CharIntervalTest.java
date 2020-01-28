package charIntervalTest;

class CharInterval {
	private final char lo;
	private final char hi;
	
	public CharInterval(char lo, char hi) {
		this.lo = lo;
		this.hi = hi;
	}
	
	// accessors
	public char getlo() { return lo; }
	public char gethi() { return hi; }
	
	// is x in this interval
	public boolean contains(char x) {
		return lo <= x && x <= hi;
	}
	
	// return union of this with another CharInterval
	public CharInterval union(CharInterval other) {
		char uLo = this.getlo() <= other.getlo() ? this.getlo() : other.getlo();
		char uHi = this.gethi() >= other.gethi() ? this.gethi() : other.gethi();
		
		return new CharInterval(uLo, uHi);
	}
	
	// fin the char closest to this
	public char closest(char c) {
		if(c < this.getlo())
			return lo;
		if(c > this.gethi())
			return hi;
		return c;
	}
	
	public void print() {
		System.out.println("lo: " + lo + " hi: " + hi);
	}
}

public class CharIntervalTest {
	
	public static void main(String[] args) {
		CharInterval c1 = new CharInterval('d', 'm');
		CharInterval c2 = new CharInterval('e', 'q');
		
		c1.union(c2).print();
		
		System.out.println(c1.closest('f'));
	}

}
