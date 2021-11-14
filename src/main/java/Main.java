import Barriers.Floor;
import ChargingStation.*;
import move.*;
import schedule.Schedule;
import ChargingStation.ChargingStation;
import Power.OnOffButton;
import battery.*;
import ChargingStation.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import DirtCapacity.*;
import GUI.*;



public class Main {

    public static void main(String[] args) throws Exception {
  
        JFrame loginScreenFrame = new JFrame("Login");
        User user = new User();
        LoginScreen gui = new LoginScreen(loginScreenFrame, null,user );
        gui.createLoginScreen();

    }
}
