package GUI;

import Handlers.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateAccountForm{

    public CreateAccountForm(GUI gui){
        this.gui = gui;
        initialize();
    }

    private void initialize(){
        //Panel settings
        panelSettings();

        //Define colors
        textFieldColors();
        frameColors();
        buttonColors();

        //Build UI
        buildButtons();
        buildLabels();
        buildTextFields();

        //Add elements to JPanel
        addElements();
    }
    
    private void panelSettings(){
        createAccountPanel = new JPanel();
        createAccountPanel.setBackground(backgroundColor);
        createAccountPanel.setLayout(null);
        createAccountPanel.setVisible(false);
    }

    private void buildLabels(){
        passwordMissmatch = new JLabel("Password does not match!");
        passwordMissmatch.setBounds(300, 320, 200, 20);
        passwordMissmatch.setHorizontalAlignment(JLabel.CENTER);
        passwordMissmatch.setBackground(Color.red);
        passwordMissmatch.setOpaque(true);
        passwordMissmatch.setVisible(false);
    }

    private void buildButtons(){
        createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(330, 280, 135, 30);
        createAccountButton.setBackground(buttonColor);
        createAccountButton.setContentAreaFilled(false);
        createAccountButton.setOpaque(true);
        createAccountButton.addActionListener(actionListener);

        loginFormButton = new JButton("Already have an account?, Login here!");
        loginFormButton.setBounds(280, 370, 255, 20);
        loginFormButton.setHorizontalAlignment(JLabel.CENTER);
        loginFormButton.setBackground(Color.DARK_GRAY);
        loginFormButton.setForeground(Color.CYAN);
        loginFormButton.setOpaque(true);
        loginFormButton.setVisible(true);
        loginFormButton.addActionListener(actionListener2);
    }

    private void buildTextFields(){
        Font font = new Font("Arial", Font.ITALIC + Font.BOLD, 14);

        userNameField = new JTextField("Name");

        userNameField.setBounds(300, 150, 200, 25);
        userNameField.setForeground(textFieldTextColor);
        userNameField.setBackground(textFieldColor);

        userNameField.setFont(font);

        userNameField.setBorder(BorderFactory.createCompoundBorder(userNameField.getBorder(), BorderFactory.createEmptyBorder(0, 1, 0, 0)));


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

        //Password Verification field
        passwordVerifyField = new JPasswordField("Password");

        passwordVerifyField.setBorder(BorderFactory.createCompoundBorder(
                passwordVerifyField.getBorder(),
                BorderFactory.createEmptyBorder(0, 1, 0, 0)));

        passwordVerifyField.setBounds(300, 235, 200, 25);
        passwordVerifyField.setBackground(textFieldColor);
        passwordVerifyField.setForeground(textFieldTextColor);
        passwordVerifyField.setHorizontalAlignment(JTextField.LEFT);
        passwordVerifyField.setFont(font);
        passwordVerifyField.setEchoChar('•');
    }

    private void addElements(){
        createAccountPanel.add(createAccountButton);
        createAccountPanel.add(passwordField);
        createAccountPanel.add(passwordMissmatch);
        createAccountPanel.add(passwordVerifyField);
        createAccountPanel.add(userNameField);
        createAccountPanel.add(loginFormButton);
    }

    private void frameColors(){
        //Frame
        red = 16;
        green = 25;
        blue = 34;
        backgroundColor = new Color(red, green, blue);
    }

    private void buttonColors(){
        //Buttons
        red = 200;
        green = 201;
        blue = 203;
        buttonColor = new Color(red, green, blue);
    }

    private void textFieldColors(){
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

    public void changeToLoginForm(){
        gui.setActiveForm(2);
    }

    public String getUserNameFieldText(){
        return userNameField.getText();
    }

    public char[] getPassWordFieldText(){
        return passwordField.getPassword();
    }

    public char[]getPassWordVerifyFieldText(){
        return passwordVerifyField.getPassword();
    }


    public JPasswordField getPasswordField(){
        return passwordField;
    }

    public JPasswordField getPasswordVerifyField(){
        return  passwordVerifyField;
    }

    public Color getBackgroundColor(){
        return backgroundColor;
    }

    public void setPasswordMissmatchVisibility(boolean bool){
        passwordMissmatch.setVisible(bool);
    }

    public JLabel getPasswordMissmatch(){
        return passwordMissmatch;
    }

    public JButton getLoginFormButton(){
        return loginFormButton;
    }

    public GUI getGUI(){
        return gui;
    }


    public JPanel getCreateAccountForm(){
        return createAccountPanel;
    }

    //RGB Colors
    private int red;
    private int green;
    private int blue;

    //Colors
    private Color backgroundColor;
    private Color buttonColor;
    private Color textFieldColor;
    private Color textFieldTextColor;

    //Buttons
    private JButton createAccountButton;
    private JButton loginFormButton;


    //TextFields
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JPasswordField passwordVerifyField;

    //Labels
    private JLabel passwordMissmatch;

    private GUI gui;

    //ActionListeners
    private ActionListener actionListener = new CreateAccountButtonHandler( this);
    private ActionListener actionListener2 = new SwitchToLoginFormHandler( this);

    private JPanel createAccountPanel;
}