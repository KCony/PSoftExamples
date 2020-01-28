package ques7;

public class Mult {
	
	// precondition a >= 0 && b >= 0
	static int mult(int a, int b) {
		int x = a;
		int y = b;
		int total = 0;
		System.out.println("x" + "\t" + "y" + "\t" + "total");
		System.out.println(x + "\t" + y + "\t" + total);
		while( x > 0 ) {
			if(x % 2 == 1) {
					x = (x - 1)/2;
					total = total + y;
			} else {
				x = x / 2;
			}	
			y = y * 2;
			System.out.println(x + "\t" + y + "\t" + total);
		}
		
		return total;
	}
	// postcondition: total = a*b

	public static void main(String[] args) {
//		System.out.println(mult(18, 3));
//		System.out.println(mult(18, 3));
		System.out.println(mult(5, -9));
	}

}
