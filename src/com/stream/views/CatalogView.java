package com.stream.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class CatalogView extends BaseView {

    private JScrollPane scroll;
    private JTextField searchField;
    private JButton searchButton;
    private List<JRadioButton> categoryButtons = new ArrayList<>();
    private JPanel leftPanel;

    public CatalogView() {
        super();
    }

    public void updateToolBar() {
        searchField = new JTextField(2);
        //searchField.setPreferredSize(new Dimension(30, searchField.getHeight()));
        //toolBar.add(new JToolBar.Separator(new Dimension(1400, 0)));
        toolBar.add(searchField);
    }

    public void addCategoryButton(String s) {
        JRadioButton categoryButton = new JRadioButton(s);
        leftPanel.add(categoryButton);
        categoryButtons.add(categoryButton);
    }

    public String getSearchQuery() {
        return searchField.getText();
    }

    public void addSearchButton(ActionListener al){
        searchButton = new JButton("Search");
        searchButton.addActionListener(al);
        toolBar.add(searchButton);
    }

    public void addCategoryPanel(int categorySize) {
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(categorySize, 1));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,30));

        mainPanel.add(leftPanel, BorderLayout.WEST);
    }

    public void updateView(int mediaSize) {

        scroll = new JScrollPane(contentPanel);

        int cols = 7;
        int rows = (mediaSize / cols) + 1;

        int heightMulti = 260;
        int height = rows * heightMulti;

        contentPanel.setPreferredSize(new Dimension(800, height));

        contentPanel.setLayout(new GridLayout(rows, cols, 10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));

        mainPanel.setPreferredSize(new Dimension(800, height));

        mainPanel.add(scroll, BorderLayout.CENTER);

        scroll.getVerticalScrollBar().setUnitIncrement(20);
    }

    public void addMedia(JPanel panel) {
        contentPanel.add(panel);
    }

    public void clearMedia() {
        List<Component> toRemove = new ArrayList<>();

        for (Component c : contentPanel.getComponents()) {
            toRemove.add(c);
        }
        for(Component c : toRemove) {
            contentPanel.remove(c);
        }
        mainPanel.remove(scroll);
        repaint();
    }

    public void repaint() {
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}