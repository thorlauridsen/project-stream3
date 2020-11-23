package models;

import java.util.HashMap;
import java.util.List;

public class Series extends Media {

    private int yearFrom;
    private int yearTo;
    private HashMap<Integer, Integer> seasonMap;

    public Series(String title, double rating, List<String> categories, int yearFrom, int yearTo, HashMap<Integer, Integer> seasonMap) {
        this.title = title;
        this.rating = rating;
        this.categories = categories;
        this.yearFrom =  yearFrom;
        this.yearTo = yearTo;
        this.seasonMap = seasonMap;
    }

    public int getYearFrom() {
        return yearFrom;
    }

    public int getYearTo() {
        return yearTo;
    }

    public HashMap<Integer, Integer> getSeasonMap() {
        return seasonMap;
    }
}
