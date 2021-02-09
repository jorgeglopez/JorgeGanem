import java.util.ArrayList;
import java.util.List;

public class MainStreamParallels {

    public static void main(String[] args){
        long timeBefore;
        long timeAfter;

        List<Employee> employees = new ArrayList<Employee>();

        for (int i=0; i < 100; i++){
            employees.add(new Employee(100,"Employee "+i));
            employees.add(new Employee(200,"Employee "+i));
            employees.add(new Employee(300,"Employee "+i));
            employees.add(new Employee(400,"Employee "+i));
            employees.add(new Employee(500,"Employee "+i));
            employees.add(new Employee(600,"Employee "+i));
            employees.add(new Employee(750,"Employee "+i));
            employees.add(new Employee(800,"Employee "+i));
            employees.add(new Employee(950,"Employee "+i));
        }
        timeBefore = System.currentTimeMillis();

        System.out.println("Secuential stream count: "+employees.stream().
                filter(employee -> employee.getSalary()>200).count());

        timeAfter = System.currentTimeMillis();

        System.out.println("Secuential time taken: " + (timeAfter - timeBefore));

        timeBefore = System.currentTimeMillis();

        System.out.println("Parallels stream count: "+employees.parallelStream().
                filter(employee -> employee.getSalary()>200).count());


        timeAfter = System.currentTimeMillis();

        System.out.println("Parallel time taken: " + (timeAfter - timeBefore));
    }
}
