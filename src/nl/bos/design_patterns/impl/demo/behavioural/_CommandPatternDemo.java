/**
 * A request is wrapped under an object as command and passed to invoker object. Invoker object looks for the appropriate object which can handle this command and passes the command to the corresponding object which executes the command.
 * BEHAVIORAL 
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.behavioural;

import static nl.bos.design_patterns.IConstants.STR_DUMMY;
import nl.bos.design_patterns.impl.Broker;
import nl.bos.design_patterns.impl.BuyStock;
import nl.bos.design_patterns.impl.SellStock;
import nl.bos.design_patterns.impl.Stock;

/**
 * @author bosa
 *
 */
public class _CommandPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stock abcStock = new Stock(STR_DUMMY, 10);

		BuyStock buyStockOrder = new BuyStock(abcStock);
		SellStock sellStockOrder = new SellStock(abcStock);

		Broker broker = new Broker();
		broker.takeOrder(buyStockOrder);
		broker.takeOrder(sellStockOrder);

		broker.placeOrders();
	}

}
