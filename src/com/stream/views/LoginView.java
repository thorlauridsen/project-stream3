package com.stream.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends BaseView {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private GridBagConstraints constraints;

    public LoginView() {
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        constraints = new GridBagConstraints();
    }

  public void updateView() {
      contentPanel.setLayout(new GridBagLayout());


      mainPanel.add(contentPanel, BorderLayout.CENTER);

      JLabel usernameLabel = new JLabel("Username:");
      JLabel passwordLabel = new JLabel("Password:");

      constraints.ipadx = 400;
      constraints.ipady = 30;
      constraints.insets = new Insets(15,0,0,0);
      constraints.fill = GridBagConstraints.HORIZONTAL;

      constraints.gridy = 0;
      contentPanel.add(usernameLabel, constraints);

      constraints.gridy = 1;
      contentPanel.add(usernameField, constraints);

      constraints.gridy = 2;
      contentPanel.add(passwordLabel, constraints);

      constraints.gridy = 3;
      contentPanel.add(passwordField, constraints);
  }

    public void addLoginButton(ActionListener al) {
        loginButton = new JButton("Login");
        loginButton.addActionListener(al);
        loginButton.setSize( new Dimension(400, 200));
        constraints.gridy = 4;
        contentPanel.add(loginButton, constraints);
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
