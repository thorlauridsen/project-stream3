package models;

import java.util.List;

public abstract class Media {

    protected String title;
    protected double rating;
    protected List<String> categories;
    protected String imagePath;

    public String getImagePath() {
        return imagePath;
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
}
