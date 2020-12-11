package com.stream.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class CatalogView extends BaseView {

    private JScrollPane scroll;
    private JTextField searchField;
    private JPanel leftPanel;
    private List<JCheckBox> categoryBoxList;

    public CatalogView() {
        categoryBoxList = new ArrayList<>();
    }

    public void addSearchField(ActionListener al) {
        searchField = new JTextField(2);
        searchField.addActionListener(al);
        searchField.setFont(new Font("Verdana", Font.PLAIN, 30 ));
        toolBar.add(searchField);
    }

    public void addCategoryButton(String category, ActionListener al) {
        JCheckBox categoryBox = new JCheckBox(category);
        categoryBox.addActionListener(al);
        leftPanel.add(categoryBox);
        categoryBoxList.add(categoryBox);
    }

    public String getSearchQuery() {
        return searchField.getText();
    }

    public List<JCheckBox> getCategoryBoxList() {
        return categoryBoxList;
    }

    public void addClearButton(ActionListener al) {
        JButton clearButton = new JButton("X");
        clearButton.addActionListener(al);
        toolBar.add(clearButton);
    }

    public void addSearchButton(ActionListener al){
        JButton searchButton = new JButton("Search");
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

        for (Component component : contentPanel.getComponents()) {
            toRemove.add(component);
        }
        for(Component component : toRemove) {
            contentPanel.remove(component);
        }
        mainPanel.remove(scroll);
        repaint();
    }

    public void repaint() {
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public void addMyListButton(ActionListener al) {
        JButton myListButton = new JButton("My List");
        myListButton.addActionListener(al);
        toolBar.add(myListButton);
    }
}