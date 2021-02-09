import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    private final Persona persona1 = new Persona("JORGE", "GANEM");
    private final Calculator calculator = new Calculator();

    @Test
    public void standardAssertions(){
        assertEquals(5, calculator.add(3,2));
        assertEquals(6, calculator.multiply(3,2),
                "El mensaje de falla opcional es el ultimo parametro");
        assertTrue('a' < 'b', () -> "Este es un mensaje"
                + " de prueba");
    }

    @Test
    public void groupedAssertions() {
        assertAll(
                "persona",
                () -> assertEquals("JORGE", persona1.getFirstName()),
                () -> assertEquals("GANEM", persona1.getLastName())
        );
    }

    @Test
    public void dependentAssertions() {
        assertAll(
                () -> {
                    String firstName = persona1.getFirstName();
                    assertNotNull(firstName);

                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("L"))
                    );
                },
                () -> {
                    String lastName = persona1.getLastName();
                    assertNotNull(lastName);

                    assertAll("Last name",
                            () -> assertTrue(lastName.startsWith("G")),
                            () -> assertTrue(lastName.endsWith("M"))
                    );
                }
        );
    }

    @Test
    public void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class,
                                            () -> calculator.divide(2, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    public void timeOutNotExceeded() {
        assertTimeout(Duration.ofMinutes(1), () -> {

        });
    }

    @Test
    public void timeOutNotExceededWithResult() {
        String currentResult = assertTimeout(Duration.ofMinutes(1), () -> {
            return "Esto es un resultado.";
        });

        assertEquals("Esto es un resultado.", currentResult);
    }

    @Test
    public void timeOutNotExceededWithMethod() {
        String currentName = assertTimeout(Duration.ofMinutes(1), AssertionsTest::getName);

        assertEquals("DANIEL", currentName);
    }

    private static String getName() {
        return "DANIEL";
    }

    @Test
    public void timeOutExceeded() {
        assertTimeout(Duration.ofMillis(10), () -> {
            Thread.sleep(100);
        });
    }
}
