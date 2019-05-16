package Handlers;

import GUI.MenuForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchFormHandler implements ActionListener {
    public SwitchFormHandler(MenuForm menuForm){
        this.menuform = menuForm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        menuform.changeForm(5);
    }

    private MenuForm menuform;
}
