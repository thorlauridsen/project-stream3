package com.stream.models;

import com.stream.controllers.FilterController;
import com.stream.exceptions.LoginException;
import com.stream.exceptions.SignupException;
import java.util.ArrayList;
import java.util.List;


public class UserManager {

    private static UserManager instance;
    private User currentUser;
    private List<User> userList;

    public UserManager() {
        userList = new ArrayList<>();
        User user1 = new User("Cronval", "1234", false);
        User user2 = new User("Thor", "1234", true);

        userList.add(user1);
        userList.add(user2);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean doesAccountExist(String name) {
        for (User user : userList) {
            if (user.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void createAccount(String name, String pass, boolean isChild) {
        User user = new User(name, pass, isChild);
        userList.add(user);
    }

    public boolean attemptCreateAccount(String name, String pass, String passAgain, boolean isChild) throws SignupException {
        String error;

        if (name != null && pass != null && passAgain != null) {
            if (!name.isEmpty() && !pass.isEmpty() && !passAgain.isEmpty()) {
                if (!doesAccountExist(name)) {
                    if (pass.equalsIgnoreCase(passAgain)) {
                        createAccount(name, pass, isChild);
                        return true;

                    } else {
                        error = "Passwords do not match!";
                    }
                } else {
                    error = "There already exists an account with this username!";
                }
            } else {
                error = "Please fill out the required fields!";
            }
        } else {
            error = "Please fill out the required fields!";
        }
        throw new SignupException(error);
    }

    /**
     * Attempt to log in user
     * @return true if login succeeded
     */
    public boolean attemptLogin(String name, String pass) throws LoginException {
        for (User user : userList) {
            if (user.getName().equalsIgnoreCase(name)) {
                if (user.getPassword().equals(pass)) {
                    currentUser = user;
                    return true;
                }
            }
        }
        throw new LoginException();
    }

    /**
     * Handle user logout
     */
    public void logout() {
        if (currentUser != null) {
            currentUser.setMyListToggled(false);
        }
        currentUser = null;

        FilterController filterController = FilterController.getInstance();
        filterController.resetFilter();
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
