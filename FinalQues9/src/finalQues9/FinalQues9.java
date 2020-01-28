package finalQues9;

class A {
	void f() { System.out.println("A.f()"); }
	void f(int n) { System.out.println("A.f(int)"); }
	void g(int n) { System.out.println("A.g(int)"); }
}

class B extends A {
	@Override
	void f() { System.out.println("B.f()"); }
	void h() { System.out.println("B.h()"); }
}

class C extends B {
	@Override
	void g(int n) { System.out.println("C.g(int)"); }
	void g(String s) { System.out.println("C.g(String)"); }
	void g(Object o) { System.out.println("C.g(Object)"); }
}

public class FinalQues9 {

	public static void main(String[] args) {
		A a = new C(); a.f();
		A a2 = new C(); a2.g(1); 
//		A a3 = new C(); a3.g("cat");
		B b = new B(); b.g(1);
//		B b2 = new C(); b2.g();
//		B b3 = new C(); C c = b3;
	}

}
