package Handlers;

import GUI.ApplicationForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EditMessageButtonHandler implements ActionListener{
    public EditMessageButtonHandler(ApplicationForm applicationForm){
        this.applicationForm = applicationForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setEditable();
    }

    /*Makes textarea Editable and Saving changes possible when first pressed.
    If pressed again it Makes the textarea Not Editable and hides the Save button.*/
    private void setEditable(){
        if(!applicationForm.getPersonalMessageArea().isEditable()) {
            applicationForm.getPersonalMessageArea().setEditable(true);
            applicationForm.getSaveNewMessageButton().setVisible(true);
        } else{
            applicationForm.getPersonalMessageArea().setEditable(false);
            applicationForm.getSaveNewMessageButton().setVisible(false);
        }
    }

    private ApplicationForm applicationForm;
}
