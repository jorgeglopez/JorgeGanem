import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.CompletableFuture;

public class SquareFutureExample {
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

/*    public SquareFutureExample(ExecutorService executor){
        this.executor = executor;
    }*/

    public Future<Integer> calculateAsync(Integer input){
        CompletableFuture<Integer> completableFuture =new CompletableFuture<>();

        Executors.newFixedThreadPool(2).submit(()->{
            try {
                Thread.sleep(1000);
                completableFuture.complete(input*input);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });
        return completableFuture;
    }

    public void shutDown(){
        executor.shutdown();
    }

    /*public Integer calculate(Integer input){
        CompletableFuture<Integer> completableFuture =new CompletableFuture<>();

        return completableFuture;


        });

    }*/


}
