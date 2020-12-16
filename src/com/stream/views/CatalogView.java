package com.stream.views;

import com.stream.controllers.FilterController;
import com.stream.models.ToolBarButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class CatalogView extends BaseView {

    private JScrollPane scroll;
    private JTextField searchField;
    private JPanel categoryPanel;
    private List<JCheckBox> categoryBoxList;
    private JButton logoutButton;
    private JButton myListButton;

    public CatalogView() {
        categoryBoxList = new ArrayList<>();
    }

    /**
     * Creates the searchFiled and adds it to toolBar
     * @param al ActionListener for the button
     */
    public void addSearchField(ActionListener al) {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(1,1));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));
        searchField = new JTextField(2);
        searchField.addActionListener(al);
        searchField.setFont(titleFont);
        searchPanel.add(searchField);
        toolBar.add(searchPanel);
    }

    /**
     * Adds the specific categoryBox to categoryPanel
     * @param category Category to display
     * @param al ActionListener for the button
     */
    public void addCategoryButton(String category, ActionListener al) {

        JCheckBox categoryBox = new JCheckBox(category);
        categoryBox.setFont(standardFont);

        FilterController filterController = FilterController.getInstance();
        if (filterController.getMediaTypes().contains(category)) {
            categoryBox.setForeground(Color.decode("#8bc10b"));
        }
        categoryBox.addActionListener(al);
        categoryPanel.add(categoryBox);
        categoryBoxList.add(categoryBox);
    }

    public String getSearchQuery() {
        return searchField.getText();
    }

    public List<JCheckBox> getCategoryBoxList() {
        return categoryBoxList;
    }

    /**
     * Adds the clearButton to toolBar
     * @param al ActionListener for the button
     */
    public void addClearButton(ActionListener al) {
        ToolBarButton clearButton = new ToolBarButton("X", al, largeFont);
        toolBar.add(clearButton);
    }

    /**
     * Adds the searchButton to toolBar
     * @param al ActionListener for the button
     */
    public void addSearchButton(ActionListener al){
        JButton searchButton = new ToolBarButton("Search", al, largeFont);
        toolBar.add(searchButton);
    }

    /**
     * Adds the myListButton to toolBar
     * @param al ActionListener for the button
     */
    public void addMyListButton(ActionListener al) {
        myListButton = new ToolBarButton("My List", al, largeFont);
        toolBar.add(myListButton);
    }

    /**
     * Adds the userLabel to toolBar
     * @param name Username to display
     */
    public void addUserLabel(String name) {
        JLabel userLabel = new JLabel(name);
        userLabel.setFont(largeFont);
        userLabel.setForeground(Color.decode("#8bc10b"));
        userLabel.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
        toolBar.add(userLabel);
    }

    /**
     * Adds the logoutButton to toolBar
     * @param al ActionListener for the button
     */
    public void addLogoutButton(ActionListener al) {
        logoutButton = new ToolBarButton("Logout", al, largeFont);
        toolBar.add(logoutButton);
    }

    /**
     * Adds the categoryPanel to mainPanel
     * @param categorySize Amount of rows for the grid layout.
     */
    public void addCategoryPanel(int categorySize) {
        categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayout(categorySize, 1));
        categoryPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,30));

        mainPanel.add(categoryPanel, BorderLayout.WEST);
    }

    /**
     * Initially setup the contentPanel as a JScrollPane and adds it to mainPanel
     * @param mediaSize Size used to specify the amount of rows
     */
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

    /**
     * Adds the specific panel to contentPanel
     * @param panel JPanel that gets added
     */
    public void addMedia(JPanel panel) {
        contentPanel.add(panel);
    }

    /**
     * Removes all media from the contentPanel
     */
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

    /**
     * Repaints and revalidates the contentPanel
     */
    public void repaint() {
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}