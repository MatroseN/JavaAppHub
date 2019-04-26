package Handlers;

import GUI.GUI;
import GUI.MenuForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HamburgerButtonHandler implements ActionListener {
    public HamburgerButtonHandler(MenuForm menuForm){
        this.menuForm = menuForm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        toggleDropDown();
    }

    private void toggleDropDown(){
        menuForm.getGUI().toggleDropDown();
    }

    private GUI gui;
    private MenuForm menuForm;
}
