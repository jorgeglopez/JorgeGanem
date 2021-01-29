import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class MainServicesTechnical  {


    public static void main(String... args) throws ExecutionException, InterruptedException {
        Customer customer = new Customer("Jorge ", new int[]{2, 2, 1, 5, 2, 3});
        Customer customer2 = new Customer("Luis ", new int[]{4, 1, 4, 1, 1});

        AttentionCustomer attentionCustomer = new AttentionCustomer("Carlos ", customer, 1 );
        AttentionCustomer attentionCustomer1 = new AttentionCustomer("David ", customer, 1);

        //Runnable processOne= ()-> attentionCustomer.attention(customer,1);
        //Runnable processTwo= ()-> attentionCustomer1.attention(customer,1);

        long initialTime = System.currentTimeMillis();
/*        attentionCustomer.start();
        attentionCustomer1.start();*/
        //new Thread(processOne).start();
        //new Thread(processTwo).start();


/*        Executor executor1 = (command)-> attentionCustomer.attention(customer,1);
        Executor executor2 = (command)-> attentionCustomer1.attention(customer,1);
        executor1.execute(new ExecutorRunnable());
        executor2.execute(new ExecutorRunnable());*/



        System.out.println("The thread started");
        ExecutorService executor1 = Executors.newCachedThreadPool();
        executor1.execute(()-> attentionCustomer.attention(customer,1));
        executor1.shutdown();
        ExecutorService executor2 = Executors.newCachedThreadPool();
        executor2.execute(()-> attentionCustomer1.attention(customer2,1));
        executor2.shutdown();
        System.out.println("The Thread finished");


    }
}
