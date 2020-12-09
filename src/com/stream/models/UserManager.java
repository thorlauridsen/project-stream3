package com.stream.models;


public class UserManager {

    private static UserManager instance;
    private User currentUser;

    public UserManager() {
        currentUser = new User("Cronval", false, false);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
}
