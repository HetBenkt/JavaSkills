/**
 * The Controller implementation of the MVC Calculator
 * Handles the button clicks and gets/sets data in the View
 */
package nl.bos.calculator.impl;

import static nl.bos.calculator.ICalcContants.BUTTONS;
import static nl.bos.calculator.ICalcContants.STR_EMPTY;
import static nl.bos.calculator.ICalcContants.STR_MINUS;
import static nl.bos.calculator.ICalcContants.STR_PERIOD;
import static nl.bos.calculator.ICalcContants.STR_ZERO;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * 
 * @author bosa
 *
 */
@SuppressWarnings("rawtypes")
public class CalcController implements EventHandler {
	private CalcView calcView;
	private CalcModel calcModel;
	private boolean resetOnNextClick = false;
	private String lastMathSelected = "";
	private String lastCalcInput = "";

	/**
	 * Contructor where the View and Model are passed to the Controller
	 * @param calcView the calculator View
	 * @param calcModel the calculator Model
	 */
	public CalcController(CalcView calcView, CalcModel calcModel) {
		calcView.addCalcHandler(this);
		this.calcView = calcView;
		this.calcModel = calcModel;
	}

	@Override
	public void handle(Event e) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				if (e.getSource() == BUTTONS[j][i]) {
					// System.out.println(BUTTONS[j][i].getText() + "[" + j +
					// ", " + i + "]");
					// CE
					if (e.getSource() == BUTTONS[0][0]) {
						calcView.setNumberInput(STR_ZERO);
					}
					// C
					else if (e.getSource() == BUTTONS[0][1]) {
						calcView.setNumberInput(STR_ZERO);
						calcView.setCalcInput(STR_EMPTY);
					}
					// .
					else if (e.getSource() == BUTTONS[4][2]) {
						if (!resetOnNextClick) {
							if (!calcView.getNumberInput().contains(STR_PERIOD))
								calcView.setNumberInput(calcView
										.getNumberInput()
										+ BUTTONS[j][i].getText());
						} else {
							calcView.setNumberInput(STR_ZERO
									+ BUTTONS[j][i].getText());
							resetOnNextClick = false;
						}
					}
					// ±
					else if (e.getSource() == BUTTONS[4][0]) {
						negateNumberInput();
					}
					// ←
					else if (e.getSource() == BUTTONS[0][2]) {
						if (!resetOnNextClick) {
							backspaceNumberInput();
						}
					}
					// ÷ or x or - or +
					else if (e.getSource() == BUTTONS[0][3]
							|| e.getSource() == BUTTONS[1][3]
							|| e.getSource() == BUTTONS[2][3]
							|| e.getSource() == BUTTONS[3][3]) {
						calcView.setCalcInput(calcView.getNumberInput() + " "
								+ BUTTONS[j][i].getText());
						resetOnNextClick = true;
						lastMathSelected = BUTTONS[j][i].getText();
						lastCalcInput = calcView.getNumberInput();
					}
					// =
					else if (e.getSource() == BUTTONS[4][3]) {
						calcModel.calculateValue(calcView.getNumberInput(),
								lastCalcInput, lastMathSelected);
						calcView.setNumberInput(calcModel.getCalculationValue());
						calcView.setCalcInput(STR_EMPTY);
						resetOnNextClick = true;
					}
					// Numbers
					else {
						if (resetOnNextClick) {
							calcView.setNumberInput(STR_ZERO);
							resetOnNextClick = false;
						}
						if (calcView.getNumberInput().equals(STR_ZERO)) {
							calcView.setNumberInput(STR_EMPTY);
						}
						calcView.setNumberInput(calcView.getNumberInput()
								+ BUTTONS[j][i].getText());
					}
				}
			}
		}
	}

	/**
	 * Negate the last input value 
	 * Extra checks: If already negated or if a 0 value
	 */
	private void negateNumberInput() {
		if (!calcView.getNumberInput().equals(STR_ZERO)) {
			if (!calcView.getNumberInput().startsWith(STR_MINUS))
				calcView.setNumberInput(STR_MINUS + calcView.getNumberInput());
			else
				calcView.setNumberInput(calcView.getNumberInput().substring(1,
						calcView.getNumberInput().length()));
		}
	}

	/**
	 * Correct the last given input with a backspace
	 * Extra checks: If there is only 1 (negated) diget set to zero
	 */
	private void backspaceNumberInput() {
		if (calcView.getNumberInput().length() == 1
				|| (calcView.getNumberInput().length() == 2 && calcView
						.getNumberInput().startsWith(STR_MINUS)))
			calcView.setNumberInput(STR_ZERO);
		else
			calcView.setNumberInput(calcView.getNumberInput().substring(0,
					calcView.getNumberInput().length() - 1));
	}
}
