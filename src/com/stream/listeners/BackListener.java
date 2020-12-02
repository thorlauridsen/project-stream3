package com.stream.listeners;

import com.stream.controllers.CatalogController;
import com.stream.viewmodels.Catalog;
import com.stream.views.CatalogView;
import com.stream.views.MediaDetailsView;
import java.awt.event.ActionEvent;


public class BackListener extends BaseListener {

    public BackListener(MediaDetailsView mdv) {
        super(mdv);
    }

    public void actionPerformed(ActionEvent e) {
        view.setVisible(false);
        Catalog model = new Catalog();
        CatalogView view = new CatalogView();
        CatalogController mdc = new CatalogController(model, view);
        mdc.updateView();
    }
}