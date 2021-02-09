import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<Travel> travel = new ArrayList<>();

    public Person(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Travel> getTravelList() {
        return travel;
    }



    public void setTravel(List<Travel> travel) {
        this.travel = travel;
    }

    public void addTravel(Travel travel) {
        this.travel.add(travel);
    }
}