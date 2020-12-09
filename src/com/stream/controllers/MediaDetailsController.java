package com.stream.controllers;

import com.stream.listeners.BackListener;
import com.stream.listeners.ClearListener;
import com.stream.viewmodels.MediaDetailsViewModel;
import com.stream.views.MediaDetailsView;


public class MediaDetailsController extends BaseController {

    private MediaDetailsViewModel md;
    private MediaDetailsView mdv;

    public MediaDetailsController(MediaDetailsViewModel md, MediaDetailsView mdv) {
        super(md, mdv);
        this.md = md;
        this.mdv = mdv;
    }

    @Override
    public void updateView() {
        mdv.addPlayButton(null);
        mdv.addWatchListButton(null);
        mdv.updateView(md.getMedia(), md.getSampleText());
        mdv.addHomeButton(new ClearListener());
        mdv.addBackButton(new BackListener());
        pageController.setView(mdv.getPanel());
    }
}