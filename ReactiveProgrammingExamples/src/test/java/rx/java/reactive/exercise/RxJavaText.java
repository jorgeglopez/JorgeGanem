package rx.java.reactive.exercise;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


public class RxJavaText {
    String result ="";

    @Test
    public void showObservableCold(){
        //Queue of talks in CallCenter
        Observable<String> observable = Observable.fromArray("Call 1", "Call 2", "Call 3", "Call 4");
        observable.subscribe((AgentOne)->System.out.println("Agent One: "+AgentOne));
        observable.subscribe((AgentTwo)->System.out.println("Agent Two: "+AgentTwo));
    }

    @Test
    public void showObservableHot(){
        ConnectableObservable<String> observable = Observable.just("Call 1", "Call 2", "Call 3", "Call 4").publish();
        observable.subscribe((AgentOne)->System.out.println("Agent One: "+AgentOne));
        observable.subscribe((AgentTwo)->System.out.println("Agent Two: "+AgentTwo));
        observable.connect();
    }

    @Test
    public void showObservableHotTest() throws InterruptedException {
        String[] result = {""};
        ConnectableObservable<Long> connectable = Observable.interval(300, TimeUnit.MILLISECONDS)
                .publish();
        connectable.subscribe(i-> result[0] += i);
        assertFalse(result[0].equals("01"));

        connectable.connect();
        Thread.sleep(500);
        assertTrue(result[0].equals("01"));
    }

    @Test
    public void intervalTest() throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS).subscribe(i-> System.out.println("Second: "+i));
        Thread.sleep(5000);
    }

    @Test
    public void intervalTest1() throws InterruptedException {
        ConnectableObservable<Long> observable = Observable.interval(1, TimeUnit.SECONDS).publish();

        observable.subscribe(i->System.out.println("Second observable one: "+i));
        observable.connect();
        Thread.sleep(5000);
        observable.subscribe(i->System.out.println("Second observable Two: "+i));
        Thread.sleep(5000);
    }

}

