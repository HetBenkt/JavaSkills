package nl.bos.projecteuler;

import java.text.MessageFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class CountingSundays {
    public static void main(String[] args) {
        int counter = 0;
        for (int i = 1901; i <= 2000; i++) {
            for (int j = 1; j <= 12; j++) {
                LocalDate date = LocalDate.of(i, j, 1);
                System.out.println(MessageFormat.format("day {0} - month {1} - year {2} = {3}", date.getDayOfMonth(), date.getMonth(), date.getYear(), date.getDayOfWeek()));
                if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    counter++;
                }
            }
        }
        System.out.println(MessageFormat.format("{0}", counter));
    }
}
