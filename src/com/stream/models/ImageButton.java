package com.stream.models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;


public class ImageButton extends JButton {

    public ImageButton(ActionListener al, String imagePath) {
        draw(imagePath);
        if (al != null) {
            this.addActionListener(al);
        }
    }

    public void draw(String imagePath) {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(imagePath);
            BufferedImage pic = ImageIO.read(is);
            this.setIcon(new ImageIcon(pic));

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
