package functional;

import java.util.function.*;

public class FunctionalProgrammingDemo {
	
	// factory function
	public static Number compute(Function<Number, Number> function, Number value) {
	    return function.apply(value);
	}
	
    private static Number invert(Number value) {
        return (float) (1.0 / value.floatValue());
    }

    public static Number invertTheNumber(Number toInvert){
        Function<Number, Number> invertFunction = FunctionalProgrammingDemo::invert;
        return compute(invertFunction, toInvert);
    }
    
	public static void main(String[] args) {
		Number theNumber = 5;
		Number invertedNumber = invertTheNumber(theNumber);
		System.out.println(theNumber.toString() + " inverted is " + invertedNumber.toString());
	}

}
