package Handlers;

import FlashCardModule.CreateAndAddFlashCard;
import FlashCardModule.FlashCardForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CreateFlashCardButtonHandler implements ActionListener {
    public CreateFlashCardButtonHandler(FlashCardForm flashCardForm){
        this.flashCardForm = flashCardForm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        createAndAddFlashCard();
        flashCardForm.createAndAddFlashCardSetup();
    }

    private void createAndAddFlashCard(){
        createAndAddFlashCard = new CreateAndAddFlashCard(flashCardForm);
        createAndAddFlashCard.createCard();
        try {
            createAndAddFlashCard.getFlashCardsFromDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        flashCardForm.resetCreateFlashcardFields();
    }

    private CreateAndAddFlashCard createAndAddFlashCard;
    private FlashCardForm flashCardForm;
}
