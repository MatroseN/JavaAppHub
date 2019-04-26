package Handlers;

import GUI.ApplicationForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SaveMessageButtonHandler implements ActionListener {
    public SaveMessageButtonHandler(ApplicationForm applicationForm){
        this.applicationForm = applicationForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            applicationForm.getUserMessage().updateMessage();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    private ApplicationForm applicationForm;
}
