package battery;

public class Battery {

    private double CurrentBatteryPercent=100.0;
    private double LowBatteryPercent = 20;

    public double getBatteryPercentage() {

        return CurrentBatteryPercent;

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

    public void decreaseBattery(double i){
        CurrentBatteryPercent -= i;
    }


}
