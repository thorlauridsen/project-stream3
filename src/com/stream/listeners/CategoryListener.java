package com.stream.listeners;

import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class CategoryListener extends FilterListener {

    public CategoryListener(CatalogView view, CatalogViewModel viewModel) {
        super(view, viewModel);
    }

    /**
     * Sends a list of selected categories to filterController
     * Updates the view with the specific filter
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> selectedCategoryList = new ArrayList<>();

        for (JCheckBox box : view.getCategoryBoxList()) {
            if (box.isSelected()) {
                selectedCategoryList.add(box.getText());
            }
        }
        filterController.setCatalog(viewModel, view);
        filterController.setMediaCategoryList(selectedCategoryList);
        updateFilter();
    }
}