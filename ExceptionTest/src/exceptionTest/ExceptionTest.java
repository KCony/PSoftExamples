package exceptionTest;

class A {
	A() {
		System.out.println("I'm an A");
	}
	
	void foo() {
		System.out.println("A foo");
	}
}

class B extends A {
	B() {
		System.out.println("I'm a B");
	}
	
	void foo() {
		System.out.println("B foo");
	}
	
	void foo(int x) {
		System.out.print("B foo int ");
		System.out.println(x);
	}
	
}

public class ExceptionTest {

	public static void main(String[] args) {
		Object a = new A();
		B b = (B) a; // this is not allowed
		b.foo(3);
	}

}