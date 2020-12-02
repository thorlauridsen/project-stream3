package com.stream.models;

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
        this.imageType = "series";
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

    public String toString() {
        String str = "";
        for (String cat : categories) {
            str += " " + cat;
        }
        String seasonStr = "";
        for (Integer seasonNumber : seasonMap.keySet()) {
            int episodeAmount = seasonMap.get(seasonNumber);
            seasonStr += " " + seasonNumber + "-" + episodeAmount;
        }
        return title + " " + rating + " " + yearFrom + "-" + yearTo + str + seasonStr;
    }

    public String yearToString() {
        if (yearFrom == yearTo) {
            return "" + yearFrom;
        } else {
            return yearFrom + "-" + yearTo;
        }
    }
}
