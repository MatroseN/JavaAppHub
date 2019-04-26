package Handlers;

import FlashCardModule.FlashCardForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToggleAnswerButtonHandler implements ActionListener {
    public ToggleAnswerButtonHandler(FlashCardForm flashCardForm){
        this.flashCardForm = flashCardForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(flashCardForm.getCardArea().getText()) {
            flashCardForm.showCardAreaAnswer();
        }
    }
    private FlashCardForm flashCardForm;
}
