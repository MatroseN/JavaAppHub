package FlashCardModule;

import Handlers.SwitchToFlashCardFormHandler;
import Handlers.ToggleAnswerButtonHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FlashCardForm {
    public FlashCardForm(){
        initialize();
    }

    private void initialize(){
        //Colors
        frameColors();

        panelSetup();

        buildButtons();
        buildTextAreas();

        flashCardSetup();
        showCardAreaQuestion();

        addElements();
    }

    private void panelSetup(){
        flashCardPanel = new JPanel();
        flashCardPanel.setBackground(backgroundColor);
        flashCardPanel.setLayout(null);
        flashCardPanel.setVisible(false);
    }

    private void flashCardSetup(){
        question = new Question();
        answer = new Answer();
        flashCard = new Card(question, answer);
        flashCard.getQuestion().setQuestionText("Who are you?");
        flashCard.getAnswer().setAnswerText("I am me");
        questionText = "Question: " + flashCard.getQuestion().getQuestionText();
        answerText =  "Answer: " + flashCard.getAnswer().getAnswerText();
    }

    private void frameColors(){
        //frame
        red = 20;
        green = 20;
        blue = 20;
        backgroundColor = new Color(red, green, blue);
    }

    private void buildButtons(){
        toggleAnswerButton = new JButton();
        toggleAnswerButton.setBounds(350, 375, 120, 30);
        toggleAnswerButton.setText("Toggle Answer");
        toggleAnswerButton.addActionListener(actionListener);
    }

    private void buildTextAreas(){
        cardArea = new JTextArea();
        cardArea.setEditable(false);
        cardArea.setBounds(200, 150, 400, 200);
    }

    public void showCardAreaQuestion(){
        cardArea.setText(questionText + "\n" + "\n");
    }

    public void showCardAreaAnswer(){
        cardArea.setText(questionText + "\n" + "\n"  + answerText);
    }

    private void addElements(){
        flashCardPanel.add(cardArea);
        flashCardPanel.add(toggleAnswerButton);
    }

    public JPanel getFlashCardPanel(){
        return flashCardPanel;
    }

    public JTextArea getCardArea(){
        return  cardArea;
    }

    //Colors
    private Color backgroundColor;

    //RGB Colors
    private int red;
    private int green;
    private int blue;

    private JTextArea cardArea;
    private JButton toggleAnswerButton;

    private JPanel flashCardPanel;

    private Card flashCard;
    private Answer answer;
    private Question question;
    private String questionText;
    private String answerText;

    private ActionListener actionListener = new ToggleAnswerButtonHandler(this);
}
