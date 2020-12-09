package com.stream.listeners;

import com.stream.controllers.MediaDetailsController;
import com.stream.models.Media;
import com.stream.viewmodels.MediaDetails;
import com.stream.views.MediaDetailsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClickMediaListener implements ActionListener {

    private Media media;

    public ClickMediaListener(Media media) {
        this.media = media;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MediaDetails model = new MediaDetails(media);
        MediaDetailsView view = new MediaDetailsView();
        MediaDetailsController mdc = new MediaDetailsController(model, view);
        mdc.updateView();
    }
}