package battery;
import javax.swing.*;
import Barriers.FloorType;

public class Battery {

    public double CurrentBatteryPercent;
    private double LowBatteryPercent = 20;
    private double FullBatteryPercent=250;

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

    public void LowBatteryWar() {

        if (CurrentBatteryPercent <= LowBatteryPercent) {
            JOptionPane.showMessageDialog(null, "Low Battery",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void fullBatteryInfo() {

        if (CurrentBatteryPercent == FullBatteryPercent) {
            JOptionPane.showMessageDialog(null, "Full Battery",
                    "INFO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void unitsOfCharging(FloorType floorType){
        if(floorType == FloorType.Bare) // bare floor
            CurrentBatteryPercent-=1; // uses 1 unit of power
        else if(floorType == FloorType.LowPile) //low-pile carpet
            CurrentBatteryPercent-=2; //uses 2 units of power
        else if(floorType == FloorType.HighPile) //high-pile carpet
            CurrentBatteryPercent-=3; //uses 3 units of power
    }
}
