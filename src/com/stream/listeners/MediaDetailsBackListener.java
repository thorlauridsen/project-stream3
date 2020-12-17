package com.stream.listeners;

import com.stream.controllers.PageController;
import com.stream.models.User;
import com.stream.models.UserManager;

import java.awt.event.ActionEvent;

public class MediaDetailsBackListener extends BackListener {

    /**
     * Return to previous page
     * If the user has isMyListToggled then it will update the entire page
     * This is to ensure that the user sees the correct list after potentially updating it
     */
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
