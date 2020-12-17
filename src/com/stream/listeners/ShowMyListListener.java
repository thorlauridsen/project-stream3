package com.stream.listeners;

import com.stream.models.User;
import com.stream.models.UserManager;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import java.awt.event.ActionEvent;


public class ShowMyListListener extends FilterListener {

    public ShowMyListListener(CatalogView view, CatalogViewModel viewModel) {
        super(view,viewModel);
    }

    /**
     * Toggles the user watch list and updates the view
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        UserManager userManager = UserManager.getInstance();
        User user = userManager.getCurrentUser();
        user.setMyListToggled(!user.isMyListToggled());

        filterController.setCatalog(viewModel, view);
        filterController.resetFilter();
        updateFilter();
    }
}
