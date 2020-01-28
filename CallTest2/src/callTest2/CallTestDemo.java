package callTest2;

class A {
	void m(A a) { System.out.println("AA"); }
	void m(B a) { System.out.println("AB"); }
	void m(C a) { System.out.println("AC"); }
}

class B extends A {
	void m(A a) { System.out.println("BA"); }
	void m(B a) { System.out.println("BB"); }
	void m(C a) { System.out.println("BC"); }
}

class C extends B {
	void m(A a) { System.out.println("CA"); }
	void m(B a) { System.out.println("CB"); }
	void m(C a) { System.out.println("CC"); }
}

public class CallTestDemo {

	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B a3 = new C();
		A b1 = new B();
		B c1 = new C();

		a1.m(a2);
		a2.m(b1);
		a2.m(c1);
		b1.m(a1);
		c1.m(b1);
		a3.m(b1);;
	}

}
