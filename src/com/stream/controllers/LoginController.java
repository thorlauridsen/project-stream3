package com.stream.controllers;

import com.stream.listeners.ClickSignupListener;
import com.stream.listeners.LoginListener;
import com.stream.views.LoginView;


public class LoginController extends BaseController {

    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    /**
     * Populates and displays the view using pageController
     */
    public void updateView() {
        view.updateView();
        view.addPasswordField(new LoginListener(view));
        view.addSubmitButton(new LoginListener(view), "Login");
        view.addSignUpButton(new ClickSignupListener());
        pageController.setView(view.getPanel());
    }
}
