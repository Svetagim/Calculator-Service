package com.abc.ParallelLines;

class Line2D
{
    Point2D first;
    Point2D second;
    Line2D(Point2D p1, Point2D p2)
    {
        first = p1;
        second = p2;
    }
    void details()
    {
        System.out.println("(("+first.getX() + "," + first.getY() + ") , (" +
                second.getX() + "," + second.getY() + "))");
    }
    boolean isParallel(Line2D otherLine)
    {
        if (first.getY()/first.getX() == second.getY()/second.getX())
            return true;
        return false;

    }
    double length()
    {
        return Math.cbrt(Math.pow(second.getY()-first.getY(),2)+Math.pow(second.getX()-first.getX(),2));
    }
}