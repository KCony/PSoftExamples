public class Point2D {
	int x;
	int y;
	
	// constructor
	Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static void main(String[] args) {
		Point2D a = new Point2D(5, 2);
		Point2D b = new Point2D(5, 2);
		
		Point2D c = b;
		
		// what does this output?
		System.out.println(a.equals(b));
		System.out.println(b.equals(c));
	}

}
