import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Deque;
import java.util.ArrayDeque;

public class transport extends Truck{

    Deque<Car> carStack;

    public transport(){
        super(2, 90, Color.green, "car transporter");
        carStack = new ArrayDeque<>();
        platform.raisePlatform(); // close ramp
    }

    public void openRamp(){
        platform.raisePlatform();
    }

    public void closeRamp(){
        platform.lowerPlatform();
    }

    public void loadCar(Car a){
        if (platform.getRampOpen() && a.position.distance(this.position) <= 5){
            carStack.push(a);
            a.position = this.position;
        }
    }

    public Car unloadCar(){
        if (!platform.getRampOpen() || carStack.isEmpty()){
            throw new RuntimeException("transport is either empty or ramp is closed!!!");
        }
        Car car = carStack.pop();
        car.position = new Point2D.Double(this.position.x, this.position.y);
        return car;
    }

    @Override
    public void move() {
        if (direction == 1){
            this.position.y += currentSpeed;
        }
        if (direction == 3){
            this.position.y -= currentSpeed;
        }
        if (direction == 2){
            this.position.x += currentSpeed;
        }
        if (direction == 4){
            this.position.x -= currentSpeed;
        }


    }


}
