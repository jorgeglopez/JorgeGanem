import java.util.ArrayList;
import java.util.List;

public class MainServiceQueue {

    public static void main (String[] args){
        Customer customerOne = new Customer("Jorge");
        Cells cellOne = new Cells("iPhone");
        Cells cellTwo = new Cells("Samsung");
        customerOne.addCell(cellOne);
        customerOne.addCell(cellTwo);

        Customer customerTwo = new Customer("Vanessa");
        Cells cellTree = new Cells("Xiaomi");
        Cells cellFour = new Cells("Asus");
        customerOne.addCell(cellOne);
        customerOne.addCell(cellTwo);
        customerTwo.addCell(cellTree);
        customerTwo.addCell(cellFour);


        List<Customer> customers = new ArrayList<Customer>();
        customers.add(customerOne);
        customers.add(customerTwo);

        String cell="";
        /*        for (Person person:people){
         *//*for (int travels=0; person.getTravelsList().size()>travel;travel++){
                countries +=person.getTravelsList().get(travel).getCountry()+", ";
            }*//*
            for (Travels travel : person.getTravelList()){
                System.out.println(travel.getCountry());
            }
        }*/

        customers.stream().map((customer) -> customer.getCellList())
                .flatMap(cells -> cells.stream())
                .forEach(customer -> System.out.println(customer.getCell()));

    }


}
