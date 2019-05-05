package FlashCardModule;

import GUI.GUI;
import Handlers.CreateFlashCardButtonHandler;
import Handlers.ToggleAnswerButtonHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FlashCardForm {
    public FlashCardForm(GUI gui){
        this.gui = gui;
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
        toggleAnswerButton.setBounds(350, 375, 120, 30);
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
    }

    private void buildTextAreas(){
        cardArea = new JTextArea();
        cardArea.setEditable(false);
        cardArea.setBounds(200, 150, 400, 200);
        cardArea.setBackground(flashCardColor());
        cardArea.setForeground(flashCardTextColor());
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
        flashCardPanel.add(createNewCardButton);
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

    //Colors
    private Color backgroundColor;

    //RGB Colors
    private int red;
    private int green;
    private int blue;

    private JTextArea cardArea;
    private JButton toggleAnswerButton;
    private JButton createNewCardButton;

    private JPanel flashCardPanel;

    private Card flashCard;
    private GUI gui;

    private ActionListener actionListener = new ToggleAnswerButtonHandler(this);
    private ActionListener createFlashCardButtonHandler = new CreateFlashCardButtonHandler(this);
}
