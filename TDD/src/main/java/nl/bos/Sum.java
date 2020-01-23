package nl.bos;

class Sum implements IExpression {
    private Money augend;
    private Money addend;

    Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    Money getAugend() {
        return augend;
    }

    Money getAddend() {
        return addend;
    }

    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank, to).getAmount() + addend.reduce(bank, to).getAmount();
        return new Money(amount, to);
    }
}
