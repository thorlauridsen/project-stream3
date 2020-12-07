package com.stream.controllers;

import com.stream.listeners.ClickMediaListener;
import com.stream.listeners.SearchListener;
import com.stream.viewmodels.Catalog;
import com.stream.models.Media;
import com.stream.views.CatalogView;
import java.util.List;


public class CatalogController extends BaseController {

    private Catalog c;
    private CatalogView cv;

    public CatalogController(Catalog c, CatalogView cv) {
        super(c, cv);
        this.c = c;
        this.cv = cv;
    }

    @Override
    public void updateView() {
        List<Media> mediaList = c.getMediaList();

        cv.updateView(mediaList.size());
        cv.addCategoryPanel(c.getCategories().size());

        addCategories();
        cv.updateToolBar();
        cv.addSearchButton(new SearchListener(cv, c));

        for (Media media : mediaList) {
            cv.addMedia(media, new ClickMediaListener(cv, media));
        }
        pageController.setView(cv.getPanel());
    }

    public void addCategories() {
        for(String s : c.getCategories()) {
            cv.addCategoryButton(s);
        }
    }
}