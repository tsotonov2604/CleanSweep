package GUI;
import javax.swing.*;
import java.awt.event.*;
import move.*;
import GUI.User;

public class LoginScreen {

    JFrame loginScreen;
    Sweep sweep;
    User user;
    JLabel welcomeLabel = new JLabel("<html><span style='color: blue;'>Welcome To The Clean Sweep Portal!</span></html>");
    JLabel userLabel=new JLabel("Username");
    JLabel passwordLabel=new JLabel("Password");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton=new JButton("Login");
    JButton resetButton=new JButton("Reset");
    JButton registerButton = new JButton("Register");
    JCheckBox showPassword=new JCheckBox("Show Password");

    public LoginScreen(JFrame frame, Sweep sweep, User user){
        this.loginScreen = frame;
        this.sweep = sweep;
        this.user= user;
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
        welcomeLabel.setBounds(65,50,250,30);
        userLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        userTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        resetButton.setBounds(200,300,100,30);
        registerButton.setBounds(50,370,100,30);

    }

    public void addComponentsToLoginScreen(){
        loginScreen.add(welcomeLabel);
        loginScreen.add(userLabel);
        loginScreen.add(passwordLabel);
        loginScreen.add(userTextField);
        loginScreen.add(passwordField);
        loginScreen.add(loginButton);
        loginScreen.add(resetButton);
        loginScreen.add(showPassword);
        loginScreen.add(registerButton);

        loginScreen.setVisible(true);
    }

    public void goToHomeScreen() {
        loginScreen.setVisible(false); 
        JFrame homeScreenFrame = new JFrame("Clean Sweep Home");
        HomeScreen homeScreen = new HomeScreen(homeScreenFrame, sweep, this.user);
        homeScreen.createHomeScreen();
    }

    public void goToRegistrationScreen(){
        loginScreen.setVisible(false); 
        JFrame registrationScreenFrame = new JFrame("Registration");
        RegistrationScreen registrationScreen = new RegistrationScreen(registrationScreenFrame, sweep);
        registrationScreen.createRegistrationScreen();
    }

   
    public void startActionListeners() {
        //Login Button 
        loginButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e){
            if (e.getSource() == loginButton) {
                String userText;
                String pwdText;
                userText = userTextField.getText();
                pwdText = passwordField.getText();
                //Can hardcode username & pasword for testing
                if (userText.equalsIgnoreCase(user.getUsername()) && pwdText.equalsIgnoreCase(user.getPassword())) { 
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
        
        //Register Button
        registerButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e){
            if (e.getSource() == registerButton) {
                goToRegistrationScreen();
            }
        }});
    }
}
