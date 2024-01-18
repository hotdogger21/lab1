import java.awt.*;

public class Car implements Movable{
    private final int nrDoors; // Number of doors on the car
    protected final double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    //movement saker
    private int direction;
    private double Xpos;
    private double Ypos;


    public Car(int nrDoor, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoor;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        currentSpeed = 0;
        stopEngine();

        // movement saker
        this.direction = 1;
        this.Xpos = 0;
        this.Ypos = 0;
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
        currentSpeed += amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed -= amount;
    }

    // movement saker
    @Override
    public void move() {
        if (direction == 1){
            this.Ypos += currentSpeed;
        }
        if (direction == 3){
            this.Ypos -= currentSpeed;
        }
        if (direction == 2){
            this.Xpos += currentSpeed;
        }
        if (direction ==4){
            this.Xpos -= currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        direction = (direction + 1) % 4;
    }

    @Override
    public void turnRight() {
        direction--;
        if (direction < 1){
            direction = 4;
        }
    }
}
