package dispatch1;

class X {
	X() { }
}

class Y extends X {
	Y() { }
}

class Z extends Y {
	Z() { }
}

class A {
	A() {}
	X m(Object o) {
		System.out.println("A: X m(Object o)");
		return new X();
	}
}

class B extends A {
	B() { }
	X m(Z z) { 
		System.out.println("B: X m(Z z)");
		return new X();
	}
}

class C extends B {
	C() { }
	Y m(Z z) { 
		System.out.println("C: Y m(Z z)");
		return new Y(); 
	}
}


public class Dispatch1 {

	public static void main(String[] args) {
		A a = new B();
		Object o = new Object();
		// Which m is called?
		X x = a.m(o);


		A a2 = new C(); // Try changing to C a2 = ...
		Object o2 = new Z();
		// Which m is called?
		X x2 = a2.m(o2);	    
	}

}
