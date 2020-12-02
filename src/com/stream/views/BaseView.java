package com.stream.views;

import com.stream.models.SingletonFrame;
import javax.swing.*;
import java.awt.*;


public abstract class BaseView {

    protected JFrame frame;
    protected JPanel mainPanel;
    protected JPanel contentPanel;
    protected JToolBar toolBar;

    public BaseView() {
        frame = SingletonFrame.getInstance();
        mainPanel = new JPanel(new BorderLayout());
        contentPanel = new JPanel();
        toolBar = new JToolBar();

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        mainPanel.add(toolBar, BorderLayout.PAGE_START);
    }

    public void display() {
        frame.add(mainPanel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public abstract void updateToolBar();

    public void setVisible(boolean visible) {
        mainPanel.setVisible(visible);
    }
}