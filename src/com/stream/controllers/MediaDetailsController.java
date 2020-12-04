package com.stream.controllers;

import com.stream.listeners.BackListener;
import com.stream.viewmodels.MediaDetails;
import com.stream.views.MediaDetailsView;


public class MediaDetailsController extends BaseController {

    private MediaDetails md;
    private MediaDetailsView mdv;

    public MediaDetailsController(MediaDetails md, MediaDetailsView mdv) {
        super(md, mdv);
        this.md = md;
        this.mdv = mdv;
    }

    @Override
    public void updateView(){
        mdv.updateView(md.getMedia(), md.getSampleText());
        mdv.addBackButton(new BackListener(mdv));
        mdv.display();
    }
}