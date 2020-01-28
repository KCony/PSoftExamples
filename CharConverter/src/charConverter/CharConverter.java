package charConverter;

import java.io.Reader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.StringReader;

class LowercaseConverter extends FilterReader {

	LowercaseConverter(Reader in) { 
		super(in); 
	}

	@Override
	public int read() throws IOException {
		int c = super.read();
		return ( c==-1 ? c : 
			Character.toLowerCase((char)c)); 
	}
}

class UppercaseConverter extends FilterReader {

	UppercaseConverter(Reader in) { 
		super(in); 
	}

	@Override
	public int read() throws IOException {
		int c = super.read();
		return ( c==-1 ? c : 
			Character.toUpperCase((char)c)); 
	}
}

public class CharConverter {
	public static void main(String[] args) throws IOException {
		Reader f = new UppercaseConverter(
						new LowercaseConverter(
							new StringReader(args[0])));
		int c;
		while ((c = f.read()) != -1)
			System.out.print((char)c);
		System.out.println(); 

	}

}
