package battery;

public class Battery {

    private double CurrentBatteryPercent=100.0;
    private double LowBatteryPercent = 20;

    public double getBatteryPercentage() {

        return CurrentBatteryPercent;

    }

    public void LowBattery() {
        if (CurrentBatteryPercent <= LowBatteryPercent) {
            System.out.println("Low Battery Warning: " + CurrentBatteryPercent + "%");
        }
    }

    public void decreaseBattery(double i){
        CurrentBatteryPercent -= i;
    }


}
