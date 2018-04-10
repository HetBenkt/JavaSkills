/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_CHAT_MESSAGE;

import java.util.Date;
/**
 * @author bosa
 *
 */
public class ChatRoom {
	public static void showMessage(User user, String message) {
		System.out.println(String.format(STR_OUTPUT_CHAT_MESSAGE, new Date(), user.getName(), message));
	}
}
