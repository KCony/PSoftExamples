package callTableTest2;

class A {
	void m(A a) { System.out.print("AA "); }
	void m(B a) { System.out.print("AB "); }
	void m(C a) { System.out.print("AC "); }
}

class B extends A {
	void m(A a) { System.out.print("BA "); }
	void m(B a) { System.out.print("BB "); }
	void m(C a) { System.out.print("BC "); }
}

class C extends B {
	void m(A a) { System.out.print("CA "); }
	void m(B a) { System.out.print("CB "); }
	void m(C a) { System.out.print("CC "); }
}

class D extends A {
	void m(A a) { System.out.print("DA "); }
	void m(B a) { System.out.print("DB "); }
	void m(C a) { System.out.print("DC "); }
}

public class CallTableTest2 {

	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		A a3 = new C();
		B b1 = new B();
		B b2 = new C();
		D d1 = new D();

		System.out.println("\ta1 a2 a3 b1 b2 d1");
		
		System.out.print("a1" + "\t");
		a1.m(a1);
		a1.m(a2);
		a1.m(a3);
		a1.m(b1);
		a1.m(b2);
		a1.m(d1);
		System.out.println();
		
		System.out.print("a2" + "\t");
		a2.m(a1);
		a2.m(a2);
		a2.m(a3);
		a2.m(b1);
		a2.m(b2);
		a2.m(d1);
		System.out.println();

		System.out.print("a3" + "\t");
		a3.m(a1);
		a3.m(a2);
		a3.m(a3);
		a3.m(b1);
		a3.m(b2);
		a3.m(d1);
		System.out.println();

		System.out.print("b1" + "\t");
		b1.m(a1);
		b1.m(a2);
		b1.m(a3);
		b1.m(b1);
		b1.m(b2);
		b1.m(d1);
		System.out.println();

		System.out.print("b2" + "\t");
		b2.m(a1);
		b2.m(a2);
		b2.m(a3);
		b2.m(b1);
		b2.m(b2);
		b2.m(d1);
		System.out.println();

		System.out.print("d1" + "\t");
		d1.m(a1);
		d1.m(a2);
		d1.m(a3);
		d1.m(b1);
		d1.m(b2);
		d1.m(d1);
		System.out.println();
		

	}

}
