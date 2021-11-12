package DirtCapacity;
import java.util.LinkedList;

public class DirtCapacityOfSweeper{

    private LinkedList<Integer> Bag = new LinkedList<>();

    public DirtCapacityOfSweeper(){}

    public int getCurrentBagSize(){
        return Bag.size();
    }

    public void dirtCapacity(){
        System.out.println("The dirt capacity is up to 100. The current dirt quantity is: " +getCurrentBagSize());
    }

}
