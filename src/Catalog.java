import models.BaseModel;
import models.Media;
import java.util.List;

public class Catalog extends BaseModel {

    private FileReader fr;
    private List<Media> mediaList;

    public Catalog() {
        fr = new FileReader();
        mediaList = fr.readAllMedia();
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
    }
}
