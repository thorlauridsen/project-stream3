package com.stream.listeners;

import com.stream.controllers.FilterController;
import com.stream.controllers.PageController;
import com.stream.models.Media;
import com.stream.models.MediaPanel;
import com.stream.viewmodels.Catalog;
import com.stream.views.CatalogView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class SearchListener implements ActionListener {

    private CatalogView cv;
    private Catalog c;

    public SearchListener(CatalogView cv, Catalog c) {
        this.cv = cv;
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String query = cv.getSearchQuery().toLowerCase();
        List<Media> mediaList = c.getMediaList();
        List<Media> newList = new ArrayList<>();
        for(Media m : mediaList) {
            String title = m.getTitle().toLowerCase();
            if (title.contains(query)){
                newList.add(m);
            }

        }
        FilterController filterController = FilterController.getInstance();
        filterController.setCatalog(c, cv);
        filterController.setSearchList(newList);
        filterController.updateFilterView();
    }
}
