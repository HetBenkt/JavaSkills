/**
 * 
 */
package nl.bos.design_patterns;

/**
 * @author bosa
 *
 */
public interface IConstants {
	public final static String STR_OUTPUT_SHAPE = "Shape: %s";
	public final static String STR_OUTPUT_DRAW = "%s::draw()";
	public final static String STR_OUTPUT_FILL = "%s::fill()";
	public final static String STR_OUTPUT_ITEM = "\tItem: %s";
	public final static String STR_OUTPUT_PACKAGING = "\tPackaging: %s";
	public final static String STR_OUTPUT_PRICE = "\tPrice: %s";
	public final static String STR_OUTPUT_VEG_MEAL = "Veg Meal";
	public final static String STR_OUTPUT_NON_VEG_MEAL = "Non-Veg Meal";
	public final static String STR_OUTPUT_TOTAL_COSTS = "Total costs: %s" + "";
	public final static String STR_OUTPUT_MEDIA = "Play with %s. \tName: %s";
	public final static String STR_OUTPUT_NO_MEDIA = "Invalid media. %s format is not supported!";
	public final static String STR_OUTPUT_CIRLE = "Drawing Circle [color: %s, radius: %s, x: %s, y: %s]";
	public final static String STR_OUTPUT_PERSONS = "Person: [Name: %s, Gender: %s, Marital Status: %s]";
	public final static String STR_OUTPUT_EMPLOYEE = "Employee [Name: %s, dept: %s, salary: %s]";
	public final static String STR_OUTPUT_SHAPE_DATA = " -> [Color: %s, x: %s, y: %s, radius: %s";
	public final static String STR_OUTPUT_IMAGE = "Displaying %s";
	public final static String STR_OUTPUT_IMAGE_LOAD = "Loading %s";
	public final static String STR_OUTPUT_LOGGER = "Logging with %s -> %s";
	public final static String STR_OUTPUT_PROCESSING = "Processing task by invoking %s";
	public final static String STR_OUTPUT_STOCK = "Stock [Name: %s, Quality: %s] ";
	public final static String STR_OUTPUT_BUY = STR_OUTPUT_STOCK + "bought";
	public final static String STR_OUTPUT_SELL = STR_OUTPUT_STOCK + "sold";
	public final static String STR_OUTPUT_NAME = "Name: %s";
	public final static String STR_OUTPUT_EXECUTING = "Executing: %s";
	public final static String STR_OUTPUT_SERVICE_AVAILABLE = "Looking up and creating a new %s object";
	public final static String STR_OUTPUT_RETURN_CACHED = "Returning cached %s object";
	public final static String STR_OUTPUT_DATA = "Data: %s";
	public final static String STR_OUTPUT_CHAT_MESSAGE = "%s [%s] : %s";
	public final static String STR_OUTPUT_CURRENT_STATE = "Current state: %s";
	public final static String STR_OUTPUT_SAVED_STATE = "%s saved state: %s";
	public final static String STR_OUTPUT_NOT_AVAILABLE = "Not available in customer database";
	public final static String STR_OUTPUT_IS_AUTHENTIC = "User is authenticated successfully";
	public final static String STR_OUTPUT_PAGE_REQUEST = "Page requested: %s";
	public final static String STR_OUTPUT_STUDENT = "Student: \nName: %s\nRollNo: %s";
	public final static String STR_OUTPUT_NO_OBJECT = "No object found";
	public final static String STR_MSG_LEVEL = "This is a message in ";
	public final static String STR_MSG_INFO = STR_MSG_LEVEL + "INFO";
	public final static String STR_MSG_DEBUG = STR_MSG_LEVEL + "DEBUG";
	public final static String STR_MSG_ERROR = STR_MSG_LEVEL + "ERROR";
	public final static String STR_HELLO_WORLD = "Hello World!!";
	public final static String STR_TOMCAT = "TOMCAT";
	public final static String STR_JBOSS = "JBOSS";
	public final static String STR_DUMMY = "DUMMY";
	public final static String STR_STUDENT = "STUDENT";
	public final static String STR_HOME = "HOME";
	public final static String STR_EMPTY = "";
	public final static String STR_SPACE = " ";
	public final static String STR_SEPERATOR = "===========================";
	public final static String STR_SHAPE = "SHAPE";
	public final static String STR_COLOR = "COLOR";
	public final static String STR_WRAPPER = "Wrapper";
	public final static String STR_BOTTLE = "Bottle";
	public final static String STR_VEG_BURGER = "Veg Burger";
	public final static String STR_CHICKEN_BURGER = "Chicken Burger";
	public final static String STR_COKE = "Coke";
	public final static String STR_PEPSI = "Pepsi";
	public final static String STR_VLC = "vlc";
	public final static String STR_MP4 = "mp4";
	public final static String STR_MP3 = "mp3";
	public final static String STR_AVI = "avi";
	public final static String STR_FIVE = "5";
	public final static String STR_TEN = "10";
	public final static String STR_EJB = "EJB";
	public final static String STR_JMS = "JMS";
	public final static String STR_MALE = "MALE";
	public final static String STR_FEMALE = "FEMALE";
	public final static String STR_SINGLE = "SINGLE";
	public final static String STR_MARRIED = "MARRIED";
	public final static String STR_JOHN = "John";
	public final static String STR_ROBERT = "Robert";
	public final static String STR_JULIE = "Julie";
	public final static String STR_LORA = "Lora";
	public final static String STR_CEO = "CEO";
	public final static String STR_HEAD_SALES = "Head Sales";
	public final static String STR_HEAD_MARKETING = "Head Marketing";
	public final static String STR_SALES = "Sales";
	public final static String STR_MARKETING = "Marketing";
	public final static String STR_GAME = "Game";
	public final static String STR_GAME_FINISH = "%s "+STR_GAME+" Finished!";
	public final static String STR_GAME_INIT = "%s "+STR_GAME+" Initialized. Start playing";
	public final static String STR_GAME_START = "%s "+STR_GAME+" Started. Enjoy the game!";
	
	public final static String[] STR_COLORS = { "Red", "Green", "Blue",
			"White", "Black" };
	public final static String[] STR_NAMES = { STR_JOHN, STR_ROBERT, STR_JULIE,
			STR_LORA };
	public final static String[] STR_STATES = { "Draft", "Reviewed", "Approved",
		"Final" };

	public final static String STR_CIRCLE = "Circle";
	public final static String STR_RECTANGLE = "Rectangle";
	public final static String STR_SQUARE = "Square";
	public final static String[] STR_SHAPES = { STR_CIRCLE, STR_RECTANGLE,
			STR_SQUARE };

	public final static String STR_R = "Red";
	public final static String STR_G = "Green";
	public final static String STR_B = "Blue";

	public final static String CIRCLE_ID = "1";
	public final static String SQUARE_ID = "2";
	public final static String RECTANGLE_ID = "3";

	public final static float F_VEG_BURGER_PRICE = 25.0f;
	public final static float F_CHICKEN_BURGER_PRICE = 50.5f;
	public final static float F_COKE_PRICE = 35.0f;
	public final static float F_PEPSI_PRICE = 30.0f;

	public final static int LEVEL_TRACE = 6;
	public final static int LEVEL_DEBUG = 5;
	public final static int LEVEL_INFO = 4;
	public final static int LEVEL_WARN = 3;
	public final static int LEVEL_ERROR = 2;
	public final static int LEVEL_FATAL = 1;
}
