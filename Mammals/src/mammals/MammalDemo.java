package mammals;

import java.util.List;

class Mammal {}
class Cow extends Mammal {}
class Horse extends Mammal {}
class ToyHorse extends Horse {}

public class MammalDemo {

	public static void main(String[] args) {
		Object o; Mammal m; Cow c;  Horse h; ToyHorse t;
		
		List<? extends Mammal> lem;
		List<? extends Horse> leh;
		List<? super Horse> lsh;

		lem.add(h);

		lsh.add(t);

		lsh.add(o);

		lem.add(null);
				
		h = lsh.get(1);

		m = leh.get(1);

		o = lsh.get(1);

	}

}
