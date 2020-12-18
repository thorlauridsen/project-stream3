package com.stream.listeners;

import com.stream.views.MediaDetailsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PlayListener implements ActionListener {

    private MediaDetailsView view;

    public PlayListener(MediaDetailsView mediaDetailsView) {
        this.view = mediaDetailsView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (view.getPlayButtonPressed()) {
            view.updatePlayButton("res/images/playButton.jpg");
        } else {
            view.updatePlayButton("res/images/playButtonPressed.jpg");
        }
    }
}
