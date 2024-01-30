import java.util.ArrayList;
public class workshop <T> {

    protected ArrayList<T> carlist;

    public workshop(){
        carlist = new ArrayList<>(10);
    }

    public void addCar(T a){
        carlist.add(a);
    }
    public T  releaseCar(){
        return carlist.removeLast();
    }

}
