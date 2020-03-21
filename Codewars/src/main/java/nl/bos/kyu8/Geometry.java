package nl.bos.kyu8;

class Geometry {
    private Geometry() {
    }

    static double squareArea(double circularArc) {
        //perimeter = (2 * Pi) * radius
        //10 = 2 * 5
        //5 = 10 / 2
        //radius = perimeter / (2*Pi)

        double perimeterCircle = circularArc * 4;
        double radius = perimeterCircle / (2 * Math.PI);

        return Math.round(Math.pow(radius, 2.0) * 100.0) / 100.0; //round 2 values behind comma
    }
}