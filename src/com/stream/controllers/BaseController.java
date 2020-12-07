package com.stream.controllers;

import com.stream.viewmodels.BaseViewModel;
import com.stream.views.BaseView;


public abstract class BaseController {

    protected BaseViewModel model;
    protected BaseView view;
    protected PageController pageController;

    public BaseController(BaseViewModel model, BaseView view) {
        this.model = model;
        this.view = view;
        this.pageController = PageController.getInstance();
    }

    public abstract void updateView();
}
