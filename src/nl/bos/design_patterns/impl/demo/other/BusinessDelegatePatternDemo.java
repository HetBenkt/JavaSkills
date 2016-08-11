/**
 * Business Delegate Pattern is used to decouple presentation tier and business tier. It is basically use to reduce communication or remote lookup functionality to business tier code in presentation tier code.
 * OTHER
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.other;

import static nl.bos.design_patterns.IConstants.STR_EJB;
import static nl.bos.design_patterns.IConstants.STR_JMS;

import nl.bos.design_patterns.impl.BusinessDelegate;
import nl.bos.design_patterns.impl.Client;

/**
 * @author bosa
 *
 */
public class BusinessDelegatePatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BusinessDelegate businessDelegate = new BusinessDelegate();
		businessDelegate.setServiceType(STR_EJB);

		Client client = new Client(businessDelegate);
		client.doTask();

		businessDelegate.setServiceType(STR_JMS);
		client.doTask();
	}
}