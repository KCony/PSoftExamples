package exam02Ques5;

import java.util.ArrayList;
import java.util.List;

class Mammal {}
class Cow extends Mammal {}
class Horse extends Mammal {}
class ToyHorse extends Horse {}

public class Ques5Test {

	public static void main(String[] args) {
		Object o; Mammal m;  Cow c;  Horse h = new Horse(); ToyHorse t = new ToyHorse();
		List<? extends Mammal> lem = new ArrayList<Mammal>();
		List<? extends Horse> leh = new ArrayList<Horse>();
		List<? super Horse> lsh = new ArrayList<Horse>();
		
//		lem.add(h);
		lsh.add(t);
//		lsh.add(o);
		lem.add(null);
		
//		h = lsh.get(1);
		m = leh.get(1);
		o = lsh.get(1);
		
		lsh.add(h);
	}

}
