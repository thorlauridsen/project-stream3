package com.stream.views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class LoginView extends BaseView {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private GridBagConstraints constraints;

    public LoginView() {
        usernameField = new JTextField();
        usernameField.setFont(largeFont);
        constraints = new GridBagConstraints();
    }

  public void updateView() {
      contentPanel.setLayout(new GridBagLayout());


      mainPanel.add(contentPanel, BorderLayout.CENTER);

      JLabel usernameLabel = new JLabel("Username:");
      usernameLabel.setFont(largeFont);
      JLabel passwordLabel = new JLabel("Password:");
      passwordLabel.setFont(largeFont);


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

      constraints.ipadx = 300;
      constraints.ipady = 20;
      constraints.insets = new Insets(15,0,0,0);
      constraints.fill = GridBagConstraints.HORIZONTAL;

      constraints.gridy = 1;
      contentPanel.add(usernameLabel, constraints);

      constraints.gridy = 2;
      contentPanel.add(usernameField, constraints);

      constraints.gridy = 3;
      contentPanel.add(passwordLabel, constraints);

  }

    public void addLoginButton(ActionListener al) {
        loginButton = new JButton("Login");
        loginButton.addActionListener(al);
        loginButton.setFont(largeFont);
        constraints.insets = new Insets(30,0,0,0);
        constraints.gridy = 5;
        contentPanel.add(loginButton, constraints);
    }

    public void addPasswordField(ActionListener al) {
        passwordField = new JPasswordField();
        passwordField.setFont(largeFont);
        passwordField.addActionListener(al);
        constraints.gridy = 4;
        contentPanel.add(passwordField, constraints);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public void showAlert() {
        JOptionPane.showMessageDialog(null, "Username / password incorrect");
    }
}
