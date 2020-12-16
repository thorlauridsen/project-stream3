package com.stream.controllers;

import com.stream.listeners.SignupListener;
import com.stream.viewmodels.SignupViewModel;
import com.stream.views.SignupView;


public class SignupController extends BaseController {

    private SignupViewModel viewModel;
    private SignupView view;

    public SignupController(SignupViewModel viewModel, SignupView view) {
        this.viewModel = viewModel;
        this.view = view;
    }

    /**
     * Populates and displays the view using pageController
     */
    public void updateView() {
        view.updateView();
        view.addPasswordField(null);
        view.addPasswordAgainField(new SignupListener(view, viewModel));
        view.addSubmitButton(new SignupListener(view, viewModel), "Sign Up");
        pageController.setView(view.getPanel());
    }
}
