package classA;

public class ClassA {
	class X { }
	
	class Y extends X { }
	
	class Z extends X { }
	
	class A<T extends X, W extends T> { }
	
	class A<T extends Y> {}

	public static void main(String[] args) {
		
	}

}
