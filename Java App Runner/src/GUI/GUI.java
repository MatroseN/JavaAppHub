package GUI;

import Default.ActiveUser;
import FlashCardModule.FlashCardForm;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class GUI{
    public GUI() {
        initialize();
    }

    private void initialize() {
        menuBarPanelSetup();
        createAccountFormSetup();
        loginFormSetup();
        flashCardPanelSetup();
        applicationPanelSetup();
        buildWindow();
    }


    private void buildWindow() {
        //Change look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        buildAndSetupFrame();

        panelSetup();

        setActiveForm(2);
    }

    //The active form will be the form rendered
    public void setActiveForm(int n) {
        //Create Account Panel
        if(n == 1) {
            loginPanel.setVisible(false);
            applicationPanel.setVisible(false);
            createAccountPanel.setVisible(true);
        }
        //Login Panel                                       //COMMENT: Make this a Switch statement
        if(n == 2) {
            createAccountPanel.setVisible(false);
            applicationPanel.setVisible(false);
            loginPanel.setVisible(true);
        }
        //Application Panel
        if(n == 3){
            setActiveUser();
            try {
                applicationForm.userMessageSetup();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                applicationForm.getUserMessage().getUserMessageFromDatabase();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            loginPanel.setVisible(false);
            createAccountPanel.setVisible(false);
            applicationPanel.setVisible(true);
        }
        if(n == 4){
            loginPanel.setVisible(false);
            createAccountPanel.setVisible(false);
            applicationPanel.setVisible(false);
            flashCardPanel.setVisible(true);
        }
    }

    //Sets the different attributes for the panels
    public void panelSetup(){
        menuBarPanel.setSize(800, 60);
        menuBarPanel.setBounds(0, 0, 800, 30);
        menuBarPanel.setBackground(menuForm.getBackgroundColor());
        createAccountPanel.setBounds(0, 30, 800, 570);
        createAccountPanel.setBackground(createAccountForm.getBackgroundColor());
        loginPanel.setBounds(0, 30, 800, 570);
        loginPanel.setBackground(loginForm.getBackgroundColor());
        applicationPanel.setBounds(0, 30, 800, 570);
        applicationPanel.setBackground(applicationForm.getBackgroundColor());
        flashCardPanel.setSize(800, 570);
        flashCardPanel.setBackground(applicationForm.getBackgroundColor());
        flashCardPanel.setBounds(0, 30, 800, 570);
    }

    public void toggleDropDown(){
        if(menuBarPanel.getBounds().height == 30) {
            menuBarPanel.setBounds(0, 0, 800, 60);
        }else{
            menuBarPanel.setBounds(0, 0, 800, 30);
        }
    }

    //Builds a new frame and sets the attributes for the frame
    public void buildAndSetupFrame(){
        frame = new JFrame("Login");

        //Window size and location
        frame.setSize(800, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        //More options
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(menuBarPanel);
        frame.add(createAccountPanel);
        frame.add(loginPanel);
        frame.add(applicationPanel);
        frame.add(flashCardPanel);
    }

    //Adds the different ui elements for the Create Account Panel
    public void createAccountFormSetup() {
        createAccountForm = new CreateAccountForm(this);

        createAccountPanel = createAccountForm.getCreateAccountForm();
        createAccountPanel.add(createAccountForm.getLoginFormButton());
        createAccountPanel.add(createAccountForm.getPasswordField());
        createAccountPanel.add(createAccountForm.getPasswordMissmatch());
        createAccountPanel.add(createAccountForm.getPasswordVerifyField());
    }

    //Adds the different ui elements for the Login Panel
    public void loginFormSetup() {
        loginForm = new LoginForm(this);

        loginPanel = loginForm.getLoginForm();
        loginPanel.add(loginForm.getUserNameField());
        loginPanel.add(loginForm.getPasswordField());
        loginPanel.add(loginForm.getLoginButton());
        loginPanel.add(loginForm.getChangeFormButton());
    }


    //Adds the different ui elements for the MenuBar Panel
    public void menuBarPanelSetup(){
        menuForm = new MenuForm(this);

        menuBarPanel = menuForm.getMenuPanel();
        menuBarPanel.add(menuForm.getHamburgerIconButton());
        menuBarPanel.add(menuForm.getFlashCardNavButton());
    }

    ////Adds the different ui elements for the Application Panel
    public void applicationPanelSetup(){
        applicationForm = new ApplicationForm(this);

        applicationPanel = applicationForm.getApplicationPanel();
        applicationPanel.add(applicationForm.getPersonalMessageArea());
        applicationPanel.add(applicationForm.getSaveNewMessageButton());
    }

    public void flashCardPanelSetup(){
        flashCardForm = new FlashCardForm();

        flashCardPanel = flashCardForm.getFlashCardPanel();
        flashCardPanel.add(flashCardForm.getCardArea());
    }

    public GUI getGui() {
        return this;
    }

    public ActiveUser getActiveUser(){
        return activeUser;
    }

    public void setActiveUser(){
        activeUser = new ActiveUser(loginForm.getUserNameOfSucessfulLogin());
    }

    //Frame
    private JFrame frame;

    //RGB Colors
    private int red;
    private int green;
    private int blue;

    //Forms
    private CreateAccountForm createAccountForm;
    private LoginForm loginForm;
    private MenuForm menuForm;
    private ApplicationForm applicationForm;
    private FlashCardForm flashCardForm;

    private JPanel createAccountPanel;
    private JPanel loginPanel;
    private JPanel menuBarPanel;
    private JPanel applicationPanel;
    private JPanel flashCardPanel;

    private ActiveUser activeUser;
}