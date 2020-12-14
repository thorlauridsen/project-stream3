package com.stream.views;

import com.stream.models.ImageButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public abstract class BaseView {

    protected JPanel mainPanel;
    protected JPanel contentPanel;
    protected JToolBar toolBar;
    protected Font standardFont;
    protected Font largeFont;
    protected Font titleFont;

    public BaseView() {
        mainPanel = new JPanel(new BorderLayout());
        contentPanel = new JPanel();
        toolBar = new JToolBar();
        standardFont = new Font("Verdana", Font.PLAIN, 12);
        largeFont = new Font("Verdana", Font.PLAIN, 24);
        titleFont = new Font("Verdana", Font.PLAIN, 30);

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        mainPanel.add(toolBar, BorderLayout.PAGE_START);
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public void addHomeButton(ActionListener al) {
        ImageButton homeButton = new ImageButton(al, "res/images/logo.png");
        toolBar.add(homeButton);
    }
}