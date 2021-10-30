package GUI;
import javax.swing.*;
import java.awt.event.*;

public class LoginScreen {

    JFrame loginScreen;
    JLabel userLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("RESET");
    JCheckBox showPassword=new JCheckBox("Show Password");

    public LoginScreen(JFrame frame){
        this.loginScreen = frame;
    }
    
    public void createLoginScreen(){  
        loginScreen.setLayout(null);
        loginScreen.setBounds(10,10,370,600);
        loginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        setLoginFieldBounds();
        addComponentsToLoginScreen();
        startActionListeners();

    }


    public void setLoginFieldBounds(){
        userLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        userTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        resetButton.setBounds(200,300,100,30);

    }

    public void addComponentsToLoginScreen(){
        loginScreen.add(userLabel);
        loginScreen.add(passwordLabel);
        loginScreen.add(userTextField);
        loginScreen.add(passwordField);
        loginScreen.add(loginButton);
        loginScreen.add(resetButton);
        loginScreen.add(showPassword);

        loginScreen.setVisible(true);
    }

    public void goToHomeScreen() {
        loginScreen.setVisible(false); //end current view
        JFrame homeScreenFrame = new JFrame("Clean Sweep Home");
        HomeScreen homeScreen = new HomeScreen(homeScreenFrame);
        homeScreen.createHomeScreen();
    }

   
    public void startActionListeners() {
        //Login Button 
        loginButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e){
            if (e.getSource() == loginButton) {
                String userText;
                String pwdText;
                userText = userTextField.getText();
                pwdText = passwordField.getText();
                if (userText.equalsIgnoreCase("dev") && pwdText.equalsIgnoreCase("12345")) { //HARDCODED LOGIN CREDENTIALS !!!
                    JOptionPane.showMessageDialog(loginScreen, "Login Successful"); 
                    goToHomeScreen();            
                } else {
                    JOptionPane.showMessageDialog(loginScreen, "Invalid Username or Password");
                }    
            }
            }});
    
        //Reset Button 
        resetButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e){
            if (e.getSource() == resetButton) {
                userTextField.setText("");
                passwordField.setText("");
            }
        }});
    
        //Show Password 
        showPassword.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e){
            if (e.getSource() == showPassword) {
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                     passwordField.setEchoChar('*');
                }
        }}});      
    }
}
