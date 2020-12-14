package com.stream.controllers;

import com.stream.models.UserManager;


public abstract class BaseController {

    protected PageController pageController;
    protected UserManager userManager;

    public BaseController() {
        pageController = PageController.getInstance();
        userManager = UserManager.getInstance();
    }
}
