package com.abc.Cars;

/**
 * An object instantiated from this class represent a car engine.
 * @author Haim
 *
 */
public class Engine {
    /**
     * The engine's volume.
     */
    private double volume;

    /**
     * The engine's horse power
     */
    private int horsePower;

    /**
     * Constructs a new engine object.
     * @param volume the engine volume.
     * @param horsePower the engine horse power number.
     */
    public Engine(double volume, int horsePower)
    {
        super();
        this.volume = volume;
        this.horsePower = horsePower;
    }

    /**
     * Gets the engine's volume.
     * @return the engine's volume
     */
    public double getVolume()
    {
        return volume;
    }

    /**
     * Sets the engine's volume.
     * @param volume the engine's volume
     */
    public void setVolume(double volume)
    {
        this.volume = volume;
    }

    /**
     * Gets the engine's horsepower.
     * @return the engine's horsepower.
     */
    public int getHorsePower()
    {
        return horsePower;
    }

    /**
     * Sets the engine's horse power.
     * @param horsePower the engine's new horsepower.
     */
    public void setHorsePower(int horsePower)
    {
        this.horsePower = horsePower;
    }

    public String toString()
    {
        return "["+volume+"cc , "+horsePower+"hp]";
    }
}

