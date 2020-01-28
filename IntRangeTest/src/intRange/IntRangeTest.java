package intRange;

class IntRange {

//	/* (non-Javadoc)
//	 * @see java.lang.Object#hashCode()
//	 */
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + hi;
//		result = prime * result + lo;
//		return result;
//	}

	@Override
	public int hashCode() {
		int prime = 31; 
		if (this.size() == 0) {
			return -1;  
		}
		return this.getlo() * prime + gethi();
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof IntRange))
			return false;
		IntRange other = (IntRange) obj;
		if (hi != other.hi)
			return false;
		if (lo != other.lo)
			return false;
		return true;
	}

	private final int lo;
	private final int hi;
	
	public IntRange(int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
	}
	
	// accessors
	public int getlo() { return lo; }
	public int gethi() { return hi; }
	
	// is x in this interval
	public boolean contains(int x) {
		return lo <= x && x < hi;
	}
	
	// return union of this with another CharInterval
	public IntRange union(IntRange other) {
		int uLo = Math.min(this.getlo(), other.getlo());
		int uHi = Math.max(this.gethi(), other.gethi());

		return new IntRange(uLo, uHi);
	}
	
	// find the int closest to this
	public int closest(int c) {
		if(c < this.getlo())
			return lo;
		if(c > this.gethi())
			return hi;
		return c;
	}
	
	public int size() {
		if(this.getlo() > this.gethi())
			return 0;
		return this.gethi() - this.getlo();
	}
	
	public void print() {
		System.out.println("lo: " + lo + " hi: " + hi);
	}
}

public class IntRangeTest {

	public static void main(String[] args) {
		IntRange r1 = new IntRange(3, 10);
		IntRange r2 = new IntRange(1, 5);
		
		r1.union(r2).print();
		System.out.println(r1.contains(10));
		
		IntRange r3 = new IntRange(1, 1);
		IntRange r4 = new IntRange(67, 5);
		System.out.println(r1.size());
		System.out.println(r3.size());
		System.out.println(r4.size());
		
		IntRange r5 = new IntRange(-1, 31);
		IntRange r6 = new IntRange(-2, 62);
		System.out.println(r5.hashCode());
		System.out.println(r6.hashCode());		
	}

}
