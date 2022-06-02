package nl.bos.refactor;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class RefactorTests {

    @Test
    void printOwingTest() {
        new ExtractMethodSimple().printOwing();
    }

    @Test
    void printOwingVariablesTest() {
        new ExtractMethodVariables().printOwing();
    }

    @Test
    void getPriceTest() {
        new ReplaceTempWithQuery().getPrice();
    }

    @Test
    void detectionTest() {
        new IntroduceExplainingVariable().detection();
    }

    @Test
    void calculationTest() {
        new SplitTempVariable().calculate();
    }

    @Test
    void discountTest() {
        new RemoveAssignmentsToParameters().discount(10);
    }

    @Test
    void foundPersonTest() {
        List<String> names = Arrays.asList("John", "Mike");
        new SubstituteAlgorithm().foundPerson(names.toArray(new String[0]));
    }
}