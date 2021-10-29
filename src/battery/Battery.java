package battery;
import javax.swing.*;

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

}
