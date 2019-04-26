package Handlers;

import GUI.MenuForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuFormToApplicationFormHandler implements ActionListener {
    public menuFormToApplicationFormHandler(MenuForm menuForm){
        this.menuform = menuForm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        menuform.changeForm(3);
    }

    private MenuForm menuform;
}
