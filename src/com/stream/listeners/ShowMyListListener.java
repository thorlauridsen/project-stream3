package com.stream.listeners;

import com.stream.controllers.FilterController;
import com.stream.models.User;
import com.stream.models.UserManager;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ShowMyListListener implements ActionListener {

    private CatalogView catalogView;
    private CatalogViewModel catalogViewModel;

    public ShowMyListListener(CatalogView catalogView, CatalogViewModel catalogViewModel) {
        this.catalogView = catalogView;
        this.catalogViewModel = catalogViewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserManager userManager = UserManager.getInstance();
        User user = userManager.getCurrentUser();
        user.setMyListToggled(!user.isMyListToggled());

        FilterController filterController = FilterController.getInstance();
        filterController.setCatalog(catalogViewModel, catalogView);
        filterController.updateFilterView();
    }
}
