import java.util.ArrayList;
import java.util.List;

public class MainTravels {
    public static void main (String[] args){
        Person personOne = new Person("Jorge");
        Travel travelOne = new Travel("France");
        Travel travelTwo = new Travel("Dublin");
        personOne.addTravel(travelOne);
        personOne.addTravel(travelTwo);

        Person personTwo = new Person("Vanessa");
        Travel travelTree = new Travel("England");
        Travel travelFour = new Travel("Andorra");
        Travel travelFive = new Travel("Prague");
        personTwo.addTravel(travelTree);
        personTwo.addTravel(travelFour);
        personTwo.addTravel(travelFive);

        List<Person> people = new ArrayList<Person>();
        people.add(personOne);
        people.add(personTwo);

        String countries="";
/*        for (Person person:people){
            *//*for (int travels=0; person.getTravelsList().size()>travel;travel++){
                countries +=person.getTravelsList().get(travel).getCountry()+", ";
            }*//*
            for (Travels travel : person.getTravelList()){
                System.out.println(travel.getCountry());
            }
        }*/

        /*people.stream()
                .map(person -> person.getTravel())
                .flatMap(travel -> travel.stream())
                .forEach(travels -> System.out.println(travels.getCountry()));

    }*/
}}
