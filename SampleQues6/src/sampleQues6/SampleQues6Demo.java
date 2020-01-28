package sampleQues6;
class X {
	X() { }
}
class Y extends X {
	Y() { }
}
class Z {
	Z() { }
}
class W extends Z {
	W() { }
}
class A {
	A() {}
	X m(Z z) {
		System.out.println("A: X m(Z z)");
		return new X();
	}
}
class B extends A {
	B() { }
	X m(W w) { 
		System.out.println("B: X m(W w)");
		return new X();
	}
}
class C extends B {
	C() { }
	Y m(W w) { 
		System.out.println("C: Y m(W w)");
		return new Y(); 
	}
}

public class SampleQues6Demo {
	public static void main(String[] args) {
		A a = new C();
		W w = new W();
		Z z = new Z();;
		// Which m is called?
		X x = a.m(w);
		// X x = a.m(z);

		C c = new C();
		W w2 = new W();
		// Which m is called?
		Y x3 = c.m(w2);
	}
}

