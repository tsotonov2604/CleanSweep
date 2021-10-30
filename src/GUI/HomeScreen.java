package GUI;
import javax.swing.*;
import java.awt.event.*;

public class HomeScreen {

    JFrame homeScreen;
    JButton powerButton = new JButton("ON");

    public HomeScreen(JFrame frame){
        this.homeScreen = frame;
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
    }

    public void addComponentsToHomeScreen(){
        homeScreen.add(powerButton);
       
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
       
    }
    
}
