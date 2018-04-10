/**
 * Implementaion for the calculator based on MVC pattern
 * http://www.newthinktank.com/2013/02/mvc-java-tutorial/
 */
package nl.bos.calculator;

import static nl.bos.calculator.ICalcContants.APP_HEIGHT;
import static nl.bos.calculator.ICalcContants.APP_TITLE;
import static nl.bos.calculator.ICalcContants.APP_WIDTH;
import javafx.application.Application;
import javafx.stage.Stage;
import nl.bos.calculator.impl.CalcController;
import nl.bos.calculator.impl.CalcModel;
import nl.bos.calculator.impl.CalcView;

/**
 * @author bosa
 *
 */
public class CalcMain extends Application {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		CalcView calcView = new CalcView(APP_TITLE, APP_WIDTH, APP_HEIGHT);
		CalcModel calcModel = new CalcModel();
		new CalcController(calcView, calcModel);

		primaryStage = calcView;
		primaryStage.show();
	}

}
