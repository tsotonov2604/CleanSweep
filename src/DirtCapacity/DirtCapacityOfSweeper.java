package DirtCapacity;
import java.util.LinkedList;
import Log.Logger;

public class DirtCapacityOfSweeper{

    private LinkedList<Integer> Bag = new LinkedList<>();

    public DirtCapacityOfSweeper(){}

    public int getCurrentBagSize(){
        return Bag.size();
    }

    public void dirtCapacity(){
        System.out.println("The dirt capacity is up to 100. The current dirt quantity is: " +getCurrentBagSize());
        Logger.writeToDirtCapacityLog(getCurrentBagSize(),100);
    }

}
