package ques4;

import java.util.List;

public class Exam2Ques4 {
	
	class Animal {}
	class Cat extends Animal {}
	class Dog extends Animal {}
	
	
	public static void main(String[] args) {
		Object o;
		Animal a;
		Cat c;
		Dog d;
		
		List<? extends Animal> list1;
		list1.add(a);
		list1.add(c);
		c = list1.get(0);
		a = list1.get(0);
		o = list1.get(0);
		
		List<? super Cat> list2;
		list2.add(c);
		list2.add(d);
		c = list2.get(0);
		a = list2.get(0);
		o = list2.get(0);
	}

}
