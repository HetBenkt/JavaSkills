package nl.bos;

class Money implements IExpression {
    int amount;
    String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money getDollar(int amount) {
        return new Dollar(amount, EConstants.USD.name());
    }

    static Money getFranc(int amount) {
        return new Franc(amount, EConstants.CHF.name());
    }

    int getAmount() {
        return amount;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.getAmount() && getCurrency().equals(money.getCurrency());
    }

    String getCurrency() {
        return this.currency;
    }

    @Override
    public String toString() {
        return String.format("%s %s", amount, currency);
    }

    IExpression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public IExpression plus(IExpression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}
