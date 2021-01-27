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
    public static void main(String... args) throws ExecutionException, InterruptedException {
        /*int number = 10;
        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(()->mathematicsOperations.factorial(number));
        while (!completableFuture.isDone()){
            System.out.println("Completable Future is not Finished");
        }
        Long result = completableFuture.get();
        System.out.println("The result is: "+result);*/
        int number1=1;
        int number2=3;
        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->mathematicsOperations.Sum(number1, number2));
        while (!completableFuture.isDone()){
            System.out.println("Completable Future is not Finished");
        }
       int result = completableFuture.get();
        System.out.println("The result is: "+result);
    }
}
