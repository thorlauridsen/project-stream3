package com.stream.controllers;


public abstract class BaseController {

    protected PageController pageController;

    public BaseController() {
        pageController = PageController.getInstance();
    }
}
