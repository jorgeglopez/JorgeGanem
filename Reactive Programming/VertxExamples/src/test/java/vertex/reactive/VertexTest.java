package vertex.reactive;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.dns.DnsClient;
import io.vertx.core.file.FileProps;
import io.vertx.core.file.FileSystem;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.streams.Pump;
import io.vertx.core.streams.ReadStream;
import io.vertx.ext.reactivestreams.ReactiveReadStream;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class VertexTest {
    Vertx vertx = Vertx.vertx();

    @Test
    public void vertexReactiveDNSTest(){
        DnsClient client = vertx.createDnsClient(53, "9.9.9.9");
        client.resolveA("vertx.io", ar -> {
            if (ar.succeeded()) {
                List<String> records = ar.result();
                for (String record : records) {
                    System.out.println(record);
                }
            } else {
                System.out.println("Failed to resolve entry" + ar.cause());
            }
        });
        assertThat(client.resolveA("vertx.io").succeeded());
    }

    @Test
    public void vertexReactiveReadStreamTest() {
        ReactiveReadStream reactiveReadStream = new ReactiveReadStream() {

            @Override
            public ReactiveReadStream handler(Handler handler) {
                return null;
            }

            @Override
            public ReactiveReadStream pause() {
                return null;
            }

            @Override
            public ReactiveReadStream resume() {
                return null;
            }

            @Override
            public ReadStream fetch(long amount) {
                return null;
            }

            @Override
            public ReactiveReadStream endHandler(Handler endHandler) {
                return null;
            }

            @Override
            public ReactiveReadStream exceptionHandler(Handler handler) {
                return null;
            }

            Integer[] numbers = {0,2,3,4,5,6,7,8,9,10};
            @Override
            public void onSubscribe(Subscription s) {
                this.numbers = numbers;
                s.request(2);
                System.out.println(numbers);

            }

            @Override
            public void onNext(Object o) {
                o.notify();
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    @Test
    public void vertxSendEventBusTest() {
        String message = "Hello, world!";
        vertx.eventBus().send("address", message);
        vertx.eventBus().consumer("address");
        System.out.println(message);
        assertThat(message).contains("Hello, world!");
    }



    @Test
    public void responseHttpReadStreamTest(HttpServerResponse response, Publisher<Buffer> otherPublisher) {

        ReactiveReadStream<Buffer> reactiveReadStream = ReactiveReadStream.readStream();
        otherPublisher.subscribe(reactiveReadStream);
        Pump pump = Pump.pump(reactiveReadStream, response);

        pump.start();

        assertThat(reactiveReadStream).isNotNull();

    }

    @Test
    public void vertexFileTest(){
        FileSystem fs = vertx.fileSystem();

        Future<FileProps> future = fs.props("/my_file.txt");

        future.onComplete((AsyncResult<FileProps> ar) -> {
            if (ar.succeeded()) {
                FileProps props = ar.result();
                System.out.println("File size = " + props.size());
            } else {
                System.out.println("Failure: " + ar.cause().getMessage());
            }
            assertThat(fs.props("my_file.txt"));
        });

    }

    @Test
    public void vertxTestRequest() {
        vertx.createHttpServer().requestHandler(req -> req.response().end("Hello Brian!")).listen(8080);
    }


}


















