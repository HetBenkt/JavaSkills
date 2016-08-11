/**
 * 
 */
package nl.bos.tests;

import static org.junit.Assert.assertEquals;
import nl.bos.numbers.IBinaryDecimalConverter;

import org.junit.Test;

/**
 * @author bosa
 *
 */
public class TestBinaryDecimalConverter {
	
	@Test
	public void test() {
		String strExpected = "10001";
		String strActual = IBinaryDecimalConverter.getBinaryFromDecimal(17);
		assertEquals(strExpected, strActual);

		strExpected = "1001";
		strActual = IBinaryDecimalConverter.getBinaryFromDecimal(9);
		assertEquals(strExpected, strActual);
		
		strExpected = "10011101";
		strActual = IBinaryDecimalConverter.getBinaryFromDecimal(157);
		assertEquals(strExpected, strActual);

		int expected = 157;
		int actual = IBinaryDecimalConverter.getDecimalFromBinary("10011101");
		assertEquals(expected, actual);

		expected = 8;
		actual = IBinaryDecimalConverter.getDecimalFromBinary("1000");
		assertEquals(expected, actual);

		expected = 9;
		actual = IBinaryDecimalConverter.getDecimalFromBinary("1001");
		assertEquals(expected, actual);

	}
}
