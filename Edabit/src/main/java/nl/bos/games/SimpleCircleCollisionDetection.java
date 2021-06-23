package nl.bos.games;

public class SimpleCircleCollisionDetection {
    public static boolean isCircleCollision(int[] c1, int[] c2) {
        int r1 = c1[0];
        int x1 = c1[1];
        int y1 = c1[2];
        int r2 = c2[0];
        int x2 = c2[1];
        int y2 = c2[2];

        double c1c2 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return c1c2 < r1 + r2;
    }
}
