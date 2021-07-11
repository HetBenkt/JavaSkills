package nl.bos.arrays;

public class PerimeterOfTriangle {
    public static double perimeter(int[][] arr) {
        double a = pythagoreanTheorem(arr[0], arr[1]);
        double b = pythagoreanTheorem(arr[1], arr[2]);
        double c = pythagoreanTheorem(arr[2], arr[0]);
        return a + b + c;
    }

    private static double pythagoreanTheorem(int[] point1, int[] point2) {
        double difX = Math.abs(point1[0] - point2[0]);
        double difY = Math.abs(point1[1] - point2[1]);
        return Math.sqrt(Math.pow(difX, 2.0) + Math.pow(difY, 2.0));
    }
}
