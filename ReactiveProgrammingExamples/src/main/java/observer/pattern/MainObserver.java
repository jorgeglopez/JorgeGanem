package observer.pattern;

public class MainObserver {

    public static void main(String[] args){
        Subject subject = new Subject("Lionel Messi");

        new LengthObserver(subject);
        new CasesObserver(subject);
        //new WordsObserver(subject);


        subject.notifyObservers();



        subject.setState("Falcao Garcia Perez Alias el Tigre");

    }
}
