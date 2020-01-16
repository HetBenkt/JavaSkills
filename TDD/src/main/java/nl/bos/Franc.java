package nl.bos;

class Franc extends Money {

    Franc(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int multiplier) {
        return Money.getFranc(amount * multiplier);
    }
}