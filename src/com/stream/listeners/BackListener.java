package com.stream.listeners;

import com.stream.controllers.PageController;
import com.stream.views.MediaDetailsView;
import java.awt.event.ActionEvent;


public class BackListener extends BaseListener {

    public BackListener(MediaDetailsView mdv) {
        super(mdv);
    }

    public void actionPerformed(ActionEvent e) {
        PageController pageController = PageController.getInstance();
        pageController.goBack();
    }
}