import java.awt.*;
import java.util.Stack;

public class transport extends Car{

    Stack<Car> carStack;
    Boolean rampOpen;

    public transport(){
        super(2, 90, Color.green, "car transporter");
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
        if (rampOpen){
            carStack.push(a);
            a.position.x = this.position.x;
            a.position.y = this.position.y;
        }
    }

    public void unloadCar(){
        if (rampOpen && !carStack.isEmpty()){
            carStack.pop();
        }
    }

    public void gas(double amount){
        if (amount < 0){
            throw new RuntimeException("no negative amounts!!!");
        }
        else if (rampOpen) {
            throw new RuntimeException("no driving when the ramp is lowered");
        }
        else {
            incrementSpeed(Math.min(1, amount));
            currentSpeed = Math.min(enginePower, currentSpeed);
        }
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
