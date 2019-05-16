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

    private void buildTextAreas(){
        personalMessageArea = new JTextArea("hello");
        personalMessageArea.setBounds(250, 150, 300, 100);
        personalMessageArea.setEditable(false);
        personalMessageArea.setBackground(messageColor());
        personalMessageArea.setForeground(messageTextColor());
        personalMessageArea.setLineWrap(true);
        personalMessageArea.setWrapStyleWord(true);
        personalMessageArea.setFont(personalMessageArea.getFont().deriveFont(18f));
        personalMessageArea.setMargin( new Insets(20, 5, 5, 5));
    }

    private void buildButtons(){
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

    private void addElements(){
        applicationPanel.add(personalMessageArea);
        applicationPanel.add(editMessageButton);
        applicationPanel.add(saveNewMessageButton);
    }

    public void userMessageSetup() throws SQLException {
        userMessage = new UserMessage(this);
        setPersonalMessageText(userMessage.getUserMessageFromDatabase());
    }

    private void frameColors(){
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

    private JPanel applicationPanel;
    private JTextArea personalMessageArea;
    private JButton editMessageButton;
    private JButton saveNewMessageButton;

    private ActionListener actionListener = new EditMessageButtonHandler( this);
    private ActionListener actionListener2 = new SaveMessageButtonHandler(this);

    private UserMessage userMessage;
    private GUI gui;
}
