package GUI;

import Default.ActiveUser;
import Default.UserMessage;
import Handlers.EditMessageButtonHandler;
import Handlers.SaveMessageButtonHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ApplicationForm {

    public ApplicationForm(GUI gui){
        initialize();
        this.gui= gui;
    }

    private void initialize(){
        //Colors
        frameColors();
        //Panel
        panelSetup();
        //UI
        buildTextAreas();
        buildButtons();

        addElements();
    }

    private void panelSetup(){
        applicationPanel = new JPanel();

        applicationPanel.setBackground(backgroundColor);
        applicationPanel.setLayout(null);
        applicationPanel.setVisible(false);
    }

    public void buildTextAreas(){
        Font font = new Font("Arial", Font.ITALIC + Font.BOLD, 14);
        personalMessageArea = new JTextArea("hello");
        personalMessageArea.setBounds(250, 150, 300, 100);
        personalMessageArea.setEditable(false);
        personalMessageArea.setBackground(messageColor());
        personalMessageArea.setForeground(messageTextColor());
    }

    public void buildButtons(){
        editMessageButton = new JButton("Edit Text");
        editMessageButton.setBounds(250, 270, 100, 25);
        editMessageButton.addActionListener(actionListener);
        editMessageButton.setBackground(buttonColor());
        editMessageButton.setForeground(buttonTextColor());
        editMessageButton.setOpaque(true);

        saveNewMessageButton = new JButton("Save");
        saveNewMessageButton.setBounds(450, 270, 100, 25);
        saveNewMessageButton.addActionListener(actionListener2);
        saveNewMessageButton.setVisible(false);
        saveNewMessageButton.setBackground(buttonColor());
        saveNewMessageButton.setForeground(buttonTextColor());
        saveNewMessageButton.setOpaque(true);
    }

    public void addElements(){
        applicationPanel.add(personalMessageArea);
        applicationPanel.add(editMessageButton);
    }

    public void userMessageSetup() throws SQLException {
        userMessage = new UserMessage(this);
        setPersonalMessageText(userMessage.getUserMessageFromDatabase());
    }

    public void frameColors(){
        //Frame
        red = 16;
        green = 25;
        blue = 34;
        backgroundColor = new Color(red, green, blue);
    }

    private Color messageColor(){
        Color color;
        red = 0;
        green = 50;
        blue = 60;
        color = new Color(red, green, blue);

        return color;
    }

    private Color messageTextColor(){
        Color color;
        red = 225;
        green = 225;
        blue = 225;
        color = new Color(red, green, blue);

        return color;
    }

    private Color buttonColor(){
        Color color;
        red = 0;
        green = 50;
        blue = 60;
        color = new Color(red, green, blue);

        return color;
    }

    private Color buttonTextColor(){
        Color color;
        red = 225;
        green = 225;
        blue = 225;
        color = new Color(red, green, blue);

        return color;
    }

    public Color getBackgroundColor(){
        return backgroundColor;
    }

    public JPanel getApplicationPanel(){
        return applicationPanel;
    }

    public JTextArea getPersonalMessageArea() {
        return personalMessageArea;
    }

    public JButton getSaveNewMessageButton() {
        return saveNewMessageButton;
    }

    public UserMessage getUserMessage(){
        return userMessage;
    }

    public void setPersonalMessageText(String text) throws SQLException {
        personalMessageArea.setText(text);
    }

    public String getActiveUserUserName(){
        return gui.getActiveUser().getActiveUserUserName();
    }

    public GUI getGUI(){
        return gui;
    }

    //Colors
    Color backgroundColor;

    //RGB Colors
    private int red;
    private int green;
    private int blue;

    JPanel applicationPanel;
    JTextArea personalMessageArea;
    JButton editMessageButton;
    JButton saveNewMessageButton;

    private ActionListener actionListener = new EditMessageButtonHandler( this);
    private ActionListener actionListener2 = new SaveMessageButtonHandler(this);

    private ActiveUser activeUser;
    private UserMessage userMessage;
    private GUI gui;
}
