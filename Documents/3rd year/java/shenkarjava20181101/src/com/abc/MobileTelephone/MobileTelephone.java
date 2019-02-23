package com.abc.MobileTelephone;

import java.awt.*;


public class MobileTelephone {
    private Owner owner;
    private Color color;
    private java.lang.String number;
    private java.lang.String model;

    @Override
    public String toString() {
        return "MobileTelephone{" +
                "owner=" + owner +
                ", color=" + color +
                ", number='" + number + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Owner getOwner() {
        return owner;
    }

    public Color getColor() {
        return color;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public MobileTelephone(Owner owner, Color color, String number, String model) {
        this.owner = owner;
        this.color = color;
        this.number = number;
        this.model = model;
    }
}
