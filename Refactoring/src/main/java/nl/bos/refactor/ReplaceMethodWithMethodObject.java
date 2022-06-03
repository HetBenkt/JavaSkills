package nl.bos.refactor;

import java.util.logging.Logger;

public class ReplaceMethodWithMethodObject {
    private static final Logger logger = Logger.getLogger(ReplaceMethodWithMethodObject.class.getName());

    public void makeOrder() {
        Order order = new Order();
        String outputPrice = String.valueOf(order.price());
        logger.info(outputPrice);
    }

    private static class Order {
        double price() {
            double primaryBasePrice = 3;
            double secondaryBasePrice = 2;
            double tertiaryBasePrice = 1;
            double computation;

            computation = (primaryBasePrice * secondaryBasePrice) - tertiaryBasePrice;

            return computation;
        }
    }
}

