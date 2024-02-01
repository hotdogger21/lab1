import java.awt.*;

abstract class Truck extends Car{

    private final boolean hasRamp;



    protected Platform platform = null;

    public Truck(int nrDoor, double enginePower, Color color, String modelName){
        super(nrDoor, enginePower, color, modelName);
        this.hasRamp = true; // assume all trucks got platforms atm.
        this.platform = new Platform(this);
        platform.rampOpen = false;
    }

    @Override
    public void gas(double amount){
        if (amount < 0){
            throw new RuntimeException("no negative amounts!!!");
        }
        else if (hasRamp && platform.rampOpen) {
            throw new RuntimeException("no driving when the platform is raised!");
        }
        else {
            incrementSpeed(Math.min(1, amount));
            currentSpeed = Math.min(enginePower, currentSpeed);
        }
    }

}
