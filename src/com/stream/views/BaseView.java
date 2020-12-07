package com.stream.views;

import javax.swing.*;
import java.awt.*;


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

    public abstract void updateToolBar();
}