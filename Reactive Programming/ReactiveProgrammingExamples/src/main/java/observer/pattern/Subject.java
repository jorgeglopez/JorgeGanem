package observer.pattern;

import java.util.LinkedList;
import java.util.List;

public class Subject {

    private List<Observer> observers;
    private String state;

    public Subject(String state) {
        this.observers = new LinkedList();
        setState(state);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void registerObserver(Observer... observers){
        for(Observer observer : observers){
            this.observers.add(observer);
        }
    }

    public void notifyObservers(){
        for(Observer observer: observers){
            observer.update();
        }
    }
}
