package typeCast;

class A {
	void foo() {System.out.println("A:foo()");}
}

class B extends A{
	void foo() {System.out.println("B:foo()");}
	void foo(int x) {System.out.println("B:foo(int x)");}
}

public class TypeCastDemo {

	public static void main(String[] args) {
		Object x = new A();
		B q = (B) x;
		q.foo(1);
	}

}
