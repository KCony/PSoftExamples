package dispatchQues;

import dispatch1.A;
import dispatch1.B;
import dispatch1.X;
import dispatch1.Y;
import dispatch1.Z;

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

public class DispatcQuesDemo {

	public static void main(String[] args) {

	}

}
