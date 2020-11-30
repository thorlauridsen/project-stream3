import models.BaseController;
import models.BaseListener;
import models.Media;

import java.awt.event.ActionEvent;
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

class ClickMediaListener extends BaseListener {

    private Media media;

    public ClickMediaListener(CatalogView cv, Media media) {
        super(cv);
        this.media = media;
    }

    public void actionPerformed(ActionEvent e) {
        view.setVisible(false);
        MediaDetails model = new MediaDetails(media);
        MediaDetailsView view = new MediaDetailsView(model);
        MediaDetailsController mdc = new MediaDetailsController(model, view);
        mdc.updateView();
    }
}