package nl.bos.calc;

public class CalculatorImpl implements Calculator {

    private static final String SUFFIX = ".0";

    @Override
    public String add(final double valueOne, final double valueTwo) {
        String result = String.valueOf(valueOne + valueTwo);

        if (result.endsWith(SUFFIX)) {
            return result.split(SUFFIX)[0];
        }
        return result;
    }

    @Override
    public String subtract(final double valueOne, final double valueTwo) {
        String result = String.valueOf(valueOne - valueTwo);

        if (result.endsWith(SUFFIX)) {
            return result.split(SUFFIX)[0];
        }
        return result;
    }

    @Override
    public String multiply(final double valueOne, final double valueTwo) {
        String result = String.valueOf(valueOne * valueTwo);

        if (result.endsWith(SUFFIX)) {
            return result.split(SUFFIX)[0];
        }
        return result;
    }

    @Override
    public String divide(final double valueOne, final double valueTwo) {
        if (valueTwo == 0D) {
            return "Cannot divide by zero";
        }

        String result = String.valueOf(valueOne / valueTwo);

        if (result.endsWith(SUFFIX)) {
            return result.split(SUFFIX)[0];
        }
        return result;
    }

    @Override
    public String square(final double value) {
        String result = String.valueOf(value * value);

        if (result.endsWith(SUFFIX)) {
            return result.split(SUFFIX)[0];
        }
        return result;
    }

    @Override
    public String squareRoot(final double value) {
        double resultCheck = value;
        for (int i = 1; i < value; i *= 2) {
            resultCheck = value / i;
            if (resultCheck == i) {
                break;
            }
        }

        String result = String.valueOf(resultCheck);

        if (result.endsWith(SUFFIX)) {
            return result.split(SUFFIX)[0];
        }
        return result;
    }
}
