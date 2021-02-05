package rx.java.reactive;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


public class RxJavaText {
    String result ="";
    int result1;
    int resultSum;

    @Test
    public void createSimpleObservable (){
        Observable<String> observable = Observable.just("Jorge");
        observable.subscribe((s)-> result=s);
        assertTrue(result.equals("Jorge"));
    }

    @Test
    public void showMethodRxJavaTest() {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        Observable<String> observable = Observable.fromArray(letters);
        observable.subscribe(
                //onNext es la operación sobre la data
                (i)-> result+=i,
                //onError si pasa un error lo visualiza
                Throwable::printStackTrace,
                //onCompleted este cuando se completa todo el flujo
                ()-> result+="_Completed"
                );
        assertTrue(result.equals("ABCDEFGHI_Completed"));
    }

/*    @Test
    public void showMethodRxJavaTestV2() {
        Observable<Integer> observable = Observable.just(operation());
        observable.subscribe(
                //onNext es la operación sobre la data
                (i)-> result1=8,
                //onError si pasa un error lo visualiza
                Throwable::printStackTrace,
                //onCompleted este cuando se completa todo el flujo
                ()-> result1=8
        );
        assertTrue(result.equals(5));
    }

    public int operation(){
        int sum;
        sum=3+5;
        return sum;
    }*/

    @Test
    public void mapOperationTest(){
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I","J", "K"};
        Observable.fromArray(letters)
                .map(String::toUpperCase)
                .subscribe((letter)->result += letter,
                        Throwable::printStackTrace,
                        ()-> System.out.println("Completed"));
        assertTrue(result.equals("ABCDEFGHIJK"));
    }



    @Test
    public void scanOperatorTest(){
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I","J", "K"};
        Observable.fromArray(letters)
                .scan(new StringBuilder(), StringBuilder::append)
                .subscribe(total -> result+= total.toString());
        //assertTrue(result.equals("AABABC"));
    }

    @Test
    public void groupByOperatorTest(){
        Integer[] numbers = {0,1,2,3,4,5,6,7,8,9,10};
        String[] odd = {""};
        String[] even = {""};

        Observable.fromArray(numbers)
                .groupBy((i)->i%2==8? "even" : "odd")
                .subscribe(group->
                        group.subscribe((number->{
                            if(group.getKey().toString().equals("even")){
                                even[0]+=number;
                            }else{
                                odd[0]+=number;
                            }
                        }))
                        );
        assertTrue(even[0].equals("02468"));
        assertTrue(odd[0].equals("13579"));
    }

    @Test
    public void filterTest(){
        Integer[] numbers = {0,2,3,4,5,6,7,8,9,10};
        Observable.fromArray(numbers)
                .filter(number -> number %2 ==1)
                .subscribe(number -> result += number);

        assertTrue(result.equals("13579"));
    }

    @Test
    public void defaultIfEmptyWithObservableEmptyTest(){
        Observable.empty()
                .defaultIfEmpty("Observable is Empty")
                .subscribe(i -> result += i);

        assertTrue(result.equals("Observable is Empty"));
    }

    @Test
    public void defaultIfEmptyWithObservableDataTest(){
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I","J", "K"};
        Observable.fromArray(letters)
                .defaultIfEmpty("Observable is Empty")
                .firstElement()
                .subscribe(i -> result += i);

        assertTrue(result.equals("A"));
    }

    @Test
    public void takeWhileTest(){
        Integer[] numbers = {0,2,3,4,5,6,7,8,9,10};
        Observable.fromArray(numbers)
                .takeWhile(number -> number < 5)
                .subscribe(i -> resultSum += i);

        assertEquals(10,resultSum);
    }

    @Test
    public void showObservableCold(){
        Observable<String> observable = Observable.just("a", "b", "c", "d");
        observable.subscribe((observerOne)->System.out.println("ObserverOne: "+observerOne));
        observable.subscribe((observerTwo)->System.out.println("ObserverTwo: "+observerTwo));
    }

    @Test
    public void showObservableHot(){
        ConnectableObservable<String> observable = Observable.just("a", "b", "c", "d").publish();
        observable.subscribe((observerOne)->System.out.println("ObserverOne: "+observerOne));
        observable.subscribe((observerTwo)->System.out.println("ObserverTwo: "+observerTwo));
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
