package dirt_capacity;
import java.util.LinkedList;

import log.Logger;

public class DirtCapacityOfSweeper{

    //private LinkedList<Integer> Bag = new LinkedList<>();
    private static int getCurrentSize;

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
