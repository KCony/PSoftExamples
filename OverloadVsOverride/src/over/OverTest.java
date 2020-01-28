package over;

import java.util.Set;
import java.util.HashSet;

class MyClass {
	// overload not override
	boolean equals(MyClass m) { 
		return true;
	}
}

public class OverTest {

	public static void main(String[] args) {
	    Set<MyClass> myClasses = new HashSet<>();
	    myClasses.add(new MyClass());
	    myClasses.add(new MyClass());
	    System.out.println(myClasses.size()); // prints 2?!
	    
	    MyClass myClass = new MyClass();
	    System.out.println(new MyClass().equals(myClass));  // true
	    
	    Object o = new MyClass();
	    System.out.println(new MyClass().equals(o));  // false
	}

}
