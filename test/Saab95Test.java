import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Saab95Test {
    Saab95 car;

    @Before
    public void init(){
        car = new Saab95();
    }

    @Test
    public void testSetTurboOn() {
        car.setTurboOn();
        Assert.assertTrue(car.getTurbo());
    }

    @Test
    public void testSetTurboOff() {
        car.setTurboOff();
        Assert.assertFalse(car.getTurbo());
    }

    @Test
    public void testSpeedFactor() {
        Assert.assertEquals(1.25, car.speedFactor(), 1e-15);
    }

    @Test
    public void testIncrementSpeed() {
        car.startEngine();
        car.incrementSpeed(1);
        Assert.assertTrue(car.getCurrentSpeed() > 0.1);
    }

    @Test
    public void testDecrementSpeed() {
        car.startEngine();
        car.decrementSpeed(1);
        Assert.assertTrue(car.getCurrentSpeed() < 0.1);
    }

    @Test
    public void testGas() {
    }

    @Test
    public void testBrake() {
    }
}