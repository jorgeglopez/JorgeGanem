import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//ordena alfabeticamente
//@TestMethodOrder(MethodOrderer.MethodName.class)
//ordena dependiendo del display que se le asigne
//@TestMethodOrder(MethodOrderer.DisplayName.class)
//ordena de forma aleatoria
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
@IndicativeSentencesGeneration(separator = "->", generator = DisplayNameGenerator.Simple.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AnnotationsTest {

    @BeforeAll
    public static void initAll(){
        System.out.println("Me ejecuto antes de todos...");
    }

    @BeforeEach
    public void init(){
        System.out.println("Me ejecuto antes de cada metodo de prueba");
    }

    @Tag("Prioritary")
    @DisplayName("\uD83D\uDE00 Test 1")
    //@Test
    @Order(1)
    @RepeatedTest(value = 3, name = "{displayName} {currentRepetition} / {totalRepetitions}")
    public void succeedingTest(){
        System.out.println("Ejecuto test 1");
    }

    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    @Test
    @Order(2)
    //@Disabled("Por algo seria")
    public void succeedingTestOrder2(){
        System.out.println("Ejecuto test 2");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Me ejecuto despues de cada metodo de prueba");
    }

    @AfterAll
    public static void tearDownAll(){
        System.out.println("Me ejecuto despues de todo");
    }

    Calculator calculator = new Calculator();
    Palindromes palindromes = new Palindromes();

    @TestFactory
    public Collection<DynamicTest> dynamicTestFromCollection(){

        return Arrays.asList(
                DynamicTest.dynamicTest("TestDinamico1",
                        () -> assertTrue(palindromes.isPalindrome("madam"))),
                DynamicTest.dynamicTest("TestDinamico2",
                        () -> assertEquals(5, calculator.add(3, 2)))
        );
    }

    @TestFactory
    public Iterator<DynamicTest> dynamicTestFromIterator(){

        return Arrays.asList(
                DynamicTest.dynamicTest("TestDinamico3",
                        () -> assertTrue(palindromes.isPalindrome("madam"))),
                DynamicTest.dynamicTest("TestDinamico4",
                        () -> assertEquals(5, calculator.add(3, 2)))
        ).iterator();
    }

    @TestFactory
    public DynamicTest[] dynamicTestFromArray(){

        return new DynamicTest[]{
                DynamicTest.dynamicTest("TestDinamico5",
                        () -> assertTrue(palindromes.isPalindrome("madam"))),
                DynamicTest.dynamicTest("TestDinamico6",
                        () -> assertEquals(5, calculator.add(3, 2)))
        };
    }

    @TestFactory
    public Stream<DynamicTest> dynamicTestFromStreams(){

        return Stream.of(
                "mom", "madam", "dad", "radar"
        ).map(text -> DynamicTest.dynamicTest(text,
                () -> assertTrue(palindromes.isPalindrome(text))));
    }





}
