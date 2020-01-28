package bool;

import java.util.Map;
import java.util.HashMap;

class Context {
	private static Map<String, Boolean> context;

	Context() {
		if (context == null) {
			context = new HashMap<String, Boolean>();
		}
	}

	void setValue(String var, boolean val) {
		context.put(var, val);
	}

	boolean lookup(String var) {
		return context.get(var);
	}
}

abstract class BooleanExp {
	abstract boolean eval(Context c);
}

class Constant extends BooleanExp {
	private boolean cnst;

	Constant(boolean c) { 
		this.cnst=c; 
	} 

	boolean eval(Context c) { 
		return cnst; 
	} 
}

class VarExp extends BooleanExp {
	String varname;

	VarExp(String var) { 
		varname = var; 
	}

	boolean eval(Context c) { 
		return c.lookup(varname);
	}
}

class AndExp extends BooleanExp {
	private BooleanExp leftExp;
	private BooleanExp rightExp;

	AndExp(BooleanExp left, BooleanExp right) {
		leftExp = left;
		rightExp = right;
	}

	boolean eval(Context c) { 
		return leftExp.eval(c) && rightExp.eval(c); 
	} 
} 

class OrExp extends BooleanExp {
	private BooleanExp leftExp;
	private BooleanExp rightExp;

	OrExp(BooleanExp left, BooleanExp right) {
		leftExp = left;
		rightExp = right;
	}

	boolean eval(Context c) { 
		return leftExp.eval(c) || rightExp.eval(c); 
	} 
} 

class NotExp extends BooleanExp {
	private BooleanExp exp;

	NotExp(BooleanExp exp) {
		this.exp = exp;
	}

	boolean eval(Context c) { 
		return ! exp.eval(c); 
	} 
} 

public class BooleanDemo {

	public static void main(String[] args) {
		Context c = new Context();
		c.setValue("x", false);
		c.setValue("y", true);

		BooleanExp exp = new AndExp(
				new OrExp(
						new VarExp("x"), 
						new Constant(true)
						),
				new VarExp("y")
				);

		System.out.println(exp.eval(c));

	}

}
