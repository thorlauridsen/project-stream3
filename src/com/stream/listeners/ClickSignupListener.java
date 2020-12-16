package com.stream.listeners;

import com.stream.controllers.SignupController;
import com.stream.viewmodels.SignupViewModel;
import com.stream.views.SignupView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClickSignupListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        SignupViewModel viewModel = new SignupViewModel();
        SignupView view = new SignupView();

        SignupController controller = new SignupController(viewModel, view);
        controller.updateView();
    }
}
