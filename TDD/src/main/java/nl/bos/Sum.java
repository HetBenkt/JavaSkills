package nl.bos;

class Sum implements IExpression {
    private IExpression augend;
    private IExpression addend;

    Sum(IExpression augend, IExpression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    IExpression getAugend() {
        return augend;
    }

    IExpression getAddend() {
        return addend;
    }

    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank, to).getAmount() + addend.reduce(bank, to).getAmount();
        return new Money(amount, to);
    }

    @Override
    public IExpression plus(IExpression addend) {
        return null;
    }
}
