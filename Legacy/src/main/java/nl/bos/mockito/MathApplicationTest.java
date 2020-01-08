package nl.bos.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {
    @InjectMocks
    MathApplication mathApplication = new MathApplication();
    ICalculatorService calculatorService;

    @Before
    public void setUp() throws Exception {
        calculatorService = spy(Calculator.class);
        mathApplication.setCalculatorService(calculatorService);
    }

    @Test
    public void add() {
        when(calculatorService.add(10.0, 20.0)).thenReturn(30.0);
        when(calculatorService.substract(20.0, 10.0)).thenReturn(10.0);
        //doThrow(new RuntimeException("Add operation not implemented")).when(calculatorService).add(10.0, 20.0);
        when(calculatorService.add(20.0, 10.0)).thenAnswer((Answer<Double>) invocationOnMock -> {
            Object[] arguments = invocationOnMock.getArguments();
            Object mock = invocationOnMock.getMock();
            return 30.0;
        });

        assertEquals(mathApplication.add(10.0, 20.0), 30.0);
        reset(calculatorService);
        assertEquals(mathApplication.add(10.0, 20.0), 30.0);
        assertEquals(mathApplication.substract(20.0, 10.0), 10.0);

        verify(calculatorService, timeout(300).times(1)).add(10.0, 20.0);
        verify(calculatorService, times(1)).substract(20.0, 10.0);
        verify(calculatorService, never()).multiply(10.0, 20.0);
        verify(calculatorService, atLeast(1)).add(10.0, 20.0);

        InOrder inOrder = inOrder(calculatorService);
        inOrder.verify(calculatorService).add(10.0, 20.0);
        inOrder.verify(calculatorService).substract(20.0, 10.0);

        given(calculatorService.add(20.0, 10.0)).willReturn(30.0);
        double result = calculatorService.add(20.0, 10.0);
        Assertions.assertEquals(result, 30.0);
    }
}
