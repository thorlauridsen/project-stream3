package com.stream.models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;


public class MediaPanel {

    private Media media;
    private ActionListener actionListener;

    public MediaPanel(Media media, ActionListener actionListener) {
        this.media = media;
        this.actionListener = actionListener;
    }

    public JPanel getPanel() {
        JPanel mediaPanel = new JPanel();

        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        mediaPanel.setLayout(grid);

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(media.getImagePath());
            BufferedImage img = ImageIO.read(is);
            int width = img.getWidth();
            int height = img.getHeight();

            JButton imageButton = new JButton();
            imageButton.setSize(new Dimension(width, height));

            JButton titleButton = new JButton(media.getShortTitle());
            titleButton.setSize(new Dimension(width, height));

            imageButton.setIcon(new ImageIcon(img));
            imageButton.setSize(new Dimension(width, height));

            titleButton.addActionListener(actionListener);
            imageButton.addActionListener(actionListener);

            imageButton.setHorizontalAlignment(JLabel.CENTER);
            titleButton.setHorizontalAlignment(JLabel.CENTER);

            gbc.fill = GridBagConstraints.WEST;
            gbc.gridx = 0;
            gbc.gridy = 0;

            mediaPanel.add(imageButton, gbc);

            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 1;

            mediaPanel.add(titleButton, gbc);

        } catch (Exception e) {
            e.printStackTrace();
        }

        mediaPanel.addMouseListener(
            new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            }
        );
        return mediaPanel;
    }
}
