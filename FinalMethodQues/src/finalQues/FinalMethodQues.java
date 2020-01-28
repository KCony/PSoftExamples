package finalQues;

class A {
	void f() { System.out.println("A.f()"); }
	void f(int n) { System.out.println("A.f(int)"); }
	void g(int n) { System.out.println("A.g(int)"); }
}

class B extends A {
	void f() { System.out.println("B.f()"); }
	void h() { System.out.println("B.h()"); }
}

class C extends B {
	void g(int n) { System.out.println("C.g(int)"); }
	void g(String s) { System.out.println("C.g(String)"); }
	void h(int n) { System.out.println("C.h(int)"); }
}

public class FinalMethodQues {

	public static void main(String[] args) {
		A a = new C();
		a.f();
		
		a.g(1);
//		a.g("cat"); // compile error
		
		B b = new B();
		b.g(1);
		b.f();
		
//		C c = b;   // compile error

		// not used
//		//		c.g("cat");
//		
//		B b2 = new C();
//		b2.f(1);
////		b2.g("cat"); // compile error
	}

}
