import java.util.ArrayList;
import java.util.List;

abstract class Bar
{
    List<BarObserver> observers;
    public Bar(){observers = new ArrayList();}

    public abstract boolean isHappyHour();

    public abstract void startHappyHour();

    public abstract void endHappyHour();

    public void addObserver(BarObserver obs) {observers.add(obs);}

    public void removeObserver(BarObserver obs) {observers.remove(obs);}
}