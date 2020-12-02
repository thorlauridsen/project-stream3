package com.stream.viewmodels;

import com.stream.FileReader;
import com.stream.models.Media;
import java.util.List;


public class Catalog extends BaseViewModel {

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
