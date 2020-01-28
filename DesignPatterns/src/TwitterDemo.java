package twitterDemp;

import java.util.List;
import java.util.ArrayList;

interface Observer {
    void inform(String tweet);
}

// View
class NYTimes implements Observer {
    @Override
    public void inform(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY!" + tweet);
        }
    }
}

class Guardian implements Observer {

    @Override
    public void inform(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another news in London... " + tweet);
        }
    }
}

class LeMonde implements Observer {
    @Override
    public void inform(String tweet) {
        if (tweet != null && tweet.contains("wine")) {
            System.out.println("Today cheese, wine and news! " + tweet);
        }
    }
}

interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}

// Model
class Feed implements Subject {
    private final List<Observer> observers = new ArrayList < > ();

    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.inform(tweet));
    }
}

// Controller
public class TwitterDemo {

	public static void main(String[] args) {
	    Feed f = new Feed();
	    f.registerObserver(new NYTimes());
	    f.registerObserver(new Guardian());
	    f.registerObserver(new LeMonde());
	    f.notifyObservers("Save money.!");
	}

}
