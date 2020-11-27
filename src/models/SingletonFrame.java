package models;

import javax.swing.*;

public class SingletonFrame extends JFrame {

    private static SingletonFrame frame = null;

    public static SingletonFrame getInstance() {
        if (frame == null) {
            frame = new SingletonFrame();
        }
        return frame;
    }
}
