package nl.bos.calc;

import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals(expected, actual, "Addition is invalid.");
    }

    @Test
    void addValidDecimalTest() {
        String expected = "2.5";
        String actual = calculator.add(1D, 1.5D);
        Assertions.assertEquals(expected, actual, "Addition is invalid.");
    }

    @Test
    void addInvalidTest() {
        String expected = "3";
        String actual = calculator.add(1D, 1D);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    void addInvalidDecimalTest() {
        String expected = "3.0";
        String actual = calculator.add(1D, 1.5D);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    void subtractValidTest() {
        String expected = "1";
        String actual = calculator.subtract(2D, 1D);
        Assertions.assertEquals(expected, actual, "Subtraction is invalid");
    }

    @Test
    void subtractValidDecimalTest() {
        String expected = "1.5";
        String actual = calculator.subtract(2D, 0.5D);
        Assertions.assertEquals(expected, actual, "Subtraction is invalid");
    }

    @Test
    void subtractInValidTest() {
        String expected = "1";
        String actual = calculator.subtract(3D, 1D);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    void subtractInValidDecimalTest() {
        String expected = "1.5";
        String actual = calculator.subtract(3D, 0.5D);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    void multiplyValidTest() {
        String expected = "1";
        String actual = calculator.multiply(1D, 1D);
        Assertions.assertEquals(expected, actual, "Multiplication is invalid");
    }

    @Test
    void multiplyValidDecimalTest() {
        String expected = "1.5";
        String actual = calculator.multiply(1D, 1.5D);
        Assertions.assertEquals(expected, actual, "Multiplication is invalid");
    }

    @Test
    void multiplyInvalidTest() {
        String expected = "1";
        String actual = calculator.multiply(2D, 1D);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    void multiplyInvalidDecimalTest() {
        String expected = "1.5";
        String actual = calculator.multiply(2D, 1.75D);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    void divideValidTest() {
        String expected = "1";
        String actual = calculator.divide(1D, 1D);
        Assertions.assertEquals(expected, actual, "Dividing is invalid");
    }

    @Test
    void divideValidDecimalTest() {
        String expected = "1.5";
        String actual = calculator.divide(3D, 2D);
        Assertions.assertEquals(expected, actual, "Dividing is invalid");
    }

    @Test
    void divideInvalidTest() {
        String expected = "2";
        String actual = calculator.divide(1D, 1D);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    void divideInvalidDecimalTest() {
        String expected = "2.5";
        String actual = calculator.divide(3D, 2D);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    void divideByZeroTest() {
        String expected = "Cannot divide by zero";
        String actual = calculator.divide(1D, 0D);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void divideByZeroDecimalTest() {
        String expected = "Cannot divide by zero";
        String actual = calculator.divide(1D, 0.0D);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void squareValidTest() {
        String expected = "16";
        String actual = calculator.square(4D);
        Assertions.assertEquals(expected, actual, "Square is invalid");
    }

    @Test
    void squareValidDecimalTest() {
        String expected = "20.25";
        String actual = calculator.square(4.5D);
        Assertions.assertEquals(expected, actual, "Square is invalid");
    }

    @Test
    void squareInvalidTest() {
        String expected = "12";
        String actual = calculator.square(4D);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    void squareInvalidDecimalTest() {
        String expected = "12.5";
        String actual = calculator.square(4.5D);
        Assertions.assertNotEquals(expected, actual);
    }

    @Disabled
    @Test
    void squareRootValidTest() {
        String expected = "4";
        String actual = calculator.squareRoot(16D);
        Assertions.assertEquals(expected, actual, "Square root is invalid");
    }

    @Disabled
    @Test
    void squareRootValidDecimalTest() {
        String expected = "4.5";
        String actual = calculator.squareRoot(20.25D);
        Assertions.assertEquals(expected, actual, "Square root is invalid");
    }

}
