package models;

public class User {

    private boolean isAdmin;
    private boolean isChild;

    public User() {
        this.isAdmin = false;
        this.isChild = false;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isChild() {
        return isChild;
    }
}
