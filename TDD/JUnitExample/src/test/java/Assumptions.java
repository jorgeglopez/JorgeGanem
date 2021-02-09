import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class Assumptions {

    @ParameterizedTest
    @ValueSource(ints = {1, -10, 4, 8})
    public void testWithoutAssume(int source) {
        try {
            Thread.sleep(source);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, -10, 4, 8})
    public void testWithAssume(int source) {
        try {
            assumeTrue(source >= 0);
            Thread.sleep(source);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
