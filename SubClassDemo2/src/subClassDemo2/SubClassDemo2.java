package subClassDemo2;

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
	X m(W w, X x) { 
		System.out.println("B: X m(W w, X x)");
		return new X();
	}
	//	X m(Z z) { 
	//		System.out.println("B: X m(Z z)");
	//		return new X();
	//	}
}
class C extends B {
	C() { }
	Y m(W w, X x) { 
		System.out.println("C: Y m(W w, X x)");
		return new Y(); 
	}
}

class SubClassDemo2 {
	public static void main(String[] args) {
		B b = new C();
		W w = new W();
		Y y = new Y();
		
		b.m(w, y);
	}

}
