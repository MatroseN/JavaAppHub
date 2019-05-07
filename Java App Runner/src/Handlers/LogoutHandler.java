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
        menuForm.getGUI().setActiveForm(2);
    }

    private void logoutActiveUser(){
        menuForm.getGUI().logoutActiveUser();
    }

    private MenuForm menuForm;
}
