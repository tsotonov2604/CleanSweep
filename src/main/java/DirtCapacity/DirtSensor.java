package DirtCapacity;
import javax.swing.*;


public class DirtSensor {

    //DirtCapacityOfSweeper sensor = new DirtCapacityOfSweeper();
    public int Capacity = 0;

    public DirtSensor(){}

    public boolean FullBag() {
       // Capacity = sensor.getCurrentBagSize();
//            JOptionPane.showMessageDialog(null, "The bag is full!",
//                    "WARNING", JOptionPane.WARNING_MESSAGE);
            return true;
    }
        public void EmptyBag(){
            //Capacity = sensor.getCurrentBagSize();
            if (Capacity == 0) {
                JOptionPane.showMessageDialog(null, "The bag is Empty!",
                        "INFO", JOptionPane.INFORMATION_MESSAGE);
            }
     }

     public void BagCapcityAlert() {
        //Capacity = sensor.getCurrentBagSize();
        if (Capacity == 90) {
            JOptionPane.showMessageDialog(null, "The dirt bag is almost full!",
                    "ALERT", JOptionPane.WARNING_MESSAGE);
        }
    }

    public synchronized void addToCapacity(int i){
        if((Capacity+i) <= 100)
            Capacity+=i;
        else
            FullBag();
    }

    public void emptyBag(){
        System.out.println("Emptying Bag...");
        Capacity = 0;
    }

}