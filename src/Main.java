import ChargingStation.ChargingStation;
import Power.OnOffButton;
import javax.swing.*;
import java.awt.*;
import DirtCapacity.DirtSensor;
import DirtCapacity.DirtCapacityOfSweeper;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ChargingStation cs = new ChargingStation();
        cs.charge();

        //OnOffButton
        OnOffButton OnOff = new OnOffButton();
        OnOff.setTitle("Turning a device On/Off");
        OnOff.setLayout(new FlowLayout());
        OnOff.setJToggleButton();
        OnOff.setAction();
        OnOff.setSize(300, 200);
        OnOff.setVisible(true);
        OnOff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DirtCapacityOfSweeper
        DirtCapacityOfSweeper info= new DirtCapacityOfSweeper();
        info.dirtCapacity();

        //DirtSensor
        DirtSensor war= new DirtSensor();
        war.FullBag();
        war.EmptyBag();


    }
}
