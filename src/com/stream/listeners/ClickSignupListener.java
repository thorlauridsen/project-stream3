package com.stream.listeners;

import com.stream.controllers.SignupController;
import com.stream.views.SignupView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClickSignupListener implements ActionListener {

    /**
     * Displays SignupView when clicked
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        SignupView view = new SignupView();

        SignupController controller = new SignupController(view);
        controller.updateView();
    }
}
