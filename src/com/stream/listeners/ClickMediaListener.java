package listeners;

import controllers.MediaDetailsController;
import models.BaseListener;
import models.Media;
import models.MediaDetails;
import views.CatalogView;
import views.MediaDetailsView;

import java.awt.event.ActionEvent;

public class ClickMediaListener extends BaseListener {

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