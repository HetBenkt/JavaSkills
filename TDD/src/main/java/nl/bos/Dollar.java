package nl.bos;

class Dollar extends Money {

    Dollar(int amount, String currency) {
        super(amount, currency);
    }

    static Money getDollar(int amount) {
        return new Money(amount, "USD");
    }
}