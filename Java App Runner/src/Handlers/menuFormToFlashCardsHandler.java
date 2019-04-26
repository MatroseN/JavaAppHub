package Handlers;

import GUI.MenuForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuFormToFlashCardsHandler implements ActionListener {
    public menuFormToFlashCardsHandler(MenuForm menuForm){
        this.menuform = menuForm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        menuform.changeForm(4);
    }

    private MenuForm menuform;
}
