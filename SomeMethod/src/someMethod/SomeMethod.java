package someMethod;

public class SomeMethod {

	public static void main(String[] args) {
		SomeMethod s = new SomeMethod();
		s.some_method();
	}

	public void some_method() {
		int i = 6;   
		int j = 6; // uninitialized
		int [ ] a = {1,3,5,7,9}; // creates a 5-element array
		int [ ] b = new int[3]; // auto initialized to 0
		String s = new String("abcdef"); // creates a new string
		String t = null;  // null is a reference

		i = j;
		j = i;  // copy a value
		a = b;
		b = a; // copy a reference; now nothing refers to [0,0,0]
		t = s;  // now s and t refer to the same object

		a[0] = 6;
		t = t + "g";  // make a new string. Why?
	}

}
