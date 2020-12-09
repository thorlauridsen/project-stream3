package com.stream.models;


public class UserManager {

    private static UserManager userManager = null;
    private User currentUser;

    public UserManager() {
        currentUser = new User("Cronval", false, false);
    }

    public static UserManager getInstance() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
