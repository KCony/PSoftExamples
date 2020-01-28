package funTwitterDemo;

import java.util.List;
import java.util.ArrayList;
import java.util.function.*;

// View
interface Observer {
    void inform(String tweet);
}

interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}

class Feed implements Subject {
    private final List<Observer> observers = new ArrayList < > ();

    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.inform(tweet));
    }
}

// Model and Controller
public class FunTwitterDemo {
	public static void main(String[] args) {
	    Feed feedLambda = new Feed();
	    
	    feedLambda.registerObserver((String tweet) -> {
	        if (tweet != null && tweet.contains("money")) {
	            System.out.println("Breaking news in NY! " + tweet);
	        }
	    });

	    feedLambda.registerObserver((String tweet) -> {
	        if (tweet != null && tweet.contains("queen")) {
	            System.out.println("Yet another news in London... " + tweet);
	        }
	    });

	    feedLambda.notifyObservers("Money money money, give me money!");
	}
}
