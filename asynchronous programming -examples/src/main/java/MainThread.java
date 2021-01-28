import java.util.concurrent.ExecutionException;

public class MainThread {

    public static void main(String... args) throws ExecutionException, InterruptedException {
        Customer customer = new Customer("Jorge", new int[]{2, 2, 1, 5, 2, 3});
        Customer customer2 = new Customer("Juan", new int[]{4, 1, 4, 1, 1});

        StoreCashierThread storeCashier = new StoreCashierThread("Sergio", customer, 1 );
        StoreCashierThread storeCashier1 = new StoreCashierThread("Sergio", customer, 1);
        long initialTime = System.currentTimeMillis();
        storeCashier.start();
        storeCashier1.start();


    }
}
