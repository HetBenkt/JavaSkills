package nl.bos.kyu5;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        ArrayList<Point> points = new ArrayList<>();
        int x = 0;
        int y = 0;
        int index = 0;

        for (String direction : arr) {
            index++;
            switch (direction) {
                case "NORTH":
                    x--;
                    break;
                case "SOUTH":
                    x++;
                    break;
                case "EAST":
                    y++;
                    break;
                case "WEST":
                    y--;
                    break;
                default:
                    break;
            }

            points.add(new Point(x, y));

            if (x == 0 && y == 0 && hasDuplicatePoint(index, points)) {
                for (int i = 0; i < index; i++) {
                    arr[i] = "";
                }
                arr = Arrays.stream(arr).filter(s -> !s.isEmpty()).toArray(String[]::new);
                index = 0;
                points.clear();
            }
        }

        return arr;
    }

    private static boolean hasDuplicatePoint(int index, ArrayList<Point> points) {
        if (index < 4) {
            return true;
        }

        ArrayList<Integer> hashCodes = new ArrayList<>();
        for (Point point : points) {
            if (!hashCodes.contains(point.hashCode())) {
                hashCodes.add(point.hashCode());
            }
        }

        return hashCodes.size() != points.size();
    }
}
