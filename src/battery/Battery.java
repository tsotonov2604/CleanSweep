package battery;

public class Battery {

    public double CurrentBatteryPercent;
    private double LowBatteryPercent = 20;

    public double getCurrentBatteryPercent() {
        return this.CurrentBatteryPercent;
    }

    public void setCurrentBatteryPercent(double CurrentBatteryPercent) {
        this.CurrentBatteryPercent = CurrentBatteryPercent;
    }

    
    public boolean LowBattery() {

        if (CurrentBatteryPercent <= LowBatteryPercent) {
            System.out.println("Low Battery Warning: " + CurrentBatteryPercent + "%");
        }
        return true;
    }


}
