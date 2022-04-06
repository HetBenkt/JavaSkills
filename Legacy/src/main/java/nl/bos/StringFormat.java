package nl.bos;

import java.text.MessageFormat;

import static java.lang.System.out;

public class StringFormat {

    public static void main(String[] args) {
        var value = "hello";

        out.println(String.format("%s world", value));
        out.printf("%s world%n", value);
        out.println(MessageFormat.format("{0} world", value));

        //Since Java 15!
        var message = """
                %s world
                """.formatted(value);

        out.println(message);
    }
}