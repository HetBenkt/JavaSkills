package nl.bos.calc;

public interface Calculator {
    String add(final double valueOne, final double valueTwo);

    String subtract(final double valueOne, final double valueTwo);

    String multiply(final double valueOne, final double valueTwo);

    String divide(final double valueOne, final double valueTwo);

    String square(final double value);

    String squareRoot(final double value);
}
