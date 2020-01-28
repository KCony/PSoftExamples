package ques6Orig;

class P {
	P m(P p) { return p; }
}

class Q extends P {
	P m(Q q) { return null; }
	Q m(P p) { return null; }
	P m(Object O) { return null; }
//	P m(P p) throws InvalidDataException { return null;
//	Object m(Q q) { return null; }
}
	
public class Ques6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
