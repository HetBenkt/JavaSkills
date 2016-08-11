package nl.bos.calculator;

import javafx.scene.control.Button;

public interface ICalcContants {
	public final static int APP_WIDTH = 360;
	public final static int APP_HEIGHT = 480;
	public final static String APP_TITLE = "Calculator";
	public final static String CSS_STYLESHEET = "CalcStyle.css";
	public final static String STR_EMPTY = "";
	public final static String STR_ZERO = "0";
	public final static String STR_PERIOD = ".";
	public final static String STR_MINUS = "-";
	public final static Button[][] BUTTONS = {
			{ new Button("CE"), new Button("C"), new Button("←"),
					new Button("÷") },
			{ new Button("7"), new Button("8"), new Button("9"),
					new Button("x") },
			{ new Button("4"), new Button("5"), new Button("6"),
					new Button("-") },
			{ new Button("1"), new Button("2"), new Button("3"),
					new Button("+") },
			{ new Button("±"), new Button("0"), new Button("."),
					new Button("=") } };
}
