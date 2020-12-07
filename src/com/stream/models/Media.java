package com.stream.models;

import java.io.File;
import java.util.List;


public abstract class Media {

    protected String title;
    protected double rating;
    protected List<String> categories;
    protected String imageType;
    protected String imagePath = null;

    public String getImagePath() {
        if (imagePath == null) {
            imagePath = "res/images/"+imageType+"/"+title+".jpg";
        }
        return imagePath;
    }

    public File getImageFile() {
        File f = new File(getImagePath());
        System.out.println("A " + getImagePath());
        if (f.exists()) {
            return f;
        }
        return null;
    }

    public String getShortTitle() {
        int max = 19;

        if (title.length() > max) {
            return title.substring(0, (max - 3)) + "...";
        }
        return title;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public List<String> getCategories() {
        return categories;
    }

    public abstract String yearToString();
}
