package com.stream.listeners;

import com.stream.controllers.MediaDetailsController;
import com.stream.models.Media;
import com.stream.viewmodels.MediaDetails;
import com.stream.views.CatalogView;
import com.stream.views.MediaDetailsView;
import java.awt.event.ActionEvent;


public class ClickMediaListener extends BaseListener {

    private Media media;

    public ClickMediaListener(CatalogView cv, Media media) {
        super(cv);
        this.media = media;
    }

    public void actionPerformed(ActionEvent e) {
        MediaDetails model = new MediaDetails(media);
        MediaDetailsView view = new MediaDetailsView();
        MediaDetailsController mdc = new MediaDetailsController(model, view);
        mdc.updateView();
    }
}