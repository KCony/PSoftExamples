package sandwich;

// http://www.java67.com/2013/07/decorator-design-pattern-in-java-real-life-example-tutorial.html

import java.math.BigDecimal;

abstract class Sandwich {   
	protected String description = "Sandwich";  

	public String getDescription(){
		return description;
	}

	public abstract BigDecimal price();
}

class GenericSandwich extends Sandwich {

	public GenericSandwich(String desc){
		description = desc;
	}

	@Override
	public BigDecimal price() {
		return new BigDecimal("3.0");
	}
}

abstract class SandWichDecorator extends Sandwich {  

	@Override
	public abstract BigDecimal price();
}

class CheeseDecorator extends SandWichDecorator{
	Sandwich currentSandwich;

	public CheeseDecorator(Sandwich sw){
		currentSandwich = sw;
	}

	@Override
	public String getDescription(){
		return currentSandwich.getDescription() + ", Cheese";
	}
	
	@Override
	public BigDecimal price() {
		return currentSandwich.price().add(new BigDecimal("0.50"));
	}
}

public class SandwichDemo {

	public static void main(String[] args) {
		Sandwich mySandwich = new GenericSandwich("White bread Sandwich");
		System.out.printf("Price of %s is $%.2f %n\n", mySandwich.getDescription(), 
				mySandwich.price());

		//adding extra cheese using Decorator Pattern
		mySandwich = new CheeseDecorator(mySandwich);
		//adding extra double cheese using Decorator Pattern
		mySandwich = new CheeseDecorator(new CheeseDecorator(mySandwich));
		System.out.printf("Price of %s is $%.2f %n", mySandwich.getDescription(), 
				mySandwich.price());
	}
}
