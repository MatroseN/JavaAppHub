package Handlers;

import FlashCardModule.FlashCardForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchCardBackward implements ActionListener{
        public SwitchCardBackward(FlashCardForm flashCardForm){
            this.flashCardForm = flashCardForm;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            flashCardForm.backFlashcardIndex();
            flashCardForm.updateCurrentFlashcard();
        }

        private FlashCardForm flashCardForm;
}
