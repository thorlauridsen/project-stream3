import models.BaseController;

public class MediaDetailsController extends BaseController {

    private MediaDetails md;
    private MediaDetailsView mdv;

    public MediaDetailsController(MediaDetails md, MediaDetailsView mdv) {
        super(md, mdv);
        this.md = md;
        this.mdv = mdv;
        mdv.setMedia(md.getMedia());
        mdv.addStuff(md.getMedia(), md.getSampleText());

    }

    public void updateView(){
        mdv.updateView();
    }
}
