package com.stream.listeners;

import com.stream.controllers.PageController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BackListener implements ActionListener {

    protected PageController pageController;

    public BackListener() {
        pageController = PageController.getInstance();
    }

    /**
     * Returns to previous page using pageController
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        pageController.goBack();
    }
}