package com.abc.ParallelLines;

class Point2D {
    private double x;
    private double y;

    Point2D(double xVal, double yVal) {
        x = xVal;
        y = yVal;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    void details() {
        System.out.println("(" + x + "," + y + ")");
    }
}