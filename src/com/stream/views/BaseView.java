package com.stream.views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;


public abstract class BaseView {

    protected JPanel mainPanel;
    protected JPanel contentPanel;
    protected JToolBar toolBar;

    public BaseView() {
        mainPanel = new JPanel(new BorderLayout());
        contentPanel = new JPanel();
        toolBar = new JToolBar();

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        mainPanel.add(toolBar, BorderLayout.PAGE_START);
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public void updateToolBar() {
    }

    public void addHomeButton(ActionListener al) {
        JButton homeButton = new JButton();
        try {
            InputStream is2 = getClass().getClassLoader().getResourceAsStream("res/images/homeButton.png");
            BufferedImage pic = ImageIO.read(is2);
            homeButton.setIcon(new ImageIcon(pic));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        homeButton.addActionListener(al);
        toolBar.add(homeButton);
    }
}