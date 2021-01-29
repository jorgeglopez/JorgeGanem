import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
    public static void main(String[] args){
        System.out.println("The thread started");
        ExecutorService executors = Executors.newCachedThreadPool();
        IntStream.range(0,10).forEach(i -> executors.execute(()->showNameThread()));
        executors.shutdown();
        System.out.println("The Thread finished");

    }

}
