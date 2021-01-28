import java.util.concurrent.ExecutionException;

public class MainServicesTechnical {


    public static void main(String... args) throws ExecutionException, InterruptedException {
        Customer customer = new Customer("Jorge", new int[]{2, 2, 1, 5, 2, 3});
        Customer customer2 = new Customer("Luis", new int[]{4, 1, 4, 1, 1});

        AttentionCustomer attentionCustomer = new AttentionCustomer("Carlos", customer, 1 );
        AttentionCustomer attentionCustomer1 = new AttentionCustomer("Carlos", customer, 1);
        long initialTime = System.currentTimeMillis();
        attentionCustomer.start();
        attentionCustomer1.start();


    }
}
