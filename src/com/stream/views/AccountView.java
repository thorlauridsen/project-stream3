package com.stream.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AccountView extends BaseView {

    protected JTextField usernameField;
    protected JPasswordField passwordField;
    protected JButton submitButton;
    protected GridBagConstraints constraints;

    protected int usernameLabelPos = 1;
    protected int usernameFieldPos = 2;
    protected int passwordLabelPos = 3;
    protected int passwordFieldPos = 4;
    protected int submitButtonPos = 5;

    public AccountView() {
        usernameField = new JTextField();
        usernameField.setFont(largeFont);
        constraints = new GridBagConstraints();
    }

    /**
     * Populates contentPanel with login and password text fields
     * Adds the contentPanel to mainPanel
     */
    public void updateView() {
        contentPanel.setLayout(new GridBagLayout());
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(largeFont);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(largeFont);

        constraints.ipadx = 300;
        constraints.ipady = 20;
        constraints.insets = new Insets(15,0,0,0);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridy = usernameLabelPos;
        contentPanel.add(usernameLabel, constraints);

        constraints.gridy = usernameFieldPos;
        contentPanel.add(usernameField, constraints);

        constraints.gridy = passwordLabelPos;
        contentPanel.add(passwordLabel, constraints);
    }

    /**
     * Adds submitButton to contentPanel
     * @param al ActionListener for the button
     */
    public void addSubmitButton(ActionListener al, String text) {
        submitButton = new JButton(text);
        submitButton.addActionListener(al);
        submitButton.setFont(largeFont);
        constraints.insets = new Insets(30,0,0,0);
        constraints.gridy = submitButtonPos;
        contentPanel.add(submitButton, constraints);
    }

    /**
     * Adds passwordField to contentPanel
     * @param al ActionListener for the button
     */
    public void addPasswordField(ActionListener al) {
        passwordField = new JPasswordField();
        passwordField.setFont(largeFont);
        passwordField.addActionListener(al);
        constraints.gridy = passwordFieldPos;
        contentPanel.add(passwordField, constraints);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }
}
