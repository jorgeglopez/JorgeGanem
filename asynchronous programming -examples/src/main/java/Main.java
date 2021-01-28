import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.jcabi.aspects.Async;

import java.util.concurrent.*;


public class Main {

    /*
    public static void main(String... args) {
        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        Thread thread = new Thread(()->{
           System.out.println("El factorial de número 25 es: " + mathematicsOperations.factorial(25));
        });
        thread.start();
    }
*/
/*    public static void main(String... args) throws ExecutionException, InterruptedException {
        int number = 10;

        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        ExecutorService threadpool = Executors.newCachedThreadPool();
        Future<Long> futureTask = threadpool.submit(()-> mathematicsOperations.factorial(number));

        while (!futureTask.isDone())  {
            System.out.println("Futuretask is not finished");
        }

        long result = futureTask.get();
        System.out.println("The result is: "+result);
        threadpool.shutdown();
    }*/
    /*public static void main(String... args) throws ExecutionException, InterruptedException {
        /*int number = 10;
        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(()->mathematicsOperations.factorial(number));
        while (!completableFuture.isDone()){
            System.out.println("Completable Future is not Finished");
        }
        Long result = completableFuture.get();
        System.out.println("The result is: "+result);
        int number1=1;
        int number2=3;
        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->mathematicsOperations.Sum(number1, number2));
        while (!completableFuture.isDone()){
            System.out.println("Completable Future is not Finished");
        }
       int result = completableFuture.get();
        System.out.println("The result is: "+result);

    }*/
/*
    public static void main(String... args) throws ExecutionException, InterruptedException {
        int number=10;
        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        ExecutorService threadpool = Executors.newCachedThreadPool();
        ListeningExecutorService service = MoreExecutors.listeningDecorator(threadpool);

        ListenableFuture<Long> guavaFuture = service.submit(()->mathematicsOperations.factorial(number));

        long result = guavaFuture.get();

        System.out.println("Result is "+ result);

        threadpool.shutdown();

    }*/

/*
 static {
        Async.init();
    }

    public static void main(String... args) throws ExecutionException, InterruptedException {
        int number=10;
        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(()->mathematicsOperations.factorial(number));

        long result = Async.await(completableFuture);

        System.out.println("Result is "+ result);
    }*/
    /*@Async
    public static void main(String... args) throws ExecutionException, InterruptedException {
        int number=10;
        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        Future<Long> factorialFuture = CompletableFuture.completedFuture(mathematicsOperations.factorial(number));
        System.out.println("The result is "+factorialFuture);

    }*/
/*    Ejercicio Aspectos
@Async
    public static void main(String... args) throws ExecutionException, InterruptedException {
        String diagnostic="Fail";
        TechnicalOperations technicalOperations = new TechnicalOperations();
        Future<String> factorialFuture = CompletableFuture.completedFuture(technicalOperations.ServiceTechnical(diagnostic));
        System.out.println("The result is "+factorialFuture.get());
    }*/

    public static void main(String... args) throws ExecutionException, InterruptedException {
/*        Thread[] myThread = new Thread[20];
        for(int i=0;i<myThread.length;i++){
            myThread[i] = new MyThread("Thread " + i);
        }

        for(int i=0;i<myThread.length;i++){
            myThread[i].start();
            System.out.println(myThread[i].getName());
        }
        MyThread myThread = new MyThread("Thread 1");
        new Thread(myThread).start();
        System.out.println("Thread is" +myThread);*/

        Customer customer = new Customer("Jorge", new int[]{2,2,1,5,2,3});
        Customer customer2 = new Customer("Juan", new int[]{4,1,4,1,1});

        StoreCashier storeCashier = new StoreCashier("Sergio");
        StoreCashier storeCashier1 = new StoreCashier("Sergio");
        long initialTime = System.currentTimeMillis();
        storeCashier.buy(customer,initialTime);
        storeCashier1.buy(customer2,initialTime);


    }
}