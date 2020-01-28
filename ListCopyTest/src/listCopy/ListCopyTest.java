package listCopy;

import java.util.List;

public class ListCopyTest {

	public static <T> void copy(List<T> dst, List<T> src) {
		for (T t : src) {
			dst.add(t);
		}
	}

	public static void main(String[] args) {
		List<Number> l1;
		List<String> l2; 
		copy(l1,l2); // compile-time error. 

		List<String> l3;
		List<Object> l4;
		copy(l3,l4); // compile-time error. 

		List<Object> l5;
		List<String> l6;
		copy(l5,l6); // compile-time error
		
		List<String> l7;
		List<String> l8;
		copy(l7, l8);

	}

}
