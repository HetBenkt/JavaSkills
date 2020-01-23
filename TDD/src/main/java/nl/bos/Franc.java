package nl.bos;

class Franc extends Money {

    Franc(int amount, String currency) {
        super(amount, currency);
    }

    static Money getFranc(int amount) {
        return new Money(amount, EConstants.CHF.name());
    }
}