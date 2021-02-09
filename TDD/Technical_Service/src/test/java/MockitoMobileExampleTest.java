import com.sun.jmx.snmp.SnmpSecurityException;
import controller.Diagnostic;
import controller.Mobile;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockitoMobileExampleTest {
    Mobile mobile;
    Diagnostic diagnostic;

    @BeforeAll
    public void beforeAll(){
        mobile =new Mobile(1215151,"Samsung","S10 PLUS","Error General");
    }

    @Test
    public void ValidatedMobile(){
        Mobile MobileMock = Mockito.spy(mobile);
        Mockito.doReturn(true)
                .when(MobileMock)
                .validateMarca("Samsung");
        assertEquals(true, MobileMock.isGood());
    }

    @Test
    public void createDiagnosticTest(){
        Mobile MobileMock = Mockito.spy(mobile);
        Mockito.doReturn(true)
                .when(MobileMock)
                .validateMarca("Samsung");
        assertEquals(true, MobileMock.isGood());

        }

}

