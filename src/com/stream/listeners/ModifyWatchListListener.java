package com.stream.listeners;

import com.stream.models.Media;
import com.stream.models.User;
import com.stream.models.UserManager;
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

    /**
     * Add or remove media from user watch list and update the image accordingly
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        UserManager userManager = UserManager.getInstance();
        User user = userManager.getCurrentUser();

        if (user != null) {
            if (user.containsWatchList(media)) {
                user.removeFromWatchList(media);
                mediaDetailsView.updateWatchListButton("res/images/watchListButtonEmpty.png");
            } else {
                user.addToWatchList(media);
                mediaDetailsView.updateWatchListButton("res/images/watchListButton.png");
            }
        }
    }
}
