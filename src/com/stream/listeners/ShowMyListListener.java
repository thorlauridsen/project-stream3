package com.stream.listeners;

import com.stream.controllers.FilterController;
import com.stream.models.User;
import com.stream.models.UserManager;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ShowMyListListener implements ActionListener {

    private CatalogView view;
    private CatalogViewModel viewModel;

    public ShowMyListListener(CatalogView view, CatalogViewModel viewModel) {
        this.view = view;
        this.viewModel = viewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserManager userManager = UserManager.getInstance();
        User user = userManager.getCurrentUser();
        user.setMyListToggled(!user.isMyListToggled());

        FilterController filterController = FilterController.getInstance();
        filterController.setCatalog(viewModel, view);
        filterController.resetFilter();
        filterController.updateFilterView();
    }
}
