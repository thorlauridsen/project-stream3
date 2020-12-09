package com.stream.controllers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


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

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("res/images/LimeLogo.png");
            Image pic = ImageIO.read(is);
            frame.setIconImage(pic);
        } catch (Exception ex) {
            System.out.println(ex);
        }
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

    public void repaint() {
        frame.revalidate();
        frame.repaint();
    }
}
