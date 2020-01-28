package productDemo2;

import java.io.IOException;

class Product {
	Product recommend(Product p) {
		System.out.println("Product: recommend(Product p)");		
		return p; 
	} 
} 

class SaleProduct extends Product {
	Product recommend(SaleProduct p) {
		System.out.println("SaleProduct: recommend(SaleProduct p)");
		return p; 
	}  // overload

	//  what happens if we comment this method out? 
	@Override
	SaleProduct recommend(Product p) { 
		System.out.println("SaleProduct: recommend(Product p)");
		return this; 
	} // override 

	Product recommend(Object p) { 
		System.out.println("SaleProduct: recommend(Object p)");
		return this; 
	} // overload

	//	   Product recommend(Product p) throws IOException { return this; } 	                            
}

// mouse over to see what the compiler will call
public class ProductDemo2 {

	public static void main(String[] args) {
		Object o = null;
		Product p = new SaleProduct();
		SaleProduct s = new SaleProduct();

		p.recommend(p);	     
		p.recommend(s);     // surprised by which one gets called?
		// p.recommend(o);  // compile error - there is no Product.recommend(Object)
		System.out.println();

		s.recommend(p);
		s.recommend(s);    // overload
		s.recommend(o);    // overload
		System.out.println();
	}

}

