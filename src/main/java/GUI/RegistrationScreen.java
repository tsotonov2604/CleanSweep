package gui;
import javax.swing.*;

import gui.User;

import java.awt.event.*;
import move.*;

public class RegistrationScreen {

    JFrame registrationScreenFrame;
    Sweep sweep;
    JLabel firstNameLabel=new JLabel("First Name");
    JTextField firstNameTextField=new JTextField();
    JLabel lastNameLabel=new JLabel("Last Name");
    JTextField lastNameTextField=new JTextField();
    JLabel userLabel=new JLabel("Username");
    JTextField userTextField=new JTextField();
    JLabel passwordLabel=new JLabel("Password");
    JPasswordField passwordField=new JPasswordField();
    JButton submitButton = new JButton("Submit");

    User user = new User();
    
    public RegistrationScreen(JFrame frame,Sweep sweep){
        this.registrationScreenFrame = frame; 
        this.sweep = sweep;
    }

    public void createRegistrationScreen(){  
        registrationScreenFrame.setLayout(null);
        registrationScreenFrame.setBounds(10,10,370,600);
        registrationScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        setRegistrationFieldBounds();
        addComponentsToRegistrationScreen();
        startActionListeners();
    }

    public void setRegistrationFieldBounds(){
        firstNameLabel.setBounds(50,150,100,30);
        firstNameTextField.setBounds(150,150,150,30);
        lastNameLabel.setBounds(50,220,100,30);
        lastNameTextField.setBounds(150,220,150,30);
        userLabel.setBounds(50,290,100,30);
        userTextField.setBounds(150,290,150,30);
        passwordLabel.setBounds(50,360,100,30);
        passwordField.setBounds(150,360,150,30);
        submitButton.setBounds(150,440,150,30);
    }

    public void addComponentsToRegistrationScreen(){
        registrationScreenFrame.add(firstNameLabel);
        registrationScreenFrame.add(firstNameTextField);
        registrationScreenFrame.add(lastNameLabel);
        registrationScreenFrame.add(lastNameTextField);
        registrationScreenFrame.add(userLabel);
        registrationScreenFrame.add(userTextField);
        registrationScreenFrame.add(passwordLabel);
        registrationScreenFrame.add(passwordField);
        registrationScreenFrame.add(submitButton);

        registrationScreenFrame.setVisible(true);
    }

    public void goToLoginScreen(){
        registrationScreenFrame.setVisible(false);
        JFrame loginScreenFrame = new JFrame("Login");
        LoginScreen loginScreen = new LoginScreen(loginScreenFrame, sweep, user);
        loginScreen.createLoginScreen();
    }

    public void startActionListeners(){
        submitButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e){
            
            String firstNameText;
            String lastNameText;
            String userText;
            String passwordText;

            firstNameText = firstNameTextField.getText();
            lastNameText = lastNameTextField.getText();
            userText = userTextField.getText();
            passwordText = passwordField.getText();

            if(!firstNameText.equalsIgnoreCase("") && !firstNameText.equalsIgnoreCase(null) && !lastNameText.equalsIgnoreCase("") && !lastNameText.equalsIgnoreCase(null) && !userText.equalsIgnoreCase("") && !userText.equalsIgnoreCase(null) && !passwordText.equalsIgnoreCase("") && !passwordText.equalsIgnoreCase(null)){ 
                user.setFirstName(firstNameText);
                user.setLastName(lastNameText);
                user.setUsername(userText);
                user.setPassword(passwordText);

                JOptionPane.showMessageDialog(registrationScreenFrame, "Registration successful!");
                goToLoginScreen();
            }
            else{
                JOptionPane.showMessageDialog(registrationScreenFrame, "Invalid credentials. Please try again.");
            }
            
        }
    }); 
    }
}
