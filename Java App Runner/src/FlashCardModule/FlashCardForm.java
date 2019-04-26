package FlashCardModule;

import Handlers.ToggleAnswerButtonHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
        cardArea.setText(flashCard.getQuestion());
    }

    public void showCardAreaAnswer(){
        cardArea.setText(flashCard.getAnswer());
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

    public Card getFlashCard(){
        return flashCard;
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

    private ActionListener actionListener = new ToggleAnswerButtonHandler(this);
}
