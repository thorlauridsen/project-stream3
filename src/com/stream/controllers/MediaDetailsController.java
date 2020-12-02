package controllers;

import listeners.BackListener;
import models.BaseController;
import models.MediaDetails;
import views.MediaDetailsView;

public class MediaDetailsController extends BaseController {

    private MediaDetails md;
    private MediaDetailsView mdv;

    public MediaDetailsController(MediaDetails md, MediaDetailsView mdv) {
        super(md, mdv);
        this.md = md;
        this.mdv = mdv;
        mdv.setMedia(md.getMedia());
        mdv.addStuff(md.getMedia(), md.getSampleText());
        addBackButton();

    }

    public void addBackButton() {
        mdv.addBackButton(new BackListener(mdv));
    }

    public void updateView(){
        mdv.updateView();
    }
}