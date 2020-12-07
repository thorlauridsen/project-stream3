package com.stream.controllers;

import javax.swing.*;
import java.awt.*;


public class PageController {

    private JFrame frame;
    private Component previousComponent = null;

    private static PageController pageController = null;

    public PageController() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Stream Lime");
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void setView(Component component) {
        if (frame.getContentPane().getComponents().length > 0) {
            previousComponent = frame.getContentPane().getComponent(0);
        }
        frame.getContentPane().removeAll();
        frame.add(component);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    public void goBack() {
        if (previousComponent != null) {
            setView(previousComponent);
        }
    }

    public static PageController getInstance() {
        if (pageController == null) {
            pageController = new PageController();
        }
        return pageController;
    }
}
