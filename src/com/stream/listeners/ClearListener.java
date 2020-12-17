package com.stream.listeners;

import com.stream.controllers.PageController;
import com.stream.models.User;
import com.stream.models.UserManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClearListener implements ActionListener {

    /**
     * Clears the catalog view and displays all media again
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        UserManager userManager = UserManager.getInstance();
        User user = userManager.getCurrentUser();
        user.setMyListToggled(false);

        PageController pageController = PageController.getInstance();
        pageController.clearCatalog();
    }
}
