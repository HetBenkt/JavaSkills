package nl.bos;

class Money {
    int amount;

    private int getAmount() {
        return amount;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.getAmount();
    }
}
