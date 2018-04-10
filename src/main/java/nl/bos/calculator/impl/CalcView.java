/**
 * The View implementation of the MVC Calculator
 * Based on JavaFX a GUI is created
 */
package nl.bos.calculator.impl;

import static nl.bos.calculator.ICalcContants.BUTTONS;
import static nl.bos.calculator.ICalcContants.CSS_STYLESHEET;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author bosa
 *
 */
public class CalcView extends Stage {
	private TextField numberInput = new TextField("0");
	private TextField calcInput = new TextField("");
	
	public void setNumberInput(String numberInput) {
		this.numberInput.setText(numberInput);
	}
	
	public String getNumberInput() {
		return this.numberInput.getText();
	}
	
	public void setCalcInput(String calcInput) {
		this.calcInput.setText(calcInput);
	}
	
	public String getCalcInput() {
		return this.calcInput.getText();
	}

	/**
	 * Constructor for the View
	 * @param title of the application window
	 * @param width of the application window
	 * @param height of the application window
	 */
	public CalcView(String title, int width, int height) {

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		calcInput.setEditable(false);
		//calcInput.setAlignment(Pos.BASELINE_RIGHT);
		numberInput.setEditable(false);
		//numberInput.setAlignment(Pos.BASELINE_RIGHT);
		grid.add(calcInput, 0, 0, 4, 1);
		grid.add(numberInput, 0, 1, 4, 1);

		VBox vBox = new VBox();
		vBox.setPrefWidth(75);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				BUTTONS[j][i].setMinWidth(vBox.getPrefWidth());
				grid.add(BUTTONS[j][i], i, j + 2);
			}
		}

		Scene scene = new Scene(grid, width, height);

		this.setTitle(title);
		this.setScene(scene);
		scene.getStylesheets().add(CalcView.class.getResource(CSS_STYLESHEET).toExternalForm());
	}

	/**
	 * Sets the onAction handler for all the buttons to the Controller
	 * @param calcController Calculator Controller from the MVC
	 */
	@SuppressWarnings("unchecked")
	public void addCalcHandler(CalcController calcController) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				BUTTONS[j][i].setOnAction(calcController);
			}
		}
	}
}
