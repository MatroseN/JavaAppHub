package Default;

import Database.DatabaseConnect;
import GUI.CreateAccountForm;

import java.sql.*;

public class CreateUserAccount {

    public CreateUserAccount(String userName, CreateAccountForm createAccountForm){
        this.userName = userName;
        dbConnect = new DatabaseConnect();
        con = dbConnect.getCon();
        this.createAccountForm = createAccountForm;

        try {
            addUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser() throws SQLException {
        statement = dbConnect.getStatement();
        String query = "insert into useraccount(userName, pass) values (?, SHA1(?))";

        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, new String(createAccountForm.getPassWordFieldText()));

        preparedStatement.execute();
        con.close();
    }

    private String userName;


    //Database
    private DatabaseConnect dbConnect;

    private Statement statement;
    private ResultSet resultSet;
    private Connection con;
    private CreateAccountForm createAccountForm;
}
