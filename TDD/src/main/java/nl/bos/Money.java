package nl.bos;

abstract class Money {
    int amount;

    static Money getDollar(int amount) {
        return new Dollar(amount);
    }

    static Franc getFranc(int amount) {
        return new Franc(amount);
    }

    private int getAmount() {
        return amount;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.getAmount() && getClass().equals(money.getClass());
    }

    abstract Money times(int multiplier);
}
