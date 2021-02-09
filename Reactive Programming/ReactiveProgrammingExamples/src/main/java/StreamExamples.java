import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {
    Stream<String> employees = listEmploys().stream();
    Stream<List<String>> employeesTwo = Stream.of(listEmploys());
    public List<String> listEmploys(){
        List<String> alist=new ArrayList<String>();
        alist.add("Steve");
        alist.add("Tim");
        alist.add("Lucy");
        alist.add("Pat");
        alist.add("Angela");
        alist.add("Tom");
        return alist;

    }
    public void forEach(){
        employees.forEach((employee)->showEmployees(employee));
    }

    public void peek(){
        employees.filter((employee)->employee.length()>3)
                .peek((employee)->showEmployees(employee));
    }

    public void map(){
        employees.map((employee)->convertUpperCase(employee))
                .forEach((employee)->showEmployees(employee));
    }

/*    public void flatMap(){
        employees.map((employee)->convertUpperCase(employee))
                .collect(Collectors.toList())
                .stream().flatMap((employee)->

    }*/

    public void skip(){
        employees.skip(3).forEach(employee->showEmployees(employee));
    }

    public void limit(){
        employees.limit(3).forEach(employee->showEmployees(employee));
    }

    public void intStreamSpecialization(){
/*        int valueMin = IntStream.of(2,4,6,8)
                .min().getAsInt();
        showValues(valueMin);*/
        //showValues(IntStream.range(0,15).sum());
        //showValues(IntStream.of(2,2,4,6).distinct().reduce(0,(a,b)->a+b));
        showValues(IntStream.of(2,2,4,6).noneMatch((number)->number % 2 ==0));
    }

    public void showValues(boolean input){
        System.out.println(input);
    }

    public void generateStream(){
        Stream.generate(Math::random).limit(10)
                .forEach(System.out::println);
    }

    public void iterator(){
        Stream.iterate(4,(i)->i*4)
                .limit(10)
                .forEach(System.out::println);
    }

    public void showEmployees(String employee){
        System.out.println(employee);
    }

    private String convertUpperCase(String employee){
        return employee.toUpperCase();
    }
}
