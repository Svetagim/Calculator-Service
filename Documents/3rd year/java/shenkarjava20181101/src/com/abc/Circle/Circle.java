package com.abc.Circle;


public class Circle
{
    private double radius;
    public Circle(double rad)
    {
        setRadius(rad);
    }
    public double getRadius()
    {
        return radius;
    }
    public void setRadius(double radius)
    {
        if(radius>0)
        {
            this.radius = radius;
        }
    }
    public double area()
    {
        return 3.14*radius*radius;
    }

    public double perimeter()
    {
        return 3.14*2*radius;
    }

    public void printDetails()
    {
        System.out.println("radius="+radius);
        System.out.println("area="+area());
        System.out.println("perimeter="+perimeter());
    }
}
