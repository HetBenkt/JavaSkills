/**
 * http://www.tutorialspoint.com/java8/java8_nashorn_java_script.htm
 * http://winterbe.com/posts/2014/04/05/java8-nashorn-tutorial/
 */
package nl.bos.java8.nashorn_js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;

import static nl.bos.java8.common.IConstants.*;

/**
 * @author bosa
 *
 */
public class PlayWithNashornJS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(STR_START);

		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine nashorn = sem.getEngineByName(STR_NASHORN);

		try {
			// Internal javascript
			System.out.println(STR_INTERNAL);
			nashorn.eval("print('" + STR_HELLO_WORLD + " [" + STR_NAMES[0]
					+ "]')");
			Integer result = (Integer) nashorn.eval("10 + 2");
			System.out.println(result);

			System.out.println("");

			// External Javascript
			System.out.println(STR_EXTERNAL);
			String path = new File("").getAbsolutePath();
			System.out.println(path);
			nashorn.eval(new FileReader(path));

			System.out.println("");

			// Call external JS functions
			Invocable invocable = (Invocable) nashorn;
			Object resultFun1 = invocable.invokeFunction("fun1", STR_NAMES[0]);
			System.out.println(resultFun1);
			System.out.println(resultFun1.getClass());

			System.out.println("");

			invocable.invokeFunction("fun2", new Date());
			invocable.invokeFunction("fun2", LocalDateTime.now());

		} catch (ScriptException | FileNotFoundException
				| NoSuchMethodException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(STR_END);
	}
}