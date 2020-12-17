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

    public boolean containsWatchList(Media media) {
        if (watchList.contains(media)) {
            return true;
        }
        return false;
    }

    public void addToWatchList(Media media) {
        if (!containsWatchList(media)) {
            watchList.add(media);
        }
    }

    public void removeFromWatchList(Media media) {
        if (containsWatchList(media)) {
            watchList.remove(media);
        }
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
