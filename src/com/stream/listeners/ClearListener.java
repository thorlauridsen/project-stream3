package com.stream.listeners;

import com.stream.controllers.CatalogController;
import com.stream.controllers.FilterController;
import com.stream.controllers.PageController;
import com.stream.models.User;
import com.stream.models.UserManager;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClearListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        UserManager userManager = UserManager.getInstance();
        User user = userManager.getCurrentUser();
        user.setMyListToggled(false);

        CatalogViewModel viewModel = new CatalogViewModel();
        CatalogView view = new CatalogView();
        CatalogController controller = new CatalogController(viewModel, view);
        controller.updateView();

        FilterController filterController = FilterController.getInstance();
        filterController.setCatalog(viewModel, view);
        filterController.resetFilter();

        PageController pageController = PageController.getInstance();
        pageController.setView(view.getPanel());
    }
}
