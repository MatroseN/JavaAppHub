package Handlers;

import GUI.LoginForm;
import Database.*;
import Default.CreateUserAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import org.apache.commons.codec.digest.DigestUtils;

public class LoginButtonHandler{

    public LoginButtonHandler(JButton button, JTextField userNameField, JTextField passwordField, LoginForm loginForm){
        this.button = button;
        this.userNameField = userNameField;
        this.passwordField = passwordField;

        dbConnect = new DatabaseConnect();
        con = dbConnect.getCon();

        this.loginForm = loginForm;

        createActionListener();
    }

    public void createActionListener(){
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(checkLoginDetails()){
                        loginForm.changeToApplicationForm();
                    }

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        };

    }

    private Boolean checkLoginDetails() throws SQLException{

        String username = loginForm.getUserNameFieldText();
        String pass = convertStringToSHA1(new String(loginForm.getPasswordField().getPassword()));
        statement = dbConnect.getStatement();

        String query = "select * from useraccount where (userName=? and pass=?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, pass);
        resultSet = ps.executeQuery();

        //True = username exists
        if(!resultSet.next()){
            return false;
        }else{
            userName = username;
            return true;
        }

    }

    private String convertStringToSHA1(String string){
        string = DigestUtils.sha1Hex(string);
        return string;
    }

    public String getUserNameOfSuccessfulLogin(){
        return userName;
    }

    public ActionListener getActionListener(){
        return actionListener;
    }

    private JTextField userNameField;
    private JTextField passwordField;

    private JButton button;

    //User
    private CreateUserAccount createUserAccount;

    private String userName;
    private DatabaseConnect dbConnect;
    private Connection con;
    private Statement statement;
    private ResultSet resultSet;
    private LoginForm loginForm;

    private ActionListener actionListener;
}
