package nl.bos;

class Bank {
    Money reduce(IExpression source, String to) {
        return source.reduce(to);
    }
}
