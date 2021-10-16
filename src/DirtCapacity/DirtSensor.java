package DirtCapacity;
import javax.swing.*;


public class DirtSensor {

    DirtCapacityOfSweeper sensor = new DirtCapacityOfSweeper();
    public int Capacity;

    public DirtSensor(){}

    public void FullBag() {
        Capacity = sensor.getCurrentBagSize();
        if (Capacity == 100) {
            JOptionPane.showMessageDialog(null, "The bag is full!",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }
        public void EmptyBag(){
            Capacity = sensor.getCurrentBagSize();
            if (Capacity == 0) {
                JOptionPane.showMessageDialog(null, "The bag is Empty!",
                        "INFO", JOptionPane.INFORMATION_MESSAGE);
            }
     }


}