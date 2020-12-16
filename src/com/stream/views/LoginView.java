package com.stream.views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;


public class LoginView extends AccountView {

    /**
     * Populates contentPanel with login and password text fields
     * Adds the contentPanel to mainPanel
     */
    @Override
    public void updateView() {
        super.updateView();
        addImageLabel();
    }

    public void addImageLabel() {
        JLabel imageLabel = new JLabel();

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("res/images/logoMedium.png");
            BufferedImage pic = ImageIO.read(is);
            imageLabel.setIcon(new ImageIcon(pic));

        } catch (Exception ex) {
            System.out.println(ex);
        }
        constraints.gridy = 0;
        contentPanel.add(imageLabel, constraints);
    }

    public void addSignUpButton(ActionListener al) {
        JButton signUpButton = new JButton("Create Account");
        signUpButton.setFont(largeFont);
        signUpButton.addActionListener(al);

        constraints.gridy = 6;
        contentPanel.add(signUpButton, constraints);
    }
}
