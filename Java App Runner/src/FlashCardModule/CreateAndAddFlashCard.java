package FlashCardModule;

import java.sql.*;
import java.util.ArrayList;

import Database.DatabaseConnect;

public class CreateAndAddFlashCard {
    public CreateAndAddFlashCard(FlashCardForm flashCardForm){
        this.flashCardForm = flashCardForm;
        initialize();
    }

    private void initialize(){
        dbConnect = new DatabaseConnect();
        con = dbConnect.getCon();
    }

    //Create a new Flash card if the text areas are not empty
    public void createCard(){
        if(!flashCardForm.getAnswerTextField().getText().isBlank() && !flashCardForm.getQuestionTextField().getText().isBlank()) {

            card = new Card(flashCardForm.getQuestionTextField().getText(), flashCardForm.getAnswerTextField().getText());

            try {
                addCardToDatabase();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            flashCardForm.resetCreateFlashcardFields();
            try {
                flashCardForm.setFlashCardIndex(getFlashCardsFromDatabase().size() - 1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            flashCardForm.updateCurrentFlashcard();

        }else {
            flashCardForm.getQuestionTextField().setText("Both Fields must have text!");
        }
    }

    private void addCardToDatabase() throws SQLException {
        statement = dbConnect.getStatement();
        String query = "insert into flashcard(question, answer, userID) values (?, ?, ?)";

        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, card.getQuestion());
        preparedStatement.setString(2, card.getAnswer());
        preparedStatement.setInt(3, getActiveUserID());

        preparedStatement.execute();
    }

    public ArrayList<Card> getFlashCardsFromDatabase() throws SQLException {
        ArrayList<Card> flashCards = new ArrayList<>();
        statement = dbConnect.getStatement();
        String query = "select question , answer from flashcard where userID=?";

        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, getActiveUserID());

        resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            question = resultSet.getString(1);
            answer = resultSet.getString(2);
            flashCards.add(new Card(question, answer));
        }
        return flashCards;
    }

    public int getActiveUserID() throws SQLException {
        String activeUserUsername = flashCardForm.getGUI().getActiveUser().getActiveUserUserName();
        statement = dbConnect.getStatement();
        String query = "select (userID) from useraccount where userName =(?)";

        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, activeUserUsername);

        resultSet = preparedStatement.executeQuery();

        int userID = 0;
        if(resultSet.next()){
            userID = resultSet.getInt(1);
        }
        return userID;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }

    private FlashCardForm flashCardForm;
    private Card card;

    private int cardIndex = 0;

    private String question = "";
    private String answer = "";

    //Database
    private DatabaseConnect dbConnect;

    private Statement statement;
    private ResultSet resultSet;
    private Connection con;
}
