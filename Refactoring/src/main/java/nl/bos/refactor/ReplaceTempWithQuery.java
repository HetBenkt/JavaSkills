package nl.bos.refactor;

public class ReplaceTempWithQuery {
    private static final double QUANTITY = 10;
    private static final double ITEM_PRICE = 1.99;

    public double getPrice() {
        double basePrice = QUANTITY * ITEM_PRICE;

        if (basePrice > 1000) {
            return basePrice * 0.95;
        } else {
            return basePrice * 0.98;
        }
    }
}
