package sampleQues;

import java.util.List;

public class SampleFinalQues1 {

	interface Mascot {}

	class Pet {}
	class Cat extends Pet {}
	class Dog extends Pet {}
	class Husky extends Dog implements Mascot {}

	public static void main(String[] args) {
		Object o; Pet p; Cat c; Dog d; Husky h; Mascot m;
		List <? extends Pet> lep;
		List <? extends Cat> lec;
		List <? super Husky> lsh;

		lsh.add(h);
		lep.add(o);
		lep.add(d);
		lec.add(p);
		lsh.add(o);
		lec.add(null);
		d = lsh.get(1);
		d = lec.get(1);
		d = lep.get(1);
		o = lec.get(1);
		p = lsh.get(1);
		p = null.get(1);

	}

}
