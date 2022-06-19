package nl.bos.calc;

public class CalculatorImpl implements Calculator {

    private static final String SUFFIX = ".0";


    @Override
    public String add(final double valueOne, final double valueTwo) {
        String addResult = String.valueOf(valueOne + valueTwo);

        if (addResult.endsWith(SUFFIX)) {
            return addResult.split(SUFFIX)[0];
        }
        return addResult;
    }

    @Override
    public String subtract(final double valueOne, final double valueTwo) {
        String addResult = String.valueOf(valueOne - valueTwo);

        if (addResult.endsWith(SUFFIX)) {
            return addResult.split(SUFFIX)[0];
        }
        return addResult;
    }

    @Override
    public String multiply(final double valueOne, final double valueTwo) {
        String addResult = String.valueOf(valueOne * valueTwo);

        if (addResult.endsWith(SUFFIX)) {
            return addResult.split(SUFFIX)[0];
        }
        return addResult;
    }

    @Override
    public String divide(final double valueOne, final double valueTwo) {
        if (valueTwo == 0D) {
            return "Cannot divide by zero";
        }

        String addResult = String.valueOf(valueOne / valueTwo);

        if (addResult.endsWith(SUFFIX)) {
            return addResult.split(SUFFIX)[0];
        }
        return addResult;
    }

    @Override
    public String square(final double value) {
        String addResult = String.valueOf(value * value);

        if (addResult.endsWith(SUFFIX)) {
            return addResult.split(SUFFIX)[0];
        }
        return addResult;
    }

    @Override
    public String squareRoot(final double value) {
        return null;
    }
}
