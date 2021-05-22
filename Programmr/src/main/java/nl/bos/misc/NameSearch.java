package nl.bos.misc;

import java.util.Scanner;

public class NameSearch {
    private static final String[] NAMES = {"harry", "michael", "will", "tom", "jackie"};
    private static final String[] SURNAMES = {"potter", "jackson", "smith", "cruise", "chan"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name:");
        String name = sc.next();

        String surname = getSurName(name);

        System.out.println("Full name of the celebraty is:");
        System.out.println(String.format("%s %s", name, surname));
    }

    public static String getSurName(String name) {
        for (int i = 0; i < NAMES.length; i++) {
            if (NAMES[i].equals(name)) {
                return SURNAMES[i];
            }
        }
        return null;
    }
}
