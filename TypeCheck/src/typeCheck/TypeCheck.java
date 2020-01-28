package typeCheck;

class A {
	Object m(Number x, Number y) {
		System.out.println("A: " + x);
		return x;
	}
}

class B extends A {	
	Number m(Number x, Number y) {
		System.out.println("B: " + y);
		return null;
	}
}

public class TypeCheck {

	public static void main(String[] args) {
		A a = new B();
		Number a2 = a.m(1, 2);
	}

}
