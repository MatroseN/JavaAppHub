package Handlers;

import GUI.MenuForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutHandler implements ActionListener {
    public LogoutHandler(MenuForm menuForm){
        this.menuForm = menuForm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        logoutActiveUser();

    }

    private void logoutActiveUser(){
        menuForm.getGUI().logoutActiveUser();
        menuForm.getGUI().setActiveForm(2);
        menuForm.getGUI().getFlashcardform().resetCardAreaText();
        menuForm.getGUI().getFlashcardform().resetFlashcardIndex();
        menuForm.getGUI().getFlashcardform().resetCreateFlashcardFields();
        menuForm.getGUI().getFlashcardform().setIsPressed(false);
    }

    private MenuForm menuForm;
}
