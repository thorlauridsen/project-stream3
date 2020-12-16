package com.stream.listeners;

import com.stream.controllers.LoginController;
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

        if (name != null && pass != null && passAgain != null) {
            if (!name.isEmpty() && !pass.isEmpty() && !passAgain.isEmpty()) {

                if (!userManager.doesAccountExist(name)) {
                    if (pass.equalsIgnoreCase(passAgain)) {

                        boolean isChild = view.isChildBoxSelected();
                        userManager.createAccount(name, pass, isChild);

                        LoginViewModel viewModel = new LoginViewModel();
                        LoginView view = new LoginView();

                        LoginController controller = new LoginController(viewModel, view);
                        controller.updateView();

                    } else {
                        view.showAlert("Passwords do not match!");
                    }
                } else {
                    view.showAlert("There already exists an account with this username!");
                }
            } else {
                view.showAlert("Please fill out the required fields!");
            }
        } else {
            view.showAlert("Please fill out the required fields!");
        }
    }
}
