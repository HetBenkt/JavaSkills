/**
 * 
 */
package nl.bos.tests;

import nl.bos.numbers.IChangeReturnProgram;
import nl.bos.numbers.impl.ChangeReturnProgram;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author bosa
 *
 */
public class TestChangeReturnProgram {
	private float costs;
	private float moneyAmount;
	private String expected;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		costs = 696.87f;
		moneyAmount = 2000.00f;
		expected = "500.0, 500.0, 200.0, 100.0, 2.0, 1.0, 0.1, 0.02, 0.01";
	}

	@Test
	public void testDisplayOutput() {
		IChangeReturnProgram iChangeReturnProgram = new ChangeReturnProgram();
		ChangeReturnProgram.setCosts(costs);
		ChangeReturnProgram.setMoneyAmount(moneyAmount);
		String actual = iChangeReturnProgram.getChangeMoney();
		assertEquals(expected, actual);
	}

}
