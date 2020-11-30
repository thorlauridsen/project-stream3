import models.BaseModel;
import models.Media;

public class MediaDetails extends BaseModel {

    private Media media;

    public MediaDetails(Media media) {
        this.media = media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Media getMedia() {
        return media;
    }
}
