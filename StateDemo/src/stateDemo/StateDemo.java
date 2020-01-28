package stateDemo;

// https://sourcemaking.com/design_patterns/state/java/3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class State {
	String description;
	
    abstract public void pull(Chain chain);
    
    public String getDescription() {
    	return description;
    }
}

class Off extends State {
	Off() {
		description = "off";
	}
	
    public void pull(Chain chain) {
        chain.setState(new Low());
        chain.displayState();
    }
}

class Low extends State {
	Low() {
		description = "low speed";
	}

	public void pull(Chain chain) {
        chain.setState(new Medium());
        chain.displayState();
    }
}

class Medium extends State {
	Medium() {
		description = "medium speed";
	}

    public void pull(Chain chain) {
        chain.setState(new High());
        chain.displayState();
    }
}

class High extends State { 
	High() {
		description = "high speed";
	}

	  public void pull(Chain chain) {
	        chain.setState(new Off());
	        chain.displayState();
	    }
}		

class Chain {
    private State current;

    public Chain() {
        current = new Off();
    }

    public void setState(State state) {
        current = state;
    }

    public void pull() {
        current.pull(this);
    }
    
    public void displayState() {
    	System.out.println(current.getDescription());
    }
}

public class StateDemo {
    public static void main( String[] args ) throws IOException {
        BufferedReader is = new BufferedReader(new InputStreamReader( System.in ));
        Chain chain = new Chain();
        chain.displayState();
        while (true) {
            System.out.println( "Press 'Enter'" );
            is.readLine();
            chain.pull();
        }
    }
}


