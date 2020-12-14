package com.stream.models;


import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private static UserManager instance;
    private User currentUser;
    private List<User> userList;

    public UserManager() {
        userList = new ArrayList<>();
        User user1 = new User("Cronval", "1234", false, false);
        User user2 = new User("Thor", "1234", true, false);

        userList.add(user1);
        userList.add(user2);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Attempt to log in user
     * @return true if login succeeded
     */
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

    /**
     * Handle user logout
     */
    public void logout() {
        currentUser.setMyListToggled(false);
        currentUser = null;
    }

    /**
     * Creates an instance of UserManager if it does not exist yet
     * @return singleton instance of UserManager
     */
    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
}
