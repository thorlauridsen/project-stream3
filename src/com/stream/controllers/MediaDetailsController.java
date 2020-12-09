package com.stream.controllers;

import com.stream.listeners.BackListener;
import com.stream.listeners.ClearListener;
import com.stream.listeners.ModifyWatchListListener;
import com.stream.models.Media;
import com.stream.models.User;
import com.stream.models.UserManager;
import com.stream.viewmodels.MediaDetailsViewModel;
import com.stream.views.MediaDetailsView;


public class MediaDetailsController extends BaseController {

    private MediaDetailsViewModel md;
    private MediaDetailsView mediaDetailsView;

    public MediaDetailsController(MediaDetailsViewModel md, MediaDetailsView mediaDetailsView) {
        super(md, mediaDetailsView);
        this.md = md;
        this.mediaDetailsView = mediaDetailsView;
    }

    @Override
    public void updateView() {
        Media media = md.getMedia();

        mediaDetailsView.updatePlayButton(null, "res/images/playButton.jpg");

        UserManager userManager = UserManager.getInstance();
        User user = userManager.getCurrentUser();

        if (user != null) {
            if (user.containsWatchList(media)) {
                mediaDetailsView.addWatchListButton(new ModifyWatchListListener(media, mediaDetailsView), "res/images/watchListButton.png");
            } else {
                mediaDetailsView.addWatchListButton(new ModifyWatchListListener(media, mediaDetailsView), "res/images/watchListButtonEmpty.png");
            }
        } else {
            mediaDetailsView.addWatchListButton(new ModifyWatchListListener(media, mediaDetailsView), "res/images/watchListButtonEmpty.png");
        }

        mediaDetailsView.updateView(media, md.getSampleText());
        mediaDetailsView.addHomeButton(new ClearListener());
        mediaDetailsView.addBackButton(new BackListener());
        pageController.setView(mediaDetailsView.getPanel());
    }
}