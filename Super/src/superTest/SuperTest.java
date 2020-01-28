package superTest;

import java.util.List;

// this works
class Box1<T extends Number> {
}

// this is an error
class Box2<T super Number> {
	
}

public class SuperTest {

	public static void main(String[] args) {
		Box1<Integer> b1 = new Box1<Integer>(); // this works
	}

}
