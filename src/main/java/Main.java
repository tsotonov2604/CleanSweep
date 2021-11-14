import move.*;
import power.OnOffButton;
import schedule.Schedule;
import barriers.Floor;
import battery.*;
import charging_station.*;
import dirt_capacity.*;
import gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



public class Main {

    public static void main(String[] args) throws Exception {
  
        JFrame loginScreenFrame = new JFrame("Login");
        User user = new User();
        LoginScreen gui = new LoginScreen(loginScreenFrame, null,user );
        gui.createLoginScreen();

    }
}
