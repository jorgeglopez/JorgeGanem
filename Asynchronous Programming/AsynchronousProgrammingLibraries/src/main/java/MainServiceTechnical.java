import com.ea.async.Async;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.*;

public class MainServiceTechnical {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //diagnostic();
        //assignAppointment();
        handleCompletableFuture();
    }


    public static void assignAppointment(String... args) throws ExecutionException, InterruptedException {
        TechnicalOperations technicalOperations = new TechnicalOperations();
        ExecutorService threadpool = Executors.newCachedThreadPool();
        ListeningExecutorService service = MoreExecutors.listeningDecorator(threadpool);
        ListenableFuture<String> guavaFuture = service.submit(() -> technicalOperations.assignDateOfTechnical());
        String result = guavaFuture.get();
        System.out.println("Appointment date ------> " + result);
        threadpool.shutdown();

    }

    static {
        Async.init();
    }

    private static void diagnostic(String... args) throws ExecutionException, InterruptedException {
        TechnicalOperations technicalOperations = new TechnicalOperations();
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> technicalOperations.ServiceTechnical("Fail"));

        String result = Async.await(completableFuture);

        System.out.println("Result is " + result);
    }

    private static void handleCompletableFuture() throws ExecutionException, InterruptedException {
        TechnicalOperations technicalOperations = new TechnicalOperations();
        //CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->technicalOperations.ServiceTechnical("Fail"));
        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(() ->
                {
                    if (technicalOperations.assignDateOfTechnical() == null) {
                        throw new RuntimeException("Error...");
                    }
                    return "Assign of Date service technical: ".concat(technicalOperations.assignDateOfTechnical());

                }).exceptionally(ex -> {
                    System.out.println("failed: " + ex);
                    return "failed";
                });

//        CompletableFuture<Void> future = completableFuture.thenAccept((date) -> System.out.println("Date next of delivery is " + date));
//        CompletableFuture<String> futureGreat = completableFuture.thenApply((message) -> message + " Technical is Jorge");
//        System.out.println(future.get());
        System.out.println(completableFuture.get());
    }


}


