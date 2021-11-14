package DirtCapacity;
import java.util.LinkedList;
import Log.Logger;

public class DirtCapacityOfSweeper{

    private static int getCurrentSize;
    //private LinkedList<Integer> Bag = new LinkedList<>();

    public DirtCapacityOfSweeper(){}

    public static int getCurrentBagSize(){
        return getCurrentSize;
    }

    public static void dirtCapacity(){
        getCurrentSize += 1;
        System.out.println("The dirt capacity is up to 100. The current dirt quantity is: " +getCurrentSize);
        Logger.writeToDirtCapacityLog(getCurrentSize,100);
    }

}
