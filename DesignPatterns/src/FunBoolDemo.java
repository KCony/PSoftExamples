package funBoolDemo;

import java.util.function.*;
import java.util.*;
import java.lang.Boolean;
import java.util.stream.*	;

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
	abstract boolean get(Context c);
}

class Constant extends BooleanExp {
	private boolean cnst;

	Constant(boolean c) { 
		this.cnst=c; 
	} 

	boolean get(Context c) {
		return cnst;
	}
}

class VarExp extends BooleanExp {
	private String varname;

	VarExp(String var) { 
		varname = var;
	}

	boolean get(Context c) { 
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
	
	boolean get(Context c) {
		return leftExp.get(c) && rightExp.get(c); 		
	}
} 

class OrExp extends BooleanExp {
	private BooleanExp leftExp;
	private BooleanExp rightExp;

	OrExp(BooleanExp left, BooleanExp right) {
		leftExp = left;
		rightExp = right;
	}

	boolean get(Context c) { 
		return leftExp.get(c) || rightExp.get(c); 
	} 
} 

class NotExp extends BooleanExp {
	private BooleanExp exp;

	NotExp(BooleanExp exp) {
		this.exp = exp;
	}

	boolean get(Context c) { 
		return ! exp.get(c); 
	} 
} 

class LambdaVisitor<A> implements Function<Object, A> {
    private Map<Class<?>, Function<Object, A>> fMap = new HashMap<>();
 
    public <B> Acceptor<A, B> on(Class<B> clazz) {
        return new Acceptor<>(this, clazz);
    }
 
    @Override
    public A apply( Object o ) {
        return fMap.get(o.getClass()).apply( o );
    }
 
    static class Acceptor<A, B> {
        private final LambdaVisitor visitor;
        private final Class<B> clazz;
 
        Acceptor( LambdaVisitor<A> visitor, Class<B> clazz ) {
            this.visitor = visitor;
            this.clazz = clazz;
        }
 
        public LambdaVisitor<A> then(Function<B, A> f) {
            visitor.fMap.put( clazz, f );
            return visitor;
        }
    }
}

public class FunBoolDemo {
	public static Context c = new Context();
	
	static final Function<Object, Boolean> expEvaluator = new LambdaVisitor<Boolean>()
	        .on(Constant.class).then( n -> n.get(c))
	        .on(VarExp.class).then( v -> v.get(c))
	        .on(AndExp.class).then( a -> a.get(c))
	        .on(OrExp.class).then( o -> o.get(c))
	        .on(NotExp.class).then( n -> n.get(c));
	
	public static void main(String[] args) {
		c.setValue("x", false);
		c.setValue("y", true);
		
		BooleanExp exp = new AndExp(
				new OrExp(
						new VarExp("x"), 
						new Constant(true)
						),
				new VarExp("y")
				);
		
		Arrays.asList(exp).stream().map(expEvaluator)
			.forEach(elem -> System.out.println(elem));
		
	}

}
