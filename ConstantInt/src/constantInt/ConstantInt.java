package constantInt;

class ConstantInt {
	private Integer val;
	public ConstantInt(int v) {
		this.val = v;
	} 
	// other methods …
	public boolean equals(Object x) {
		if(this == x)
			return true;
		if(!(x instanceof ConstantInt))
			return false;
		ConstantInt ci = (ConstantInt)x;
//		return this.val == ci.val; 	
		return this.val.equals(ci.val); 	
	}	


	public static void main(String[] args) {
		ConstantInt a = new ConstantInt(1);
		Object b = new ConstantInt(1);
		ConstantInt c = new ConstantInt(1);

		System.out.println(a.equals(a));
		System.out.println(a.equals(b)); 	
		System.out.println(b.equals(c));
		System.out.println(b.equals(a)); 	
		System.out.println(c.equals(a));

	}

}
