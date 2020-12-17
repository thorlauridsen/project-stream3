package com.stream.listeners;

import com.stream.controllers.MediaDetailsController;
import com.stream.models.Media;
import com.stream.viewmodels.MediaDetailsViewModel;
import com.stream.views.MediaDetailsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClickMediaListener implements ActionListener {

    private Media media;

    public ClickMediaListener(Media media) {
        this.media = media;
    }

    /**
     * Displays MediaDetailsView for a specific media clicked
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        MediaDetailsViewModel viewModel = new MediaDetailsViewModel(media);
        MediaDetailsView view = new MediaDetailsView();
        MediaDetailsController controller = new MediaDetailsController(viewModel, view);
        controller.updateView();
    }
}