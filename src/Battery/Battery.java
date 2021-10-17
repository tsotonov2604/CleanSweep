package Battery;

public class Battery {

    private double CurrentBatteryPercent;
    private double LowBatteryPercent = 20;

    public double GetBatteryPercent() {

        return CurrentBatteryPercent;

    }

    public void LowBattery() {

        if (CurrentBatteryPercent <= LowBatteryPercent) {
             System.out.println("Low Battery Warning: " + CurrentBatteryPercent + "%");
        }
    }


}
