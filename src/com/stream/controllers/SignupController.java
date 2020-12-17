package com.stream.controllers;

import com.stream.listeners.BackListener;
import com.stream.listeners.SignupListener;
import com.stream.views.SignupView;


public class SignupController extends BaseController {

    private SignupView view;

    public SignupController(SignupView view) {
        this.view = view;
    }

    /**
     * Populates and displays the view using pageController
     */
    public void updateView() {
        view.updateView();
        view.addPasswordField(null);
        view.addPasswordAgainField(new SignupListener(view));
        view.addSubmitButton(new SignupListener(view), "Sign Up");
        view.addBackButton(new BackListener());
        pageController.setView(view.getPanel());
    }
}
