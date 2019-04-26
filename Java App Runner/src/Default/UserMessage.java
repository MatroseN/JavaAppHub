package Default;

import java.sql.*;

import Database.DatabaseConnect;
import GUI.ApplicationForm;

public class UserMessage {

    public UserMessage(ApplicationForm applicationForm){
        dbConnect = new DatabaseConnect();
        con = dbConnect.getCon();
        this.applicationForm = applicationForm;
    }

    public void updateMessage() throws SQLException {
        message = applicationForm.getPersonalMessageArea().getText();
        statement = dbConnect.getStatement();
        String query = "update useraccount set userMessage=(?) where userName=(?)";

        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, message);
        preparedStatement.setString(2, applicationForm.getActiveUserUserName());

        preparedStatement.execute();
    }

    public String getUserMessageFromDatabase() throws SQLException{
        statement = dbConnect.getStatement();
        String query = "select (userMessage) from useraccount where (userName=?)";

        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, applicationForm.getActiveUserUserName());

        resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            message = resultSet.getString(1);
        }
        return message;
    }


    private String message;

    //Database
    private DatabaseConnect dbConnect;

    private Statement statement;
    private ResultSet resultSet;
    private Connection con;

    private ApplicationForm applicationForm;
}
