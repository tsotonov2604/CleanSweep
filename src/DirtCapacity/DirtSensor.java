package DirtCapacity;

public class DirtSensor{

    DirtCapacityOfSweeper sensor = new DirtCapacityOfSweeper();
    private static final int MaxCapacity = 100;
    public boolean Capacity;

    public DirtSensor(){}

    public void aFulledBag() {
         Capacity = (sensor.getCurrentBagSize() == MaxCapacity);
        if (Capacity) {
            System.out.println("The bag is full!");
        }
    }
}