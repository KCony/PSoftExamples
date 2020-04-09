package wildCardContravariant;

import java.util.ArrayList;
import java.util.List;

public class WildCardContravariant {
	public static void main(String[] args) {
		Object o;
		Number n;
		Integer i;
//		PositiveInteger p; // extends Integer

		List<? super Integer> lsi;

		lsi = new ArrayList<Object>();
		lsi = new ArrayList<Number>();
		lsi = new ArrayList<Integer>();
		
		lsi.add(o);
		lsi.add(n);
		lsi.add(i);
//		lei.add(p); 
		lsi.add(null);
		
		o = lsi.get(0);
		n = lsi.get(0);
		i = lsi.get(0);
	}
}
