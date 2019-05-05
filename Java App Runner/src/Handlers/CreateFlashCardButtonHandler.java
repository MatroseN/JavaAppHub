package Handlers;

import FlashCardModule.CreateAndAddFlashCard;
import FlashCardModule.FlashCardForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateFlashCardButtonHandler implements ActionListener {
    public CreateFlashCardButtonHandler(FlashCardForm flashCardForm){
        this.flashCardForm = flashCardForm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        createAndAddFlashCard();
    }

    private void createAndAddFlashCard(){
        createAndAddFlashCard = new CreateAndAddFlashCard(flashCardForm);
    }

    private CreateAndAddFlashCard createAndAddFlashCard;
    private FlashCardForm flashCardForm;
}
