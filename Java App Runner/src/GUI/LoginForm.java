package GUI;

import Handlers.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginForm{

    public LoginForm(GUI gui){
        this.gui = gui;
        initialize();
    }

    private void initialize(){
        buildLoginButtonhandler();
        //Define colors
        textFieldColors();
        frameColors();
        buttonColors();

        //Build UI

        buildButtons();
        buildLabels();
        buildTextFields();
        panelSetup();
        addElements();
    }

    private void panelSetup(){
        loginPanel = new JPanel();

        loginPanel.setBackground(backgroundColor);
        loginPanel.setLayout(null);
        loginPanel.setVisible(false);
    }

    private void buildLabels(){
        passwordMissmatch = new JLabel("Password does not match!");
        passwordMissmatch.setBounds(300, 320, 200, 20);
        passwordMissmatch.setHorizontalAlignment(JLabel.CENTER);
        passwordMissmatch.setOpaque(true);
        passwordMissmatch.setVisible(false);
    }

    private void buildButtons(){
        loginButton = new JButton("Login");
        loginButton.setBounds(330, 280, 135, 30);
        loginButton.setBackground(buttonColor);
        loginButton.setContentAreaFilled(false);
        loginButton.setOpaque(true);
        loginButton.addActionListener(loginButtonHandler.getActionListener());

        changeForm = new JButton("Dont have an account?, Register here!");
        changeForm.setBounds(280, 370, 255, 20);
        changeForm.setHorizontalAlignment(JLabel.CENTER);
        changeForm.setBackground(Color.DARK_GRAY);
        changeForm.setForeground(Color.CYAN);
        changeForm.setOpaque(true);
        changeForm.setVisible(true);
        changeForm.addActionListener(actionListener2);
    }

    private void buildTextFields(){
        Font font = new Font("Arial", Font.ITALIC + Font.BOLD, 14);

        userNameField = new JTextField("Name");

        userNameField.setBounds(300, 150, 200, 25);
        userNameField.setForeground(textFieldTextColor);
        userNameField.setBackground(textFieldColor);

        userNameField.setFont(font);

        userNameField.setBorder(BorderFactory.createCompoundBorder(
                userNameField.getBorder(),
                BorderFactory.createEmptyBorder(0, 1, 0, 0)));


        //Password field
        passwordField = new JPasswordField("Password");
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                passwordField.getBorder(),
                BorderFactory.createEmptyBorder(0, 1, 0, 0)));

        passwordField.setBounds(300, 200, 200, 25);
        passwordField.setBackground(textFieldColor);
        passwordField.setForeground(textFieldTextColor);
        passwordField.setHorizontalAlignment(JTextField.LEFT);
        passwordField.setFont(font);
        passwordField.setEchoChar('•');
    }

    public void buildLoginButtonhandler(){
       loginButtonHandler = new LoginButtonHandler(loginButton, userNameField, passwordField, this);
    }

    private void addElements(){
        loginPanel.add(getUserNameField());
        loginPanel.add(getPasswordField());
        loginPanel.add(getLoginButton());
        loginPanel.add(getChangeFormButton());
    }

    public void changeToCreateAccountForm(){
        gui.setActiveForm(1);
    }

    public void changeToApplicationForm(){
        gui.setActiveForm(3);
    }

    public void frameColors(){
        //Frame
        red = 16;
        green = 25;
        blue = 34;
        backgroundColor = new Color(red, green, blue);
    }

    public void buttonColors(){
        //Buttons
        red = 200;
        green = 201;
        blue = 203;
        buttonColor = new Color(red, green, blue);
    }

    public void textFieldColors(){
        //Background
        red = 132;
        green = 137;
        blue = 141;
        textFieldColor = new Color(red, green, blue);

        //Foreground
        red = 52;
        green = 57;
        blue = 61;
        textFieldTextColor = new Color(red, green, blue);
    }

    public String getUserNameFieldText(){
        return userNameField.getText();
    }

    public JButton getLoginButton(){
        return loginButton;
    }

    public JTextField getUserNameField(){
        return userNameField;
    }

    public JPasswordField getPasswordField(){
        return passwordField;
    }

    public Color getBackgroundColor(){
        return backgroundColor;
    }

    public JPanel getLoginForm(){
        return loginPanel;
    }

    public JButton getChangeFormButton(){
        return changeForm;
    }

    public String getUserNameOfSucessfulLogin(){
        return loginButtonHandler.getUserNameOfSuccessfulLogin();
    }

    public GUI getGUI(){
        return gui;
    }

    //RGB Colors
    private int red;
    private int green;
    private int blue;

    //Colors
    Color backgroundColor;
    Color buttonColor;
    Color textFieldColor;
    Color textFieldTextColor;

    //Buttons
    private JButton loginButton;
    private JButton changeForm;

    //TextFields
    private JTextField userNameField;
    private JPasswordField passwordField;

    //Errors
    private JLabel passwordMissmatch;

    //ActionListeners
    private LoginButtonHandler loginButtonHandler;
    private ActionListener actionListener2 = new SwitchToCreateAccountFormHandler(this);
    private JPanel loginPanel;

    private GUI gui;
}
