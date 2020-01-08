/**
 * The chain of responsibility pattern creates a chain of receiver objects for a request. This pattern decouples sender and receiver of a request based on type of request.
 * BEHAVIORAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.behavioural;

import nl.bos.design_patterns.impl.AbstractLogger;
import nl.bos.design_patterns.impl.ConsoleLogger;
import nl.bos.design_patterns.impl.ErrorLogger;
import nl.bos.design_patterns.impl.FileLogger;

import static nl.bos.design_patterns.IConstants.*;

/**
 * @author bosa
 *
 */
public class _ChainPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractLogger loggerChain = getChainOfLoggers();
		loggerChain.logMessage(LEVEL_INFO, STR_MSG_INFO);
		loggerChain.logMessage(LEVEL_DEBUG, STR_MSG_DEBUG);
		loggerChain.logMessage(LEVEL_ERROR, STR_MSG_ERROR);
	}

	private static AbstractLogger getChainOfLoggers() {
		AbstractLogger errorLogger = new ErrorLogger(LEVEL_ERROR);
		AbstractLogger fileLogger = new FileLogger(LEVEL_DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(LEVEL_INFO);

		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);

		return errorLogger;
	}
}
