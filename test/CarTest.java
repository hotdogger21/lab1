import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class CarTest {

    Saab95 car1;
    Volvo240 car2;

    @Before
    public void init(){
        car1 = new Saab95();
        car2 = new Volvo240();
    }


    @Test
    public void testGetNrDoors() {
        Assert.assertEquals(2, car1.getNrDoors());
    }

    @Test
    public void testGetEnginePower() {
        Assert.assertEquals(125, car1.getEnginePower(),1e-15);
    }

    @Test
    public void testGetCurrentSpeed() {
        Assert.assertEquals(0, car1.getCurrentSpeed(),1e-15);
    }

    @Test
    public void testGetColor() {
        Assert.assertEquals(Color.red, car1.getColor());
    }

    @Test
    public void testSetColor() {
        car1.setColor(Color.blue);
        Assert.assertEquals(Color.blue, car1.getColor());
    }

    @Test
    public void testStartEngine() {
        car1.startEngine();
        Assert.assertTrue(car1.currentSpeed > 0);
    }

    @Test
    public void testStopEngine() {
        car1.stopEngine();
        Assert.assertFalse(car1.currentSpeed > 0);
    }

    /*
    dessa metoder overridas av subclasser och bör inte användas enbart av en "car" (tror jag)
    @Test
    public void testSpeedFactor() {

    }

    @Test
    public void testIncrementSpeed() {
    }

     */

    @Test
    public void testMove() {
        car1.startEngine();
        car1.move();
        car1.turnLeft();
        car1.move();

        Assert.assertTrue(car1.getPos().getY() > 0 && car1.getPos().getX() > 0);
    }

    @Test
    public void testTurnLeft() {
        car1.startEngine();
        car1.turnLeft();
        car1.move();

        Assert.assertTrue(car1.getPos().getY() <= 0 && car1.getPos().getX() > 0);
    }

    @Test
    public void testTurnRight() {
        car1.startEngine();
        car1.turnRight();
        car1.move();
        car1.move();

        Assert.assertTrue(car1.getPos().getY() <= 0 && car1.getPos().getX() < 0);
    }

    @Test
    public void testGas() {
        car1.setTurboOn();
        for (int i = 0; i <101 ; i++) {
            car1.gas(12);
        }
        car1.gas(1);
        Assert.assertFalse(car1.currentSpeed > car1.enginePower);
    }

    @Test
    public void testBrake() {
    }
}