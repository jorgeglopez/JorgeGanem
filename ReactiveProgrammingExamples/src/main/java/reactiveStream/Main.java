package reactiveStream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

public class Main {

    public static void main (String[] args){
        //SubmissionPublisher -> Es un productor o fuente de flujo de datos
        SubmissionPublisher<Integer> submissionPublisher = new SubmissionPublisher<>();

        //Procesor --> Intermediario, que hace transformación de los flujos de datos
        Flow.Processor<Integer, Integer> powProcessor = new PowProcessor();
        //printSubscriber --> consumidor de la fuente
        Flow.Subscriber<Integer> printSubscriber = new PrintSubscriber();

        //subscribe--> se suscribe a la fuente de flujo de datos
        submissionPublisher.subscribe(powProcessor);

        //powProcessor--> luego de procesar los datos, se convierte tambien en una fuente de flujo de datos para poder proporcionar al consumidor
        powProcessor.subscribe(printSubscriber);

        IntStream.range(0,20).forEach((i)->{
            submissionPublisher.submit(i);
            Sleeper.sleep(2000);
        });
        //los suscriptores actuales hasta que se cierre
        submissionPublisher.close();
    }
}
