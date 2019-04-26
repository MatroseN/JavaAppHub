package Handlers;

import GUI.CreateAccountForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchToLoginFormHandler implements ActionListener{

    public SwitchToLoginFormHandler(CreateAccountForm createAccountForm){
        this.createAccountForm = createAccountForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        createAccountForm.changeToLoginForm();
    }

    private CreateAccountForm createAccountForm;
}
