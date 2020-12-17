package com.stream.listeners;

import com.stream.controllers.FilterController;
import com.stream.exceptions.SearchException;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FilterListener implements ActionListener {

    protected CatalogView view;
    protected CatalogViewModel viewModel;
    protected FilterController filterController;

    public FilterListener(CatalogView view, CatalogViewModel viewModel) {
        this.view = view;
        this.viewModel = viewModel;
        this.filterController = FilterController.getInstance();
    }

    /**
     * Attempt to update the filter or display an alert to the user with a given message
     */
    public void updateFilter() {
        try {
            filterController.updateFilterView();
        } catch (SearchException ex) {
            view.showAlert(ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}