import com.ea.async.Async;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.*;

public class MainServiceTechnical {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //diagnostic();
        //assignAppointment();
        thenAcceptCompletableFuture();
    }


    public static void assignAppointment(String... args) throws ExecutionException, InterruptedException {
        TechnicalOperations technicalOperations = new TechnicalOperations();
        ExecutorService threadpool = Executors.newCachedThreadPool();
        ListeningExecutorService service = MoreExecutors.listeningDecorator(threadpool);
        ListenableFuture<String> guavaFuture = service.submit(()->technicalOperations.assignDateOfTechnical());
        String result = guavaFuture.get();
        System.out.println("Appointment date ------> "+ result);
        threadpool.shutdown();

    }

    static {
        Async.init();
    }

    private static void diagnostic(String... args) throws ExecutionException, InterruptedException {
        TechnicalOperations technicalOperations = new TechnicalOperations();
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->technicalOperations.ServiceTechnical("Fail"));

        String result = Async.await(completableFuture);

        System.out.println("Result is "+ result);
    }

    private static void thenAcceptCompletableFuture() throws ExecutionException, InterruptedException {
        TechnicalOperations technicalOperations = new TechnicalOperations();
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->technicalOperations.ServiceTechnical("Fail"));
        CompletableFuture<String> completableFutureGreat =
                CompletableFuture.supplyAsync(()->"Repair Date: "+technicalOperations.assignDateOfTechnical());

        CompletableFuture<Void> future = completableFuture.thenAccept((date)->System.out.println("The number is"+date));
        CompletableFuture<String> futureGreat = completableFutureGreat.thenApply((message)->message +" Technical is Jorge");
        //System.out.println(future.get());
        System.out.println(futureGreat.get());
    }


}


