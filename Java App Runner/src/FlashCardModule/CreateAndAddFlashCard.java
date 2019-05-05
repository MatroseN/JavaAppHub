package FlashCardModule;

import java.sql.*;

import Database.DatabaseConnect;

public class CreateAndAddFlashCard {
    public CreateAndAddFlashCard(FlashCardForm flashCardForm){
        this.flashCardForm = flashCardForm;
        initialize();
    }

    private void initialize(){
        dbConnect = new DatabaseConnect();
        con = dbConnect.getCon();
        createCard();
        try {
            addCardToDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createCard(){
        card = new Card("Do you like Pancakes?", "Jag har ätit PANNKAKA!!!");
    }

    private void addCardToDatabase() throws SQLException {
        statement = dbConnect.getStatement();
        String query = "insert into flashcard(question, answer) values (?, ?)";

        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, card.getQuestion());
        preparedStatement.setString(2, card.getAnswer());

        preparedStatement.execute(query);
    }

    private int getActiveUserID() throws SQLException {
        String activeUserUsername = flashCardForm.getGUI().getActiveUser().getActiveUserUserName();
        statement = dbConnect.getStatement();
        String query = "select (userID) from useraccount where userName =(?)";

        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, activeUserUsername);
        System.out.println(activeUserUsername);

        resultSet = preparedStatement.executeQuery();

        int userID = 0;
        if(resultSet.next()){
            userID = resultSet.getInt(1);
        }
        System.out.println(userID);
        return userID;
    }

    private FlashCardForm flashCardForm;
    private Card card;

    private String question;
    private String answer;

    //Database
    private DatabaseConnect dbConnect;

    private Statement statement;
    private ResultSet resultSet;
    private Connection con;

}
