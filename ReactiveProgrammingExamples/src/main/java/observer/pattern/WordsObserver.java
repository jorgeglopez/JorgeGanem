package observer.pattern;

public class WordsObserver extends Observer{

    public WordsObserver() {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(){
       // System.out.println("CountWords: "+countWords());

    }

/*    private int countWords(){
        String state = subject.getState();
        int count = 0;
        for (int i = 0; i < state.split();i++){
            if(Character.isLowerCase(state.charAt(i))){
                count++;
            }
        }
        return count;
    }*/
}
