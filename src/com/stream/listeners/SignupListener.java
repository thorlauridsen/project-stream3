package com.stream.listeners;

import com.stream.controllers.LoginController;
import com.stream.exceptions.SignupException;
import com.stream.models.UserManager;
import com.stream.views.LoginView;
import com.stream.views.SignupView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupListener implements ActionListener {

    private SignupView view;

    public SignupListener(SignupView view) {
        this.view = view;
    }

    /**
     * Attempts to create account with the entered information or display an alert to the user
     * If signup is successful the page switches to LoginView
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = view.getUsername().trim();
        String pass = view.getPassword();
        String passAgain = view.getPasswordAgain();

        UserManager userManager = UserManager.getInstance();
        boolean isChild = view.isChildBoxSelected();

        try {
            if (userManager.attemptCreateAccount(name, pass, passAgain, isChild)) {
                LoginView view = new LoginView();

                LoginController controller = new LoginController(view);
                controller.updateView();
            }
        } catch (SignupException ex) {
            view.showAlert(ex.getMessage());
        }
    }
}
