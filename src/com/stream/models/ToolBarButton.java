package com.stream.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ToolBarButton extends JButton {

    public ToolBarButton(String text, ActionListener al, Font font) {
        super(text);
        this.setFont(font);
        this.addActionListener(al);
        this.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
    }
}
