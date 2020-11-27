import models.Media;
import java.util.List;

public class Catalog {

    private FileReader fr;
    private List<Media> mediaList;

    public Catalog() {
        fr = new FileReader();
        mediaList = fr.readMedia();
    }

    public List<Media> getMediaList() {
        return mediaList;
    }
}
