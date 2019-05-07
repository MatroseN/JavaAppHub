package GUI;

import Handlers.HamburgerButtonHandler;
import Handlers.LogoutHandler;
import Handlers.menuFormToApplicationFormHandler;
import Handlers.menuFormToFlashCardsHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuForm {

    public MenuForm(GUI gui){
        this.gui = gui;
        initialize();
    }

   private void initialize(){
        //Colors
       frameColors();
        //Entities
        buildImages();
        buildButtons();

        //Menu
       buildMenu();

        //Panel
       panelSetup();
   }

    private void panelSetup(){
        menuPanel = new JPanel();
        menuPanel.setBackground(backgroundColor);
        menuPanel.setLayout(null);
        menuPanel.setVisible(true);
    }

    private void buildImages(){
        try {
            Image image = ImageIO.read(getClass().getResource("/Icons/hamburgericon.png"));
            hamburgerIcon = image.getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildButtons(){
        hamburgerIconButton = new JButton();
        hamburgerIconButton.setBounds(0, 0, 35, 30);
        hamburgerIconButton.addActionListener(actionListener);

        applicationNavButton = new JButton();
        applicationNavButton.setBounds(0, 35, 110, 25);
        applicationNavButton.setHorizontalTextPosition(SwingConstants.LEFT);
        applicationNavButton.setText("Home");
        applicationNavButton.addActionListener(actionListener3);
        applicationNavButton.setBackground(navButtonColor());
        applicationNavButton.setForeground(navButtonTextColor());
        applicationNavButton.setOpaque(true);

        flashCardNavButton = new JButton();
        flashCardNavButton.setBounds(115, 35, 110, 25);
        flashCardNavButton.setHorizontalTextPosition(SwingConstants.LEFT);
        flashCardNavButton.setText("Flash Cards");
        flashCardNavButton.addActionListener(actionListener2);
        flashCardNavButton.setBackground(navButtonColor());
        flashCardNavButton.setForeground(navButtonTextColor());
        flashCardNavButton.setOpaque(true);

        logoutButton = new JButton();
        logoutButton.setBounds(230, 35, 110, 25);
        logoutButton.setHorizontalTextPosition(SwingConstants.LEFT);
        logoutButton.setText("Logout");
        logoutButton.addActionListener(logoutHandler);
        logoutButton.setBackground(navButtonColor());
        logoutButton.setForeground(navButtonTextColor());
        logoutButton.setOpaque(true);
    }


    private void buildMenu(){
        hamburgerIconButton.setIcon(new ImageIcon(hamburgerIcon));
    }


    public void frameColors(){
        //Frame
        red = 0;
        green = 5;
        blue = 15;
        backgroundColor = new Color(red, green, blue);
    }

    private Color navButtonColor(){
        Color color;
        red = 0;
        green = 50;
        blue = 60;
        color = new Color(red, green, blue);

        return color;
    }

    private Color navButtonTextColor(){
        Color color;
        red = 225;
        green = 225;
        blue = 225;
        color = new Color(red, green, blue);

        return color;
    }

    public void changeForm(int n){
        gui.setActiveForm(n);
    }

    public JPanel getMenuPanel(){
        return menuPanel;
    }

    public Color getBackgroundColor(){
        return backgroundColor;
    }

    public JButton getHamburgerIconButton() {
        return hamburgerIconButton;
    }

    public JButton getFlashCardNavButton(){
        return flashCardNavButton;
    }

    public JButton getApplicationNavButton() {
        return applicationNavButton;
    }

    public JButton getLogoutButton(){
        return logoutButton;
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


    private ActionListener actionListener = new HamburgerButtonHandler(this);
    private ActionListener actionListener2 = new menuFormToFlashCardsHandler(this);
    private ActionListener actionListener3 = new menuFormToApplicationFormHandler(this);
    private ActionListener logoutHandler = new LogoutHandler(this);

    private JPanel menuPanel;

   private Image hamburgerIcon;
   private JButton hamburgerIconButton;
   private JButton flashCardNavButton;
   private JButton applicationNavButton;
   private JButton logoutButton;

    private GUI gui;
}
