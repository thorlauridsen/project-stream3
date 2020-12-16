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

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void updateFilter() {
        try {
            filterController.updateFilterView();
        } catch (SearchException e) {
            view.showSearchAlert(e.getMessage());
        }
    }

}