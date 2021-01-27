public class TechnicalOperations {

    public String ServiceTechnical(String status) {
        String diagnostic;
        if (status=="Fail") {
            diagnostic="The Cell this Dead";
        } else{
            diagnostic="Next";
        }

        return diagnostic;
    }
}
