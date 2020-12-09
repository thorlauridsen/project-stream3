package com.stream.listeners;

import com.stream.controllers.FilterController;
import com.stream.models.Media;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class CategoryListener implements ActionListener {

    private CatalogView view;
    private CatalogViewModel viewModel;

    public CategoryListener(CatalogView view, CatalogViewModel viewModel) {
        this.view = view;
        this.viewModel = viewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> selectedCategoryList = new ArrayList<>();

        List<Media> mediaList = viewModel.getMediaList();
        List<Media> filteredList = new ArrayList<>();

        boolean somethingChecked = false;

        for (JCheckBox box : view.getCategoryBoxList()) {
            if (box.isSelected()) {
                selectedCategoryList.add(box.getText());
                somethingChecked = true;
            }
        }

        for (Media media : mediaList) {
            List<String> categories = media.getCategories();
            if (categories.containsAll(selectedCategoryList)) {
                filteredList.add(media);
            }
        }
        if (!somethingChecked) {
            filteredList.clear();
            filteredList.addAll(mediaList);
        }

        FilterController filterController = FilterController.getInstance();
        filterController.setCatalog(viewModel, view);
        filterController.setSelectedCategoryList(filteredList);
        filterController.updateFilterView();
    }
}