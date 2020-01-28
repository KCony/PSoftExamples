package subtypeTest;

public class ArraySubtypeTest {

	public static void main(String[] args) {
		Number n;					
		Number[] na;				
		Integer i;					
		Integer[] ia;
		
		na[0] = n;					
		na[1] = i;	
		
		n = na[0];					
		i = na[1]; //what happens?
		
		ia[0] = n; //what happens?
		ia[1] = i;
		
		n = ia[0];
		i = ia[1];
		ia = na; //what happens here?
		
		Double d = 3.14;
		na = ia; //OK!
		na[2] = d; 
		i = ia[2]; //what happens here
	}

}
