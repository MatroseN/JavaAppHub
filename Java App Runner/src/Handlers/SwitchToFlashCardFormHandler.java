package Handlers;

import GUI.MenuForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchToFlashCardFormHandler implements ActionListener {
    public SwitchToFlashCardFormHandler(MenuForm menuForm){
        this.menuform = menuForm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        menuform.changeToFlashCardForm();
    }

    private MenuForm menuform;
}
