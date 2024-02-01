import java.awt.*;

public class Scania extends Truck{




    public Scania(){
        super(2, 100, Color.black, "Scania truck");
    }

    public void openRamp(){
        platform.raisePlatform();
    }

    public void closeRamp(){
        platform.lowerPlatform();
    }
}
