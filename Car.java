import java.awt.*;

public class Car {
    private final int nrDoors; // Number of doors on the car
    protected final double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    public Car(int nrDoor, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoor;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        currentSpeed = 0;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }
    public double speedFactor(){
        return enginePower * 0.01;
    }
    public void incrementSpeed(double amount){
    }

    public void decrementSpeed(double amount){
    }
}
