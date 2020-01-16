package nl.bos;

class Dollar extends Money {

    Dollar(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int multiplier) {
        return Money.getDollar(amount * multiplier);
    }
}