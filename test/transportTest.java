import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class transportTest {

    transport supercar;
    Saab95 car1;
    Volvo240 car2;

    workshop<Volvo240> test1;

    @Before
    public void init(){
        supercar = new transport();
        car1 = new Saab95();
        car2 = new Volvo240();
        test1 = new workshop<>();
    }

    @Test
    public void openRamp() {
        supercar.openRamp();
        Assert.assertTrue(supercar.rampOpen);
    }

    @Test
    public void closeRamp() {
        supercar.openRamp();
        supercar.closeRamp();
        Assert.assertFalse(supercar.rampOpen);
    }

    @Test
    public void loadCar() {
        supercar.openRamp();
        supercar.loadCar(car1);
        Assert.assertFalse(supercar.carStack.isEmpty());
    }

    //test om bil inte ligger nära transporten då händer inget om man försöker lasta den
    @Test
    public void loadCar2() {
        supercar.openRamp();
        car1.position.x = 100;
        supercar.loadCar(car1);
        Assert.assertTrue(supercar.carStack.isEmpty());
    }

    @Test
    public void unloadCar() {
        supercar.openRamp();
        supercar.loadCar(car1);
        supercar.unloadCar();
        Assert.assertTrue(supercar.carStack.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void gas() {
        supercar.openRamp();
        supercar.gas(1);
    }

    @Test
    public void move() {
        supercar.openRamp();
        supercar.loadCar(car1);
        supercar.closeRamp();
        supercar.gas(1);
        supercar.move();
        supercar.move();
        supercar.stopEngine();
        supercar.openRamp();
        supercar.unloadCar();
        supercar.closeRamp();
        supercar.gas(1);
        supercar.move();
    }
}