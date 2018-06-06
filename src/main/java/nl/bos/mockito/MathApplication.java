package nl.bos.mockito;

import lombok.Setter;

public class MathApplication {
    @Setter
    private ICalculatorService calculatorService;

    public double add(double in1, double in2) {
        return calculatorService.add(in1, in2);
    }

    public double substract(double in1, double in2) {
        return calculatorService.substract(in1, in2);
    }

    public double multiply(double in1, double in2) {
        return calculatorService.multiply(in1, in2);
    }

    public double divide(double in1, double in2) {
        return calculatorService.devide(in1, in2);
    }
}
