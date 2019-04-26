package Handlers;

import GUI.LoginForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchToCreateAccountFormHandler implements ActionListener{
    public SwitchToCreateAccountFormHandler(LoginForm loginForm){
        this.loginform = loginForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        loginform.changeToCreateAccountForm();
    }

    private LoginForm loginform;
}
