package dispatch2;

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

public class Dispatch2 {

	public static void main(String[] args) {
		A a = new B();
		W w = new W();
		// Which m is called?
		X x = a.m(w);


		B b = new C();
		W w2 = new W();
		// Which m is called?
		X x2 = b.m(w2);
		
		B bb = new B();
		C cc = new C();  // subtype of B
		bb = cc;         // after this executes bb's runtime type is C
		// cc = bb;      // compiler error
	}

}
