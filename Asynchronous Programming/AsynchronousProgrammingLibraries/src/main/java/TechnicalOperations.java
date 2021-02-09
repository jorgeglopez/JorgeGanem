import java.util.Calendar;
import java.util.Random;
import java.text.SimpleDateFormat;

public class TechnicalOperations {

    Calendar dateNext;

    public String ServiceTechnical(String status) {
        String diagnostic;
        if (status=="Fail") {
            diagnostic="The Cell is Dead";
        } else{
            diagnostic="Next";
        }

        return diagnostic;
    }

    public String assignDateOfTechnical(){
        int number = 0;
        Random next;
        next = new Random();

        dateNext = Calendar.getInstance();
        dateNext.set (next.nextInt(1)+2021, next.nextInt(1)+1, next.nextInt(10)+1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
        return sdf.format(dateNext.getTime());
    }


}
