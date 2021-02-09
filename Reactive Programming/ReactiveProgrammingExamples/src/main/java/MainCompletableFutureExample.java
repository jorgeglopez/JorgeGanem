import java.util.concurrent.*;

public class MainCompletableFutureExample {

/*    public static void main (String[] args) throws ExecutionException, InterruptedException {
        //thenApplyCompletableFuture();
        //thenAcceptCompletableFuture();
        thenCompose();
    }*/
    /*
        SquareFutureExample squareFutureExample = new SquareFutureExample();
        //Future<Integer> completableFuture = new SquareFutureExample().calculate(12);

        Future<Integer> completableFuture = CompletableFuture.completedFuture(3*3);
        Integer result = completableFuture.get();

        System.out.println("The result is "+result);

        squareFutureExample.shutDown();
    }*/
    private static void supplyAsyncCompletableFutureExample() throws ExecutionException, InterruptedException {
        SquareFutureExample squareFutureExample = new SquareFutureExample();
        Future<Void> completableFuture =
                //CompletableFuture.supplyAsync(()->3*3); suppleyAsync interface no recibe argumentos pero si recibe valores
                CompletableFuture.runAsync(()->System.out.println(" este es un runsAsync"));
                //Integer result = completableFuture.get();
               // Integer

        //System.out.println("The result is: "+result);

        squareFutureExample.shutDown();
    }
/*    private static void thenApplyCompletableFuture() throws ExecutionException, InterruptedException {

        *//**
        * thenApply, acepta una instancia de funcion, lo procesa y devuelve un future,
         * que contiene el valor devuelto pr la función
         *//*
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->3*3);
        CompletableFuture<String> completableFutureGreat =
                CompletableFuture.supplyAsync(()->"Hello");

        CompletableFuture<Integer> future = completableFuture.thenApply((nine)->nine/3);
        CompletableFuture<String> futureGreat = completableFutureGreat.thenApply((message)->message +"Jorge");
        System.out.println(future.get());
        System.out.println(futureGreat.get());
    }*/
/*    private static void thenAcceptCompletableFuture() throws ExecutionException, InterruptedException {
        *//**
         * thenAccept es de tipo consumer y tiene un unico parametro pero no devuelve nada
         *//*
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->3*3);
        CompletableFuture<String> completableFutureGreat =
                CompletableFuture.supplyAsync(()->"Hello");

        CompletableFuture<Void> future = completableFuture.thenAccept((nine)->System.out.println("The number is"+nine/3);
        CompletableFuture<String> futureGreat = completableFutureGreat.thenApply((message)->message +"Jorge");
        System.out.println(future.get());
        System.out.println(futureGreat.get());
    }*/
    public static void thenCompose() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(()->"Hello ");
        CompletableFuture<String> greetingFuture =
                completableFuture
                        .thenCompose((word)->firstName(word))
                        .thenCompose((word)-> lastName(word));
                System.out.println(greetingFuture.get());



    }
    public static CompletableFuture<String> firstName(String word){
        return CompletableFuture.supplyAsync(()->word.concat("Jorge"));
    }
    public static CompletableFuture<String> lastName(String word){
        return CompletableFuture.supplyAsync(()->word.concat(" Ganem"));
    }
/*    public static void main (String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture =
                new CompletableFuture<>();

        CompletableFuture<CompletableFuture<String>> completableText =
                completableFuture
                        .thenApply((word)->firstName(word));
        CompletableFuture<String> completableFutureCompose =
                completableFuture
                        .thenCompose((word)-> lastName(word));
        System.out.println(completableText.get());



    }*/


/*    public static void main (String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<Integer> completableFuture =
                CompletableFuture.supplyAsync(()-> 3*3, executor);

        CompletableFuture<Integer> future = completableFuture.thenApply((nine)-> nine /3);

        System.out.println((future.get()));

        executor.shutdown();
    }*/

    public static void main (String[] args) throws ExecutionException, InterruptedException {
/*        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<Integer> completableFuture =
                CompletableFuture.supplyAsync(()-> 3*3);

        CompletableFuture<Integer> future = completableFuture.thenApply((nine)-> nine /3);

        System.out.println((future.get()));

        executor.shutdown();*/
        handleCompletableFuture();
    }

    public static void handleCompletableFuture() throws ExecutionException, InterruptedException {

        String name="Jorge";


        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            if (name==null){
                throw new RuntimeException("Error...");
            }
            return "Hi".concat(name);
        });
        //.handle((success, error)->success!=null?success:"There is an error");

        completableFuture.completeExceptionally(new RuntimeException("There is an error"));

        System.out.println(completableFuture.get());
    }



}
