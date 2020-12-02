package com.stream.views;

import com.stream.models.Media;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;


public class CatalogView extends BaseView {

    private JScrollPane scroll;

    public CatalogView() {
        super();
    }

    public void updateToolBar() {
        toolBar.add(new JButton("Button 1"));
    }

    public void updateView(int size) {

        scroll = new JScrollPane(contentPanel);

        int heightMulti = 50;
        int height = size * heightMulti;

        contentPanel.setPreferredSize(new Dimension(800, height));

        int rows = size / 6;
        contentPanel.setLayout(new GridLayout(rows, 6, 20, 20));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));

        updateToolBar();

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
}
