package com.abc.Cars;
import java.awt.*;

public class CarDemo
{
    public static void main(String[] args)
    {
//Creating an object that represents a car engine made by Ford
        Engine commonEngine = new Engine(2000,160);
//Creating an object that represents a Tayata Mondex car
        Car myCar = new Car(1234,"Mondox","Model",Color.WHITE,commonEngine);
//Printing out to the screen the details of the current engine our car
        System.out.print("Our car's engine (before the upgrade): ");
        System.out.println(myCar.getEngine());
//Following our wish to upgrade our car we choose to set a new engine. A more sportive one.
        Engine sportEngine = new Engine(4000,260);
        myCar.setEngine(sportEngine);
//Printing out to the screen the details of the new engine
        System.out.print("Our car's engine (after the upgrade): ");
        System.out.println(myCar.getEngine());
    }
}