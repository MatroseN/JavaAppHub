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
    }

    private MenuForm menuForm;
}
