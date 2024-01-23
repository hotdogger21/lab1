import java.awt.*;

public class Scania extends Car{


    private int platformangle;


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
            platformangle = Math.max(0, platformangle - a);
    }
}
