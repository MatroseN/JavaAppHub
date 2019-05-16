package FlashCardModule;

import GUI.GUI;
import Handlers.CreateFlashCardButtonHandler;
import Handlers.SwitchCardBackward;
import Handlers.SwitchCardForward;
import Handlers.ToggleAnswerButtonHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FlashCardForm {
    public FlashCardForm(GUI gui){
        this.gui = gui;
        initialize();
    }

    private void initialize(){
        //Colors
        frameColors();
        textFieldColors();

        panelSetup();

        buildButtons();
        buildTextAreas();

        flashCardSetup();

        addElements();

        showCardAreaQuestion();
    }

    private void panelSetup(){
        flashCardPanel = new JPanel();
        flashCardPanel.setBackground(backgroundColor);
        flashCardPanel.setLayout(null);
        flashCardPanel.setVisible(false);
    }

    private void flashCardSetup(){
        flashCard = new Card("Who is U?", "Me? I am me");
    }

    public void createAndAddFlashCardSetup(){
        createAndAddFlashCard = new CreateAndAddFlashCard(this);
    }

    private void frameColors(){
        //frame
        red = 20;
        green = 20;
        blue = 20;
        backgroundColor = new Color(red, green, blue);
    }

    private Color flashCardColor(){
        Color color;
        red = 0;
        green = 50;
        blue = 60;
        color = new Color(red, green, blue);

        return color;
    }

    private Color flashCardTextColor(){
        Color color;
        red = 225;
        green = 225;
        blue = 225;
        color = new Color(red, green, blue);

        return color;
    }

    private Color toggleButtonColor(){
        Color color;
        red = 0;
        green = 50;
        blue = 60;
        color = new Color(red, green, blue);

        return color;
    }

    private Color toggleButtonTextColor(){
        Color color;
        red = 225;
        green = 225;
        blue = 225;
        color = new Color(red, green, blue);

        return color;
    }

    private void buildButtons(){
        toggleAnswerButton = new JButton();
        toggleAnswerButton.setBounds(350, 300, 120, 30);
        toggleAnswerButton.setText("Toggle Answer");
        toggleAnswerButton.addActionListener(actionListener);
        toggleAnswerButton.setBackground(toggleButtonColor());
        toggleAnswerButton.setForeground(toggleButtonTextColor());
        toggleAnswerButton.setOpaque(true);

        createNewCardButton = new JButton();
        createNewCardButton.setBounds(335, 450, 150, 30);
        createNewCardButton.setText("Create Flashcard");
        createNewCardButton.setBackground(toggleButtonColor());
        createNewCardButton.setForeground(toggleButtonTextColor());
        createNewCardButton.setOpaque(true);
        createNewCardButton.addActionListener(createFlashCardButtonHandler);

        switchFlashcardButton = new JButton();
        switchFlashcardButton.setBounds(500, 300, 100, 30);
        switchFlashcardButton.setText(">");
        switchFlashcardButton.setBackground(toggleButtonColor());
        switchFlashcardButton.setForeground(toggleButtonTextColor());
        switchFlashcardButton.setOpaque(true);
        switchFlashcardButton.addActionListener(switchCardForward);

        switchBackFlashCardButton = new JButton();
        switchBackFlashCardButton.setBounds(200, 300, 100, 30);
        switchBackFlashCardButton.setText("<");
        switchBackFlashCardButton.setBackground(toggleButtonColor());
        switchBackFlashCardButton.setForeground(toggleButtonTextColor());
        switchBackFlashCardButton.setOpaque(true);
        switchBackFlashCardButton.addActionListener(switchCardBackward);
        switchBackFlashCardButton.setVisible(false);
    }

    private void buildTextAreas(){
        cardArea = new JTextArea();

        cardArea.setEditable(false);
        cardArea.setBounds(200, 75, 400, 200);
        cardArea.setBackground(flashCardColor());
        cardArea.setForeground(flashCardTextColor());
        cardArea.setLineWrap(true);
        cardArea.setWrapStyleWord(true);
        cardArea.setFont(cardArea.getFont().deriveFont(18f));

        questionTextField = new JTextField();
        questionTextField.setBounds(220, 350, 300, 30);
        questionTextField.setBackground(textFieldColor);
        questionTextField.setForeground(textFieldTextColor);

        answerTextField = new JTextField();
        answerTextField.setBounds(220, 400, 300, 30);
        answerTextField.setBackground(textFieldColor);
        answerTextField.setForeground(textFieldTextColor);
    }

    public void showCardAreaQuestion(){
        cardArea.setText("Q: " + flashCard.getQuestion());
    }

    public void showCardAreaAnswer(){
        cardArea.setText("A: " + flashCard.getAnswer());
    }

    public Card getCurrentFlashcard() throws SQLException {
        Card card = flashCard;
        try {
            createAndAddFlashCard.getFlashCardsFromDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(flashCardIndex < createAndAddFlashCard.getFlashCardsFromDatabase().size()) {
            card = createAndAddFlashCard.getFlashCardsFromDatabase().get(flashCardIndex);
        }

        if(flashCardIndex == createAndAddFlashCard.getFlashCardsFromDatabase().size()){
            flashCardIndex = createAndAddFlashCard.getFlashCardsFromDatabase().size();
        }

        return card;
    }

    public void iterateFlashcardIndex(){
        try {
            if (flashCardIndex != createAndAddFlashCard.getFlashCardsFromDatabase().size()){
                flashCardIndex += 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void backFlashcardIndex(){
        if(flashCardIndex >=1) {
            flashCardIndex -= 1;
        }
    }

    public void resetFlashcardIndex(){
        flashCardIndex = 0;
    }

    public void setFlashCardIndex(int n){
        flashCardIndex = n;
    }

    public void setBackButtonVisible(){
        switchBackFlashCardButton.setVisible(true);
    }

    public void resetCreateFlashcardFields(){
        questionTextField.setText("");
        answerTextField.setText("");
    }

    public void resetCardAreaText(){
        cardArea.setText("press -> to continue");
    }

    public void updateCurrentFlashcard(){
        try {
            flashCard = getCurrentFlashcard();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        showCardAreaAnswer();
        showCardAreaQuestion();
    }

    private void addElements(){
        flashCardPanel.add(cardArea);
        flashCardPanel.add(toggleAnswerButton);
        flashCardPanel.add(createNewCardButton);
        flashCardPanel.add(switchFlashcardButton);
        flashCardPanel.add(switchBackFlashCardButton);
        flashCardPanel.add(questionTextField);
        flashCardPanel.add(answerTextField);
    }

    public void textFieldColors(){
        //Background
        red = 150;
        green = 150;
        blue = 165;
        textFieldColor = new Color(red, green, blue);

        //Foreground
        red = 32;
        green = 35;
        blue = 50;
        textFieldTextColor = new Color(red, green, blue);
    }

    public JPanel getFlashCardPanel(){
        return flashCardPanel;
    }

    public JTextArea getCardArea(){
        return  cardArea;
    }

    public Card getFlashCard(){
        return flashCard;
    }

    public GUI getGUI(){
        return gui;
    }

    public JTextField getQuestionTextField(){
        return questionTextField;
    }

    public JTextField getAnswerTextField(){
        return answerTextField;
    }

    public CreateAndAddFlashCard getCreateAndAddFlashCard(){
        return createAndAddFlashCard;
    }

    public boolean getIsPressed(){
        return isPressed;
    }

    public void setIsPressed(boolean f){
        isPressed = f;
    }

    private boolean isPressed = false;

    //Colors
    private Color backgroundColor;

    //RGB Colors
    private int red;
    private int green;
    private int blue;

    Color textFieldColor;
    Color textFieldTextColor;

    private JTextArea cardArea;
    private JTextField questionTextField;
    private JTextField answerTextField;

    private JButton toggleAnswerButton;
    private JButton createNewCardButton;
    private JButton switchFlashcardButton;
    private JButton switchBackFlashCardButton;

    private JPanel flashCardPanel;

    private Card flashCard;
    private GUI gui;

    private int flashCardIndex = 0;

    private SwitchCardForward switchCardForward = new SwitchCardForward(this);
    private SwitchCardBackward switchCardBackward = new SwitchCardBackward(this);
    private CreateAndAddFlashCard createAndAddFlashCard;
    private ActionListener actionListener = new ToggleAnswerButtonHandler(this);
    private ActionListener createFlashCardButtonHandler = new CreateFlashCardButtonHandler(this);
}