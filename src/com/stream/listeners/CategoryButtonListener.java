package com.stream.listeners;

import com.stream.controllers.FilterController;
import com.stream.controllers.PageController;
import com.stream.models.Media;
import com.stream.models.MediaPanel;
import com.stream.viewmodels.Catalog;
import com.stream.views.CatalogView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;


public class CategoryButtonListener extends BaseListener{

    private CatalogView cv;
    private Catalog c;
    private ArrayList<String> selectedCategoryList = new ArrayList<>();
    private boolean somethingChecked;

    public CategoryButtonListener(CatalogView cv, Catalog c) {
        super(cv);
        this.cv = cv;
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cv.clearMedia();
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
        if (somethingChecked) {
            medialist = filteredList;
        }

        FilterController filterController = FilterController.getInstance(c, cv);

        filterController.setSelectedCategoryList(medialist);
        filterController.updateFilterView();
    }
}