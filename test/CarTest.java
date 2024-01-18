import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class CarTest {

    Car car1;
    Car car2;

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

    @Test
    public void testSpeedFactor() {
    }

    @Test
    public void testIncrementSpeed() {
    }

    @Test
    public void testDecrementSpeed() {
    }

    @Test
    public void testMove() {
    }

    @Test
    public void testTurnLeft() {
    }

    @Test
    public void testTurnRight() {
    }
}