package com.stream.viewmodels;

import com.stream.FileReader;
import com.stream.models.Media;
import java.util.ArrayList;
import java.util.List;


public class Catalog extends BaseViewModel {

    private FileReader fr;
    private List<Media> mediaList;
    private List<String> categories;

    public Catalog() {
        fr = new FileReader();
        categories = new ArrayList<>();
        mediaList = fr.readAllMedia();
        getAllCategories();
    }

    public List<Media> getMediaList() {

        return mediaList;
    }

    public void setMediaList(List<Media> mediaList) {

        this.mediaList = mediaList;
    }

    public void getAllCategories() {
        for(Media m : mediaList) {
            for (String s : m.getCategories()) {
                if (!categories.contains(s)) {
                    categories.add(s);
                }
            }
        }
    }

    public List<String> getCategories() {
        return categories;
    }
}
