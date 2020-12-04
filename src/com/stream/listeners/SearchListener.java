package com.stream.listeners;

import com.stream.models.Media;
import com.stream.viewmodels.Catalog;
import com.stream.views.CatalogView;


import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchListener extends BaseListener{

    private CatalogView cv;
    private Catalog c;

    public SearchListener(CatalogView cv, Catalog c) {
        super(cv);
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

        cv.clearMedia();

        for (Media m : newList) {
            cv.addMedia(m, new ClickMediaListener(cv, m));
        }
        cv.updateView(newList.size());
        cv.display();
    }
}
