package models;

import java.util.List;

public class Movie extends Media {

    private int year;

    public Movie(String title, double rating, List<String> categories, int year) {
        this.title = title;
        this.rating = rating;
        this.categories = categories;
        this.year = year;
        this.imageType = "movies";
    }

    public String toString() {
        String str = "";
        for (String cat : categories) {
            str = str + " " + cat;
        }
        return title + " " + rating + " " + year + str;
    }

    public int getYear(){
        return year;
    }

    public String yearToString() {
        return "" + year;
    }
}
