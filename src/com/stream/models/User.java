package com.stream.models;

import java.util.ArrayList;
import java.util.List;


public class User {

    private String name;
    private String pass;
    private List<Media> watchList;
    private boolean isChild;
    private boolean myListToggled;

    public User(String name, String pass, boolean isChild) {
        this.name = name;
        this.pass = pass;
        this.isChild = isChild;

        this.watchList = new ArrayList<>();
        this.myListToggled = false;
    }

    public void addToWatchlist(Media media) {
        if (!watchList.contains(media)) {
            watchList.add(media);
        }
    }

    public void removeFromWatchList(Media media) {
        if (watchList.contains(media)) {
            watchList.remove(media);
        }
    }

    public boolean containsWatchList(Media media) {
        return watchList.contains(media);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return pass;
    }

    public List<Media> getWatchList() {
        return watchList;
    }

    public boolean isChild() {
        return isChild;
    }

    public boolean isMyListToggled() {
        return myListToggled;
    }

    public void setMyListToggled(boolean myListToggled) {
        this.myListToggled = myListToggled;
    }

}
