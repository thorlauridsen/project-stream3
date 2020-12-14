package com.stream.models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class ImagePanel extends JPanel {

    private String imagePath;

    public ImagePanel(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        InputStream is = getClass().getClassLoader().getResourceAsStream(imagePath);
        try {
            BufferedImage img = ImageIO.read(is);
            g.drawImage(img, 0, 0, this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
