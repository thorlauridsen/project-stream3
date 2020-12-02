import models.BaseController;
import models.BaseListener;

import java.awt.event.ActionEvent;

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
        mdv.addBackButton(new BackMediaListener(mdv));
    }

    public void updateView(){
        mdv.updateView();
    }
}

class BackMediaListener extends BaseListener {

    public BackMediaListener(MediaDetailsView mdv) {
        super(mdv);
    }

    public void actionPerformed(ActionEvent e) {
        view.setVisible(false);
        Catalog model = new Catalog();
        CatalogView view = new CatalogView();
        CatalogController mdc = new CatalogController(model, view);
        mdc.updateView();
    }
}