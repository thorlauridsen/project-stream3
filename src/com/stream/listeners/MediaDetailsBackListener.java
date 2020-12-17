package com.stream.listeners;

import com.stream.controllers.PageController;
import com.stream.models.User;
import com.stream.models.UserManager;

import java.awt.event.ActionEvent;

public class MediaDetailsBackListener extends BackListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        UserManager userManager = UserManager.getInstance();
        User user = userManager.getCurrentUser();

        pageController = PageController.getInstance();

        if (user.isMyListToggled()) {
            pageController.clearCatalog();

        } else {
            pageController.goBack();
        }
    }
}
