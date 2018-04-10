/**
 * http://www.tutorialspoint.com/java8/java8_base64.htm
 */
package nl.bos.java8.base64;

import static nl.bos.java8.common.IConstants.STR_CODE;
import static nl.bos.java8.common.IConstants.STR_HELLO_WORLD;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author bosa
 *
 */
public class PlayWithBase64 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Encode
			String strBase64Encoded = Base64.getEncoder().encodeToString(
					STR_HELLO_WORLD.getBytes(STR_CODE));
			System.out.println(strBase64Encoded);
			// Decode
			String strBase64Decoded = new String(Base64.getDecoder().decode(
					strBase64Encoded), STR_CODE);
			System.out.println(strBase64Decoded);
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
	}
}