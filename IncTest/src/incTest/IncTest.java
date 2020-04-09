package incTest;

class B {
	private int c=0;
	
	void inc1() { 
		System.out.println("B: inc1 version 1"); 
		c++; 
	}
	
//	 void inc1() { 		
//		System.out.println("B: inc1 version 2"); 
//		inc2();    // call this.inc2() - in second case this is an A
//	 }
	
	void inc2() { 
		System.out.println("B: inc2"); 
		c++; 
	}
	
	int get() {
		return c;
	}
} 

class A extends B {
	@Override
	void inc2() {
		System.out.println("A: inc2"); 
		inc1(); 
	}
}

public class IncTest {
	public static void main(String[] args) {
		A a = new A();
		a.inc2();
		System.out.println(a.get());
	}
}
