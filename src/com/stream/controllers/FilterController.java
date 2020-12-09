package com.stream.controllers;

import com.stream.listeners.ClickMediaListener;
import com.stream.models.Media;
import com.stream.models.MediaPanel;
import com.stream.viewmodels.Catalog;
import com.stream.views.CatalogView;

import java.util.ArrayList;
import java.util.List;

public class FilterController {

    private static FilterController filterController = null;
    private List<Media> searchList = new ArrayList<>();
    private List<Media> selectedCategoryList = new ArrayList<>();
    private List<Media> filteredList = new ArrayList<>();
    private Catalog c;
    private CatalogView cv;

    public FilterController(Catalog c, CatalogView cv) {
        this.c = c;
        this.cv = cv;
        searchList.addAll(c.getMediaList());
        selectedCategoryList.addAll(c.getMediaList());
    }

    public static FilterController getInstance(Catalog c, CatalogView cv) {
        if (filterController == null) {
            filterController = new FilterController(c, cv);
        }
        return filterController;
    }

    public void setSearchList(List<Media> list) {
        searchList.clear();
        searchList.addAll(list);
    }

    public void setSelectedCategoryList(List<Media> list) {
        selectedCategoryList.clear();
        selectedCategoryList.addAll(list);
    }

    public void updateFilterView() {
        filteredList.clear();

        filteredList.addAll(searchList);


        filteredList.retainAll(selectedCategoryList);


        cv.clearMedia();

        for (Media media : filteredList) {
            MediaPanel mp = new MediaPanel(media, new ClickMediaListener(cv, media));
            cv.addMedia(mp.getPanel());
        }
        cv.updateView(filteredList.size());

        PageController pageController = PageController.getInstance();
        pageController.setView(cv.getPanel());
    }



}
