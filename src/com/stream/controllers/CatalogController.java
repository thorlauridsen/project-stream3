package controllers;

import listeners.ClickMediaListener;
import models.BaseController;
import models.Catalog;
import models.Media;
import views.CatalogView;
import java.util.List;

public class CatalogController extends BaseController {

    private Catalog c;
    private CatalogView cv;

    public CatalogController(Catalog c, CatalogView cv) {
        super(c, cv);
        this.c = c;
        this.cv = cv;
        this.cv.setCatalog(this.c);
    }

    @Override
    public void updateView() {
        cv.updateView(c.getMediaList().size());
        setAllMedia();
    }

    public void setAllMedia() {
        List<Media> mediaList = c.getMediaList();

        for (Media media : mediaList) {
            cv.addMedia(media, new ClickMediaListener(cv, media));
        }
        this.cv.pack();
    }
}