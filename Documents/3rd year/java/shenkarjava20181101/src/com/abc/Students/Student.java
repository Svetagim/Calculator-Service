package com.abc.Students;

public class Student {
    private String name;
    private long id;
    private double average;

    public Student(String name, long id, double average){
        this.name = name;
        this.id = id;
        this.average = average;
    }
    public long getId(){return this.id;}
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
    public double getAverage() {return this.average;}
    public void setAverage(double average){this.average = average;}

    @Override
    public String toString() {
        return this.name;
    }
}
