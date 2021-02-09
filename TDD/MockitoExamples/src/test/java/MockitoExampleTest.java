import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import usecases.Calculator;
import usecases.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MockitoExampleTest {
    Person person;

    @BeforeAll
    public void beforeAll(){
        person = new Person("JORGE", 31);
    }

    @Test
    public void playTest(){
       Person personMock = Mockito.spy(person);
       Mockito.doReturn(true)
               .when(personMock)
               .runInGround("ground");

       assertEquals(true, personMock.isPlay());
    }

    @Test
    public void correctSumTest(){
        Calculator calculatorMock = Mockito.mock(Calculator.class);
        Mockito.when(calculatorMock.add(2,3)).thenReturn(6);
        assertEquals(6, calculatorMock.add(2,3));
    }
}
