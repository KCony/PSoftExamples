package cionstantInt;

class ConstantInt {
	private Integer val;
	public ConstantInt(int v) {
		this.val = v;
	} 

//	public boolean equals(Object x) {
//		return true;
//	}
	
//	public boolean equals(ConstantInt x) {
//		return this == x; 
//	}

//	public boolean equals(ConstantInt x) {
//		return this.val == x.val; 
//	}
	
//	public boolean equals(ConstantInt x) {
//		return this.val.equals(x.val); 
//	}

//	public boolean equals(Object x) {
//		if(!(x instanceof ConstantInt))
//			return false;
//		ConstantInt ci = (ConstantInt)x;
//		return this.val == ci.val; 
//	}
	
//	public boolean equals(Object x) {
//		  if(this == x)
//		    return true;
//		  if(!(x instanceof ConstantInt))
//		    return false;
//		  ConstantInt ci = (ConstantInt)x;
//		  return this.val.intValue() == ci.val.intValue(); 	
//	}	
}

public class ConstantIntDemo {

	public static void main(String[] args) {
		ConstantInt a = new ConstantInt(1);
		Object b = new ConstantInt(1);
		ConstantInt c = new ConstantInt(1);

		System.out.println(a.equals(a));
		
		System.out.println(a.equals(b));
		System.out.println(b.equals(a));
		
		System.out.println(b.equals(c));
		System.out.println(a.equals(c));
	}

}
