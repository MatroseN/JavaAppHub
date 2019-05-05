package Handlers;

import FlashCardModule.FlashCardForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchCardForward implements ActionListener {
    public SwitchCardForward(FlashCardForm flashCardForm){
        this.flashCardForm = flashCardForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(!isPressed) {
            flashCardForm.createAndAddFlashCardSetup();
            flashCardForm.setBackButtonVisible();
        }
        flashCardForm.iterateFlashcardIndex();
        flashCardForm.updateCurrentFlashcard();
        isPressed = true;
    }

    private boolean isPressed = false;
    private FlashCardForm flashCardForm;
}
