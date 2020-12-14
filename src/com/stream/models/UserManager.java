package com.stream.models;


import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private static UserManager instance;
    private User currentUser;
    private List<User> userList;

    public UserManager() {
        userList = new ArrayList<>();
        User user = new User("Cronval", "mypassword123", false, false);
        userList.add(user);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean attemptLogin(String username, String password) {
        for (User user : userList) {
            if (user.getName().equalsIgnoreCase(username)) {
                if (user.getPassword().equals(password)) {
                    currentUser = user;
                    return true;
                }
            }
        }
        return false;
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
}
