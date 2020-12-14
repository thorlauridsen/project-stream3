package com.stream.controllers;

import com.stream.listeners.BackListener;
import com.stream.listeners.ClearListener;
import com.stream.listeners.ModifyWatchListListener;
import com.stream.models.Media;
import com.stream.models.User;
import com.stream.viewmodels.MediaDetailsViewModel;
import com.stream.views.MediaDetailsView;


public class MediaDetailsController extends BaseController {

    private MediaDetailsViewModel viewModel;
    private MediaDetailsView view;

    public MediaDetailsController(MediaDetailsViewModel viewModel, MediaDetailsView view) {
        this.viewModel = viewModel;
        this.view = view;
    }

    /**
     * Populates and displays the view using pageController
     */
    public void updateView() {
        Media media = viewModel.getMedia();

        view.updatePlayButton(null, "res/images/playButton.jpg");

        User user = userManager.getCurrentUser();

        if (user != null) {
            if (user.containsWatchList(media)) {
                view.addWatchListButton(new ModifyWatchListListener(media, view), "res/images/watchListButton.png");
            } else {
                view.addWatchListButton(new ModifyWatchListListener(media, view), "res/images/watchListButtonEmpty.png");
            }
        } else {
            view.addWatchListButton(new ModifyWatchListListener(media, view), "res/images/watchListButtonEmpty.png");
        }

        view.updateView(media, viewModel.getSampleText());
        view.addHomeButton(new ClearListener());
        view.addBackButton(new BackListener(), "res/images/backButton.png");
        pageController.setView(view.getPanel());
    }
}