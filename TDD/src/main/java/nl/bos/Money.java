package nl.bos;

abstract class Money {
    int amount;
    String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money getDollar(int amount) {
        return new Dollar(amount, "USD");
    }

    static Franc getFranc(int amount) {
        return new Franc(amount, "CHF");
    }

    private int getAmount() {
        return amount;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.getAmount() && getClass().equals(money.getClass());
    }

    abstract Money times(int multiplier);

    String getCurrency() {
        return this.currency;
    }
}
