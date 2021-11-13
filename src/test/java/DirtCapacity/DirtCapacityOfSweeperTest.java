package DirtCapacity;
import DirtCapacity.DirtCapacityOfSweeper;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DirtCapacityOfSweeperTest {

    DirtCapacityOfSweeper test= new DirtCapacityOfSweeper();

    @Test
    @DisplayName("Testing the bag of sweep at the beginning")
    public void test(){
        assertEquals(0,test.getCurrentBagSize());
    }

    @Test
    @DisplayName("Testing the increased of the bag after cleaning")
    public void test1(){
        test.dirtCapacity();
        assertEquals(1,test.getCurrentBagSize());
        test.dirtCapacity();
        assertEquals(2,test.getCurrentBagSize());
        test.dirtCapacity();
        assertEquals(3,test.getCurrentBagSize());
    }

}
