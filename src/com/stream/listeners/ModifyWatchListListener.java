package com.stream.listeners;

import com.stream.controllers.MediaDetailsController;
import com.stream.controllers.PageController;
import com.stream.models.Media;
import com.stream.models.User;
import com.stream.models.UserManager;
import com.stream.viewmodels.MediaDetailsViewModel;
import com.stream.views.MediaDetailsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyWatchListListener implements ActionListener {

    private Media media;
    private MediaDetailsView mediaDetailsView;

    public ModifyWatchListListener(Media media, MediaDetailsView mediaDetailsView) {
        this.media = media;
        this.mediaDetailsView = mediaDetailsView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        UserManager userManager = UserManager.getInstance();
        User user = userManager.getCurrentUser();

        if(user != null) {
            if (user.containsWatchList(media)) {
                user.removeFromWatchList(media);
                mediaDetailsView.updateWatchListButton(this, "res/images/watchListButtonEmpty.png");
            } else {
                user.addToWatchlist(media);
                mediaDetailsView.updateWatchListButton(this, "res/images/watchListButton.png");
            }

        } else {
            mediaDetailsView.updateWatchListButton(new ModifyWatchListListener(media, mediaDetailsView), "res/images/watchListButtonEmpty.png");
        }


    }
}
