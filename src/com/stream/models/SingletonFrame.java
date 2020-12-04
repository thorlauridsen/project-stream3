package com.stream.models;

import javax.swing.*;


public class SingletonFrame extends JFrame {

    private static SingletonFrame frame = null;

    public static SingletonFrame getInstance() {
        if (frame == null) {
            frame = new SingletonFrame();

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Stream Lime");
            frame.setResizable(true);
            frame.setLocationRelativeTo(null);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        return frame;
    }
}
