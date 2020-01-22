package nl.bos;

public interface IExpression {
    Money reduce(Bank bank, String to);
}
