package callTest3;

class A {
	void m(A a) { System.out.println("AA"); }
	void m(B a) { System.out.println("AB"); }
	void m(C a) { System.out.println("AC"); }
	void m(D a) { System.out.println("AD"); }	
}

class B extends A {
	void m(A a) { System.out.println("BA"); }
	void m(B a) { System.out.println("BB"); }
	void m(C a) { System.out.println("BC"); }
	void m(D a) { System.out.println("BD"); }	
}

class C extends B {
	void m(A a) { System.out.println("CA"); }
	void m(B a) { System.out.println("CB"); }
	void m(C a) { System.out.println("CC"); }
	void m(D a) { System.out.println("CD"); }	
}

class D extends C {
	void m(A a) { System.out.println("DA"); }
	void m(B a) { System.out.println("DB"); }
	void m(C a) { System.out.println("DC"); }
	void m(D a) { System.out.println("DD"); }	
}

public class CallTest {

	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		A a3 = new C();
		B b1 = new B();
		D d1 = new D();

		a1.m(a2);
		a2.m(b1);
		a3.m(d1);
		b1.m(a1);
		d1.m(b1);
		a3.m(b1);;
	}

}

