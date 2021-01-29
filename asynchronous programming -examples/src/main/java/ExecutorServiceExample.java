import java.util.concurrent.*;
import java.util.stream.IntStream;

//Primer tipo de executor FixedThreadExecutor(ejecutor de grupos de sub-procesos fijos)
public class ExecutorServiceExample {

   /* public static void main(String[] args){
        System.out.println("The thread started");
        ExecutorService executors = Executors.newFixedThreadPool(3);
        IntStream.range(0,10).forEach(i -> executors.execute(()->showNameThread()));
        executors.shutdown();
        System.out.println("The Thread finished");
    }
*/
    public static void showNameThread(){
        System.out.println("Thread name: "+ Thread.currentThread().getName());
    }

    //Primer Tipo de executor SingleThreadPoolExecutor (Ejecutar de grupo de subprocesos unicos
   /* public static void main(String[] args){
        System.out.println("The thread started");
        ExecutorService executors = Executors.newCachedThreadPool();
        IntStream.range(0,10).forEach(i -> executors.execute(()->showNameThread()));
        executors.shutdown();
        System.out.println("The Thread finished");

    }*/
    //Grupo de subprocesos programados Scheduled
    /*public static void main(String[] args){
        ExecutorService executors = Executors.newScheduledThreadPool(1);
        IntStream.range(3,10).forEach(
                i ->((ScheduledExecutorService)executors).schedule(()->ExecutorServiceExample.showNameThread(),10, TimeUnit.SECONDS)
        );
        System.out.println("The thread finished");
        executors.shutdown();
    }*/

    /*public static void main(String[] args){
        ScheduledExecutorService executors = Executors.newScheduledThreadPool(1);
        IntStream.range(3,10).forEach(
                i ->executors.scheduleAtFixedRate(()->ExecutorServiceExample.showNameThread(),10,10, TimeUnit.SECONDS)
        );
        System.out.println("The thread finished");
        //executors.shutdown();
    }*/

    public static void main(String[] args){
        ScheduledExecutorService executors = Executors.newScheduledThreadPool(1);
        IntStream.range(3,10).forEach(
                i ->executors.scheduleWithFixedDelay(()->ExecutorServiceExample.showNameThread(),10,10, TimeUnit.SECONDS)
        );
        System.out.println("The thread finished");
        //executors.shutdown();
    }
}
