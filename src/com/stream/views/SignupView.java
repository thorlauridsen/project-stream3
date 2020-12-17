package com.stream.views;

import javax.swing.*;
import java.awt.event.ActionListener;


public class SignupView extends AccountView {

    private JPasswordField passwordAgainField;
    private JCheckBox isChildBox;

    public SignupView() {
        isChildBox = new JCheckBox("Is child?");
        isChildBox.setFont(mediumFont);

        usernameLabelPos = 0;
        usernameFieldPos = 1;
        passwordLabelPos = 2;
        passwordFieldPos = 3;
        submitButtonPos = 7;
    }

    /**
     * Populates contentPanel with passwordAgainLabel and isChildBox
     * The super class updates the rest of the view
     */
    public void updateView() {
        super.updateView();

        JLabel passwordAgainLabel = new JLabel("Confirm password:");
        passwordAgainLabel.setFont(mediumFont);

        constraints.gridy = 4;
        contentPanel.add(passwordAgainLabel, constraints);

        constraints.gridy = 6;
        contentPanel.add(isChildBox, constraints);
    }

    /**
     * Adds passwordAgainField to contentPanel
     * @param al ActionListener for the button
     */
    public void addPasswordAgainField(ActionListener al) {
        passwordAgainField = new JPasswordField();
        passwordAgainField.setFont(mediumFont);
        passwordAgainField.addActionListener(al);
        constraints.gridy = 5;

        contentPanel.add(passwordAgainField, constraints);
    }

    /**
     * Adds addBackButton to contentPanel
     * @param al ActionListener for the button
     */
    public void addBackButton(ActionListener al) {
        JButton backButton = new JButton("Back to login");
        backButton.setFont(mediumFont);
        backButton.addActionListener(al);
        constraints.gridy = 8;

        contentPanel.add(backButton, constraints);
    }

    public boolean isChildBoxSelected() {
        return isChildBox.isSelected();
    }

    public String getPasswordAgain() {
        return passwordAgainField.getText();
    }
}
