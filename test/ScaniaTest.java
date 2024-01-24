import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScaniaTest {

    Scania car;

    @Before
    public void init(){
        car = new Scania();
    }

    @Test
    public void raisePlatformTest() {
        car.raisePlatform(70);
        car.raisePlatform(1);
        Assert.assertFalse(car.platformangle > 70);

    }

    @Test
    public void lowerPlatform() {
        car.raisePlatform(1);
        car.lowerPlatform(1);
        car.lowerPlatform(1);
        Assert.assertFalse(car.platformangle < 0);

    }

    @Test
    public void gas() {
        car.raisePlatform(1);
        car.gas(1);
        Assert.assertFalse(car.currentSpeed > 0);
    }
}