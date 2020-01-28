package ques6;

class Point2D {
	private double x;
	private double y;
	
	Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	double getX() {
		return x;
	}
	
	double getY() {
		return y;
	}
	
	void setX(double x) {
		this.x = x;
	}
	
	void setY(double y) {
		this.y = y;
	}
}


class Segment2D {
	// REP Invariant: distance = Math.sqrt((end.x - start.x)^2 + (end.y - start.x)^2)
	
	private Point2D start;
	private Point2D end;
	private double length;

	Segment2D(Point2D start, Point2D end) {
		this.start = start;
		this.end = end;
		length = distance(this.start, this.end);
	}
	
	static double distance(Point2D p1, Point2D p2) {
		return Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2));
	}
	
	public Point2D getStart() { return start; }
	public Point2D getEnd() { return end; }
	public double getLength() { return this.length; }
	public void setStart( Point2D start ) { this.start = start; }
	public void setEnd(Point2D end ) { this.end = end; }
}

public class Ques6Demo {

	public static void main(String[] args) {
		Segment2D s = new Segment2D(new Point2D(1,1), new Point2D(2, 3));
		System.out.println(s.getLength());
		
		s.setEnd(new Point2D(6, 7));
		System.out.println(s.getLength());
	}

}
