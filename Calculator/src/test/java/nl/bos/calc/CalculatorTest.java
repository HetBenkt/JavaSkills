package nl.bos.calc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new CalculatorImpl();
    }

    @Test
    void addValidTest() {
        String expected = "2";
        String actual = calculator.add(1D, 1D);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void addValidDecimalTest() {
        String expected = "2.5";
        String actual = calculator.add(1D, 1.5D);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void addInvalidTest() {
        String expected = "3";
        String actual = calculator.add(1D, 1D);
        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void addInvalidDecimalTest() {
        String expected = "3.0";
        String actual = calculator.add(1D, 1.5D);
        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void subtractValidTest() {
        String expected = "1";
        String actual = calculator.subtract(2D, 1D);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void subtractValidDecimalTest() {
        String expected = "1.5";
        String actual = calculator.subtract(2D, 0.5D);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void subtractInValidTest() {
        String expected = "1";
        String actual = calculator.subtract(3D, 1D);
        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void subtractInValidDecimalTest() {
        String expected = "1.5";
        String actual = calculator.subtract(3D, 0.5D);
        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void multiplyValidTest() {
        String expected = "1";
        String actual = calculator.multiply(1D, 1D);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void multiplyValidDecimalTest() {
        String expected = "1.5";
        String actual = calculator.multiply(1D, 1.5D);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void multiplyInvalidTest() {
        String expected = "1";
        String actual = calculator.multiply(2D, 1D);
        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void multiplyInvalidDecimalTest() {
        String expected = "1.5";
        String actual = calculator.multiply(2D, 1.75D);
        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void divideValidTest() {
        String expected = "1";
        String actual = calculator.divide(1D, 1D);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void divideValidDecimalTest() {
        String expected = "1.5";
        String actual = calculator.divide(3D, 2D);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void divideInvalidTest() {
        String expected = "2";
        String actual = calculator.divide(1D, 1D);
        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void divideInvalidDecimalTest() {
        String expected = "2.5";
        String actual = calculator.divide(3D, 2D);
        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void divideByZeroTest() {
        String expected = "Cannot divide by zero";
        String actual = calculator.divide(1D, 0D);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void divideByZeroDecimalTest() {
        String expected = "Cannot divide by zero";
        String actual = calculator.divide(1D, 0.0D);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void squareValidTest() {
        String expected = "16";
        String actual = calculator.square(4D);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void squareValidDecimalTest() {
        String expected = "20.25";
        String actual = calculator.square(4.5D);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void squareInvalidTest() {
        String expected = "12";
        String actual = calculator.square(4D);
        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void squareInvalidDecimalTest() {
        String expected = "12.5";
        String actual = calculator.square(4.5D);
        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Disabled("TODO")
    @Test
    void squareRootValidTest() {
        String expected = "4";
        String actual = calculator.squareRoot(16D);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Disabled("TODO")
    @Test
    void squareRootValidDecimalTest() {
        String expected = "4.5";
        String actual = calculator.squareRoot(20.25D);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
