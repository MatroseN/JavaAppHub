package Handlers;

import GUI.CreateAccountForm;

import Default.CreateUserAccount;
import Database.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CreateAccountButtonHandler implements ActionListener{

    public CreateAccountButtonHandler(CreateAccountForm createAccountForm){

        dbConnect = new DatabaseConnect();
        con = dbConnect.getCon();

        this.createAccountForm = createAccountForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        createUserAccount();
    }

    private void createUserAccount(){

        try {
            if(checkUsernameAvailablility()){
                createAccountForm.getPasswordMissmatch().setText("Username already taken!");
                createAccountForm.setPasswordMissmatchVisibility(true);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (new String(createAccountForm.getPassWordFieldText()).equals(new String(createAccountForm.getPassWordVerifyFieldText()))) {
                createAccountForm.getPasswordMissmatch().setVisible(false);
                this.userName = createAccountForm.getUserNameFieldText();
                createUserAccount = new CreateUserAccount(userName, createAccountForm);
                createAccountForm.setPasswordMissmatchVisibility(false);
                createAccountForm.getGUI().setActiveForm(2);
            }

        else {
            createAccountForm.getPasswordMissmatch().setText("Passwords does not match!");
            createAccountForm.setPasswordMissmatchVisibility(true);
        }
    }

    private Boolean checkUsernameAvailablility() throws SQLException {
        String username = createAccountForm.getUserNameFieldText();

        String query = "select (userName) from useraccount where (userName=?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, username);
        resultSet = ps.executeQuery();

        if(resultSet.next()){
            return true;
        }else{
            return false;
        }

    }


    //User
    private CreateUserAccount createUserAccount;

    private String userName;
    private DatabaseConnect dbConnect;
    private Connection con;
    private Statement statement;
    private ResultSet resultSet;
    private CreateAccountForm createAccountForm;
}
