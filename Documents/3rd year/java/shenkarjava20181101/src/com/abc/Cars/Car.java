package com.abc.Cars;

import java.awt.*;

public class Car {
    private long id;
    private String brand;
    private String model;
    private Color color;
    private Engine engine;

    public Car(long id, String brand, String model, Color color, Engine engine){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.engine = engine;
    }
    public Car(long id, String brand, String model, Color color){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }
    public long getId(){return this.id;}
    public String getBrand(){return this.brand;}
    public String getModel(){return this.model;}
    public Color getColor(){return this.color;}
    public Engine getEngine(){return this.engine;}
    public void setColor(Color color){this.color = color;}
    public void setEngine(Engine engine){this.engine = engine;}
}
