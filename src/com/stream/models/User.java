package com.stream.models;


import java.util.ArrayList;
import java.util.List;

public class User {

    private boolean isAdmin;
    private boolean isChild;
    private List<Media> watchList;
    private String name;

    public User(String name) {
        this.isAdmin = false;
        this.isChild = false;
        this.name = name;
        watchList = new ArrayList<>();
    }

    public void addToWatchlist(Media m) {
        if(!watchList.contains(m)) {
            watchList.add(m);
        }

    }

    public void removeFromWatchList(Media m) {
        if (watchList.contains(m)) {
            watchList.remove(m);
        }
    }

    public boolean containsWatchList(Media m) {
        return watchList.contains(m);
    }

    public List<Media> getWatchList() {
        return watchList;
    }

    public boolean isAdmin() {

        return isAdmin;
    }

    public boolean isChild() {

        return isChild;
    }

}
