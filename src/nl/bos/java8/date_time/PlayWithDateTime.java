/**
 * http://www.tutorialspoint.com/java8/java8_datetime_api.htm
 */
package nl.bos.java8.date_time;

import static nl.bos.java8.common.IConstants.STR_DATE_FORMAT;
import static nl.bos.java8.common.IConstants.STR_END;
import static nl.bos.java8.common.IConstants.STR_START;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author bosa
 *
 */
public class PlayWithDateTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(STR_START);

		// Local Data-Time API
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.toLocalDate() + " " + now.toLocalTime());
		System.out.println(String.format(STR_DATE_FORMAT, now.getDayOfMonth(),
				now.getMonth(), now.getYear(), now.getHour(), now.getMinute(),
				now.getSecond()));

		// Zoned Date-Time API
		ZonedDateTime date = ZonedDateTime.now();
		System.out.println(date);
		ZoneId id = ZoneId.of("Asia/Karachi");
		System.out.println(id);
		System.out.println(ZoneId.systemDefault());

		// Chrono Units Enum
		LocalDate today = LocalDate.now(ZoneId.systemDefault());
		System.out.println("Next week: " + today.plus(1, ChronoUnit.WEEKS));
		System.out.println("Next month: " + today.plus(1, ChronoUnit.MONTHS));
		System.out.println("Next year: " + today.plus(1, ChronoUnit.YEARS));
		System.out.println("Next decade: " + today.plus(1, ChronoUnit.DECADES));

		// Period
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		Period period = Period.between(today, nextWeek);
		System.out.println(period);

		// Duration
		LocalTime time1 = LocalTime.now();
		Duration twoHours = Duration.ofHours(2);
		LocalTime time2 = time1.plus(twoHours);
		Duration duration = Duration.between(time1, time2);
		System.out.println(duration);

		// Clock display per second
		final ScheduledExecutorService executorService = Executors
				.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(PlayWithDateTime::displayClock, 0,
				1, TimeUnit.SECONDS);

		System.out.println(STR_END);
	}

	private static void displayClock() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("dd-MM-yyyy hh:mm:ss");
		System.out.println(now.format(formatter));
	}
}