import java.awt.*;

public class Scania extends Car{


    protected int platformangle;


    public Scania(){
        super(2, 100, Color.black, "Scania truck");
        this.platformangle = 0;
    }

    public void raisePlatform(int a){
        if (currentSpeed > 0){
            throw new RuntimeException("truck must be still before raising platform!");
        }
        else {
            platformangle = Math.min(70, platformangle + a);
        }
    }

    public void lowerPlatform(int a){
            //lastbilen bör inte ha någon fart när vi sänker flaket
            //om vi kollar om flaket har någon vinkel större än 0 innan metoder som ändrar fart körs
        if (platformangle > 0){
            platformangle = Math.max(0, platformangle - a);
        }
    }

    //gas metod som kollar rampen innan farten ökar
    public void gas(double amount){
        if (amount < 0){
            //do nothing
        }
        else if (platformangle > 0) {
            // do nothing
        }
        else {
            incrementSpeed(Math.min(1, amount));
            currentSpeed = Math.min(enginePower, currentSpeed);
        }
    }
}
