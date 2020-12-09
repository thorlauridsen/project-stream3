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

    private CatalogView cv;
    private CatalogViewModel c;
    private ArrayList<String> selectedCategoryList = new ArrayList<>();
    private boolean somethingChecked;

    public CategoryListener(CatalogView cv, CatalogViewModel c) {
        this.cv = cv;
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        selectedCategoryList.clear();

        List<Media> medialist = c.getMediaList();
        List<Media> filteredList = new ArrayList<>();

        somethingChecked = false;

        for (JCheckBox box : cv.getCategoryBoxList()) {
            if (box.isSelected()) {
                selectedCategoryList.add(box.getText());
                somethingChecked = true;
            }
        }

        for (Media m : medialist) {
            List<String> categories = m.getCategories();
            if (categories.containsAll(selectedCategoryList)) {
                filteredList.add(m);
            }
        }
        if (!somethingChecked) {
            filteredList.clear();
            filteredList.addAll(medialist);
        }

        FilterController filterController = FilterController.getInstance();
        filterController.setCatalog(c, cv);
        filterController.setSelectedCategoryList(filteredList);
        filterController.updateFilterView();
    }
}