import models.BaseController;
import models.Media;

public class MediaDetailsController extends BaseController {

    public MediaDetailsController(Media media) {
        super();
        MediaDetails md = new MediaDetails(media);
        MediaDetailsView mdv = new MediaDetailsView(md);
    }
}
