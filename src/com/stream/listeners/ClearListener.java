package com.stream.listeners;

import com.stream.controllers.CatalogController;
import com.stream.controllers.FilterController;
import com.stream.controllers.PageController;
import com.stream.viewmodels.Catalog;
import com.stream.views.CatalogView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Catalog c = new Catalog();
        CatalogView cv = new CatalogView();
        FilterController filterController = FilterController.getInstance();
        filterController.setCatalog(c, cv);

        CatalogController cc = new CatalogController(c, cv);
        cc.updateView();

        PageController pageController = PageController.getInstance();
        pageController.setView(cv.getPanel());
    }


}
