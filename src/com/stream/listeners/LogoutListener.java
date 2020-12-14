package com.stream.listeners;

import com.stream.controllers.LoginController;
import com.stream.models.User;
import com.stream.models.UserManager;
import com.stream.viewmodels.LoginViewModel;
import com.stream.views.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        UserManager userManager = UserManager.getInstance();
        userManager.logout();

        LoginViewModel viewModel = new LoginViewModel();
        LoginView view = new LoginView();

        LoginController controller = new LoginController(viewModel, view);
        controller.updateView();
    }
}
