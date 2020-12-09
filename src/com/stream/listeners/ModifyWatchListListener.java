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

    public ModifyWatchListListener(Media media) {
        this.media = media;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserManager userManager = UserManager.getInstance();
        User user = userManager.getCurrentUser();

        if (user != null) {
            if (user.containsWatchList(media)) {
                user.removeFromWatchList(media);
            } else {
                user.addToWatchlist(media);
            }
        }
        MediaDetailsViewModel model = new MediaDetailsViewModel(media);
        MediaDetailsView view = new MediaDetailsView();
        MediaDetailsController mdc = new MediaDetailsController(model, view);
        mdc.updateView();

        PageController pageController = PageController.getInstance();
        pageController.setView(view.getPanel());
    }
}
