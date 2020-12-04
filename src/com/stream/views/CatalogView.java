package com.stream.views;

import com.stream.models.Media;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class CatalogView extends BaseView {

    private JScrollPane scroll;
    private JTextField searchField;
    private JButton searchButton;
    private List<JRadioButton> categoryButtons = new ArrayList<>();

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
        toolBar.add(categoryButton);
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

    public void updateView(int size) {

        scroll = new JScrollPane(contentPanel);

        int heightMulti = 40;
        int height = size * heightMulti;

        contentPanel.setPreferredSize(new Dimension(800, height));

        int rows = size / 8;
        contentPanel.setLayout(new GridLayout(rows, 8, 20, 20));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));

        mainPanel.setPreferredSize(new Dimension(800, height));

        mainPanel.add(scroll, BorderLayout.CENTER);

        scroll.getVerticalScrollBar().setUnitIncrement(20);
    }

    public void addMedia(Media m, ActionListener al) {
        JPanel mediaPanel = new JPanel();
        mediaPanel.setLayout(new BorderLayout());

        try {

            InputStream is = getClass().getClassLoader().getResourceAsStream(m.getImagePath());
            BufferedImage pic = ImageIO.read(is);
            int width = pic.getWidth();
            int height = pic.getHeight();

            //TODO: Handle max width/height

            JLabel imageLabel = new JLabel();
            imageLabel.setSize(new Dimension(width, height));

            JButton titleButton = new JButton(m.getTitle());
            titleButton.setSize(new Dimension(width, height));

            imageLabel.setIcon(new ImageIcon(pic));
            imageLabel.setSize(new Dimension(width, height));

            titleButton.addActionListener(al);

            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            titleButton.setHorizontalAlignment(JLabel.CENTER);

            mediaPanel.add(imageLabel, BorderLayout.CENTER);
            mediaPanel.add(titleButton, BorderLayout.PAGE_END);

        } catch (Exception e) {
            e.printStackTrace();
        }
        contentPanel.add(mediaPanel);
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
