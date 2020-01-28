package wildCardContravariant;

import java.util.ArrayList;
import java.util.List;

public class WildCardContravariant {
	public static void main(String[] args) {
		Object o;
		Number n;
		Integer i;
//		PositiveInteger p; // extends Integer

		List<? super Integer> lei;

		lei = new ArrayList<Object>();
		lei = new ArrayList<Number>();
		lei = new ArrayList<Integer>();
		
		lei.add(o);
		lei.add(n);
		lei.add(i);
//		lei.add(p); 
		lei.add(null);
		
		o = lei.get(0);
		n = lei.get(0);
		i = lei.get(0);
	}
}
