package Battery;

public class BatteryP {

    private double CurrentBatteryPercent;
    private double LowBatteryPercent = 20;


    public double GetBatteryPercent;{
    public double GetBatteryPercent(){

        return CurrentBatteryPercent;

    }

    public double LowBattery; {
    public void LowBattery() {

        if (CurrentBatteryPercent <= LowBatteryPercent) {
             System.out.println("Low Battery Warning: " + CurrentBatteryPercent + "%");
        }
    }
}
