package nl.bos.mockito;

public class Calculator implements ICalculatorService {
    @Override
    public double add(double in1, double in2) {
        return in1 + in2;
    }

    @Override
    public double substract(double in1, double in2) {
        return in1 - in2;
    }

    @Override
    public double multiply(double in1, double in2) {
        return in1 * in2;
    }

    @Override
    public double devide(double in1, double in2) {
        return in1 / in2;
    }
}
