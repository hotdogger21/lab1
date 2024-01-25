import java.awt.*;
import java.util.Stack;

public class transport extends Truck{

    Stack<Car> carStack;
    Boolean rampOpen;

    public transport(){
        super(2, 90, Color.green, "car transporter", true);
        carStack = new Stack<>();
        rampOpen = false;
    }

    public void openRamp(){
        if (currentSpeed > 0){
            throw new RuntimeException("transporter must be still before lowering ramp");
        }
        else rampOpen = true;
    }

    public void closeRamp(){
        rampOpen = false;
    }

    public void loadCar(Car a){
        if (rampOpen && a.position.distance(this.position) <= 5){
            carStack.push(a);
            a.position.x = this.position.x;
            a.position.y = this.position.y;
        }
    }

    public Car unloadCar(){
        if (!rampOpen || carStack.isEmpty()){
            throw new RuntimeException("transport is either empty or ramp is closed!!!");
        }
        else return carStack.pop();
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

        if (!carStack.isEmpty()){
            for (Car a : carStack){
                a.position.x = this.position.x;
                a.position.y = this.position.y;
            }
        }


    }


}
