package com.stream.views;

import com.stream.models.ImageButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


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

    public void addHomeButton(ActionListener al) {
        ImageButton homeButton = new ImageButton(al, "res/images/homeButton.png");
        toolBar.add(homeButton);
    }
}