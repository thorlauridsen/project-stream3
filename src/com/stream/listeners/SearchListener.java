package com.stream.listeners;

import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import java.awt.event.ActionEvent;


public class SearchListener extends FilterListener {

    public SearchListener(CatalogView view, CatalogViewModel viewModel) {
        super(view, viewModel);
    }

    /**
     * Sends query to filterController and updates the view
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String query = view.getSearchQuery();

        filterController.setCatalog(viewModel, view);
        filterController.setSearchQuery(query);
        updateFilter();
    }
}
