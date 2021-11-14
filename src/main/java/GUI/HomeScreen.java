package GUI;
import javax.swing.*;
import java.awt.event.*;
import move.*;

public class HomeScreen {

    JFrame homeScreen;
    Sweep sweep;
    gui.User user;
    JButton powerButton = new JButton("ON");
    JLabel batteryLabel=new JLabel("BATTERY PERCENTAGE:");
    JLabel batteryStatus = new JLabel("");
    JLabel welcomeLabel = new JLabel("");

    public HomeScreen(JFrame frame, Sweep sweep,gui.User user){
        this.homeScreen = frame;
        this.sweep = sweep;
        this.user = user;
    }

    public void createHomeScreen(){
        homeScreen.setLayout(null);
        homeScreen.setBounds(10,10,370,600);
        homeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        setHomeFieldBounds();
        addComponentsToHomeScreen();
        startActionListeners();
    }

    public void setHomeFieldBounds(){    
        powerButton.setBounds(50,150,100,30);
        batteryLabel.setBounds(50,200,150,50);
        batteryStatus.setBounds(200,210,100,30);
        welcomeLabel.setBounds(100,150,250,30);
    }

    public void addComponentsToHomeScreen(){
        homeScreen.add(welcomeLabel);
        homeScreen.add(powerButton);
        homeScreen.add(batteryLabel);
        homeScreen.add(batteryStatus);
             
        homeScreen.setVisible(true);
    }


    public void startActionListeners(){
        
        //Power
        powerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                if (powerButton.getText().equals("ON"))
                    powerButton.setText("OFF");
                else
                    powerButton.setText("ON");
            }
        });
        
        //Battery Status
        batteryStatus.setText(String.valueOf(sweep.getBattery().getBatteryPercentage() + " %"));

        //Welcome Label
        welcomeLabel.setText("<html><h2 style='color: green'>" + "Hello, " + capitalize(user.getFirstName()) + " " + capitalize(user.getLastName()) + "</h2></html>");
        
    }

    //string formatting helper 
    public static String capitalize(String str)
    {
        if(str == null) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
