package nl.bos;

import static nl.bos.IConstants.CHF;

class Franc extends Money {

    Franc(int amount, String currency) {
        super(amount, currency);
    }

    static Money getFranc(int amount) {
        return new Money(amount, CHF);
    }
}