package com.stream.listeners;

import com.stream.controllers.LoginController;
import com.stream.exceptions.SignupException;
import com.stream.models.User;
import com.stream.models.UserManager;
import com.stream.viewmodels.LoginViewModel;
import com.stream.viewmodels.SignupViewModel;
import com.stream.views.LoginView;
import com.stream.views.SignupView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupListener implements ActionListener {

    private SignupViewModel viewModel;
    private SignupView view;

    public SignupListener(SignupView view, SignupViewModel viewModel) {
        this.view = view;
        this.viewModel = viewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = view.getUsername().trim();
        String pass = view.getPassword();
        String passAgain = view.getPasswordAgain();

        UserManager userManager = UserManager.getInstance();
        boolean isChild = view.isChildBoxSelected();

        try {
            if (userManager.attemptCreateAccount(name, pass, passAgain, isChild)) {

                LoginViewModel viewModel = new LoginViewModel();
                LoginView view = new LoginView();

                LoginController controller = new LoginController(viewModel, view);
                controller.updateView();
            }
        } catch (SignupException ex) {
            view.showAlert(ex.getMessage());
        }
    }
}
