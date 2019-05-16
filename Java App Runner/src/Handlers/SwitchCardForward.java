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

        if(!flashCardForm.getIsPressed()) {
            flashCardForm.createAndAddFlashCardSetup();
            flashCardForm.updateCurrentFlashcard();
            flashCardForm.setBackButtonVisible();
            flashCardForm.setIsPressed(true);
            return;
        }

        flashCardForm.iterateFlashcardIndex();
        flashCardForm.updateCurrentFlashcard();
    }

    private FlashCardForm flashCardForm;
}
