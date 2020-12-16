package com.stream.controllers;

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
        pageController.setView(view.getPanel());
    }
}
