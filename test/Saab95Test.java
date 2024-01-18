import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;

public class Saab95Test extends TestCase {
    Saab95 car;

    @Before
    public void init(){
        car = new Saab95();
    }

    public void testSetTurboOn() {
        car.setTurboOn();
        Assert.assertTrue(car.getTurbo());
    }

    public void testSetTurboOff() {
        car.setTurboOff();
        Assert.assertFalse(car.getTurbo());
    }

    public void testSpeedFactor() {

    }

    public void testIncrementSpeed() {
    }

    public void testDecrementSpeed() {
    }

    public void testGas() {
    }

    public void testBrake() {
    }
}