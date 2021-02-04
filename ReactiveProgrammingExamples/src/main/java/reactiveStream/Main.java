package reactiveStream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

public class Main {

    public static void main (String[] args){
        //El envio de la publicacion del metodo Publisher
        SubmissionPublisher<Integer> submissionPublisher = new SubmissionPublisher<>();
        //Permite procesar los elemetnos del productor para aplicarles una transformacion antes que sean entregados
        //a los consumidores
        Flow.Processor<Integer, Integer> powProcessor = new PowProcessor();
        Flow.Subscriber<Integer> printSubscriber = new PrintSubscriber();

        //publica elementos para los Subscriber basándose en sus demandas recibidas.
        submissionPublisher.subscribe(powProcessor);
        powProcessor.subscribe(printSubscriber);
        IntStream.range(0,20).forEach((i)->{
            submissionPublisher.submit(i);
            Sleeper.sleep(2000);
        });
        //los suscriptores actuales hasta que se cierre
        submissionPublisher.close();
    }
}
