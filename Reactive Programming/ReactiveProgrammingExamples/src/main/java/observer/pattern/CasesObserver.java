package observer.pattern;

import java.util.stream.Stream;

public class CasesObserver extends Observer {

    public CasesObserver(Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(){
        System.out.println("LowerCase: ");
        System.out.println("UpperCase: ");
    }

    private void countLowerCases(){
        String state = subject.getState();
        int count = 0;

       /* state.map((employee)->convertUpperCase(employee))
                .forEach((employee)->showEmployees(employee));*/

    }

    public void iterator(){
        Stream.iterate(4,(i)->i*4)
                .limit(10)
                .forEach(System.out::println);
    }



    private int countUpperCases(){
        String state = subject.getState();
        int count = 0;
        for (int i = 0; i < state.length();i++){
            if(Character.isUpperCase(state.charAt(i))){
                count++;
            }
        }
        return count;
    }
}
