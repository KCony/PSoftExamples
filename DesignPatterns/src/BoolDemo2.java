// Visitor Pattern

import java.util.Map;

import java.util.HashMap;

interface Visitor {
	// overloads
	public boolean visit(BooleanExp b);
	public boolean visit(Constant e);
	public boolean visit(VarExp e);
	public boolean visit(NotExp e);
	public boolean visit(AndExp e);
	public boolean visit(OrExp e); 
}

class EvaluateVisitor implements Visitor {
	Context c;
	
	EvaluateVisitor(Context c) {
		this.c = c;
	}
	
	public boolean visit(BooleanExp b) {
		return b.getValue();
	}
	
	public boolean visit(Constant e) { 
		return e.getValue();
	}
	
	public boolean visit(VarExp e) {
		return c.lookup(e.getName());
	}
	
	public boolean visit(NotExp e) {
		return ! e.getValue();
	}

	public boolean visit(AndExp e) {
		return e.getLeft() && e.getRight();
	}

	public boolean visit(OrExp e) {
		return e.getLeft() || e.getRight();
	}
}

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
	boolean val;
	
	abstract boolean accept(Visitor v);
	
	boolean getValue() {
		return val;
	}
}

class Constant extends BooleanExp {
	Constant(boolean c) { 
		val = c; 
	} 

	boolean accept(Visitor v) { 
		return v.visit(this);
	}
}

class VarExp extends BooleanExp {
	String varname;

	VarExp(String var) { 
		varname = var; 
	}
	
	String getName() {
		return varname;
	}
	
	boolean accept(Visitor v) { 
		return v.visit(this);
	}
}

class AndExp extends BooleanExp {
	private BooleanExp leftExp;
	private BooleanExp rightExp;

	AndExp(BooleanExp left, BooleanExp right) {
		leftExp = left;
		rightExp = right;
	}
	
	boolean getLeft() {
		return leftExp.getValue();
	}
	
	boolean getRight() {
		return rightExp.getValue();
	}

	boolean accept(Visitor v) { 
		leftExp.val = leftExp.accept(v);
		rightExp.val = rightExp.accept(v);
		return v.visit(this);
	}
} 

class OrExp extends BooleanExp {
	private BooleanExp leftExp;
	private BooleanExp rightExp;

	OrExp(BooleanExp left, BooleanExp right) {
		leftExp = left;
		rightExp = right;
	}

	boolean getLeft() {
		return leftExp.getValue();
	}
	
	boolean getRight() {
		return rightExp.getValue();
	}

	boolean accept(Visitor v) { 
		leftExp.val = leftExp.accept(v);
		rightExp.val = rightExp.accept(v);
		return v.visit(this);
	}
} 

class NotExp extends BooleanExp {
	private BooleanExp exp;

	NotExp(BooleanExp exp) {
		this.exp = exp;
	}

	boolean accept(Visitor v) { 
		val = exp.accept(v);
		return v.visit(this);
	}
}

public class BoolDemo2 {

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
		
		System.out.println(exp.accept(new EvaluateVisitor(c)));
	}
}
