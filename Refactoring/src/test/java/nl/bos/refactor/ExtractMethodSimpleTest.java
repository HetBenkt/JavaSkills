package nl.bos.refactor;

import org.junit.jupiter.api.Test;

class ExtractMethodSimpleTest {

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
}