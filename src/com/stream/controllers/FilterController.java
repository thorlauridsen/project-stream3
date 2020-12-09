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
    private List<Media> searchList = null;
    private List<Media> selectedCategoryList = null;
    private List<Media> filteredList;
    private Catalog c;
    private CatalogView cv;

    public FilterController(Catalog c, CatalogView cv) {
        this.c = c;
        this.cv = cv;
        filteredList = c.getMediaList();
    }

    public static FilterController getInstance(Catalog c, CatalogView cv) {
        if (filterController == null) {
            filterController = new FilterController(c, cv);
        }
        return filterController;
    }

    public void setSearchList(List<Media> list) {
        searchList = list;
    }

    public void setSelectedCategoryList(List<Media> list) {
        selectedCategoryList = list;
    }

    public void updateFilterView() {

        if(searchList != null) {
            System.out.println("Size3: " + searchList.size());
        }
        if(selectedCategoryList != null) {
            System.out.println("Size4: " + selectedCategoryList.size());
        }

        System.out.println("Size5: " + filteredList.size());

        if(searchList != null) {
            filteredList = searchList;
        }
        filteredList.retainAll(selectedCategoryList);

        if(searchList != null) {
            System.out.println("Size32: " + searchList.size());
        }
        if(selectedCategoryList != null) {
            System.out.println("Size42: " + selectedCategoryList.size());
        }
        System.out.println("Size52: " + filteredList.size());

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
