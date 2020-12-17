package com.stream.listeners;

import com.stream.controllers.LoginController;
import com.stream.models.UserManager;
import com.stream.views.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LogoutListener implements ActionListener {

    /**
     * Logout the user and switch to login page
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        UserManager userManager = UserManager.getInstance();
        userManager.logout();

        LoginView view = new LoginView();
        LoginController controller = new LoginController(view);
        controller.updateView();
    }
}
