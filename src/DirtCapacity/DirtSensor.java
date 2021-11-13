package DirtCapacity;
import javax.swing.*;
import Log.Logger;


public class DirtSensor {

    DirtCapacityOfSweeper sensor = new DirtCapacityOfSweeper();
    public int Capacity;

    public DirtSensor(){}

    public void FullBag() {
        Capacity = sensor.getCurrentBagSize();
        if (Capacity == 100) {
            JOptionPane.showMessageDialog(null, "The bag is full!",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
            Logger.writeToDirtCapacityLog(sensor.getCurrentBagSize(),100);
        }
    }
        public void EmptyBag(){
            Capacity = sensor.getCurrentBagSize();
            if (Capacity == 0) {
                JOptionPane.showMessageDialog(null, "The bag is Empty!",
                        "INFO", JOptionPane.INFORMATION_MESSAGE);
            }
     }

     public void BagCapcityAlert() {
        Capacity = sensor.getCurrentBagSize();
        if (Capacity == 90) {
            JOptionPane.showMessageDialog(null, "The dirt bag is almost full!",
                    "ALERT", JOptionPane.WARNING_MESSAGE);
        }
    }

}