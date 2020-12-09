package com.stream.controllers;

import com.stream.listeners.*;
import com.stream.models.MediaPanel;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.models.Media;
import com.stream.views.CatalogView;
import java.util.List;


public class CatalogController extends BaseController {

    private CatalogViewModel c;
    private CatalogView cv;

    public CatalogController(CatalogViewModel c, CatalogView cv) {
        super(c, cv);
        this.c = c;
        this.cv = cv;
    }

    @Override
    public void updateView() {
        List<Media> mediaList = c.getMediaList();

        cv.updateView(mediaList.size());
        cv.addCategoryPanel(c.getUniqueCategories().size());

        addCategories();
        cv.addHomeButton(new ClearListener());
        cv.addSearchField(new SearchListener(cv, c));
        cv.addClearButton(new ClearListener());
        cv.addSearchButton(new SearchListener(cv, c));
        cv.addMyListButton(new ShowMyListListener(cv, c));

        for (Media media : mediaList) {
            MediaPanel mp = new MediaPanel(media, new ClickMediaListener(media));
            cv.addMedia(mp.getPanel());
        }
        pageController.setView(cv.getPanel());
    }

    public void addCategories() {
        for (String s : c.getUniqueCategories()) {
            cv.addCategoryButton(s, new CategoryListener(cv, c));
        }
    }
}