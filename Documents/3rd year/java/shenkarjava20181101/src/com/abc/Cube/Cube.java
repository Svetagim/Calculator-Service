package com.abc.Cube;

public class Cube {
    private double length=10;

    public Cube(double length){this.length=length;}
    public void setLength(double length){this.length=length;}
    public double getLength(){return this.length;}
    public double getVolume(){return this.length*this.length*this.length;}

}
