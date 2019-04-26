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
        toggleAnswer();
    }

    private void toggleAnswer(){
        if(!hideAnswer){
            flashCardForm.showCardAreaAnswer();
            hideAnswer = true;
            return;
        }

        if(hideAnswer){
            flashCardForm.showCardAreaQuestion();
            hideAnswer = false;
            return;
        }

    }
    private FlashCardForm flashCardForm;
    private boolean hideAnswer = false;
}
