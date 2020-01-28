package objStrategy;

// see http://mrbool.com/functional-programming-clean-code-and-design-patterns/33997

interface Strategy {
	double apply(double a, double b);
}

class Maximum implements Strategy {
	@Override
	public double apply(double a, double b) {
		return a > b ? a : b;
	}
}

class Minimum implements Strategy {
	@Override
	public double apply(double a, double b) {
		return a < b ? a : b;
	}
}

class Average implements Strategy {
	@Override
	public double apply(double a, double b) {
		return (a + b) / 2;
	}   
}

class Context {
	private final Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public double execute(double a, double b) {
		return this.strategy.apply(a, b);
	}
};

public class ObjStrategyDemo {    
	public static void main(String[] args) {        
		Context context = new Context(new Maximum());
		System.out.println(context.execute(3,4));

		context = new Context(new Minimum());
		System.out.println(context.execute(3,4));

		context = new Context(new Average());
		System.out.println(context.execute(3,4));  
	}    
}

