package com.stream.listeners;

import com.stream.controllers.PageController;
import com.stream.views.MediaDetailsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BackListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        PageController pageController = PageController.getInstance();
        pageController.goBack();
    }
}