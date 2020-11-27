package models;

import javax.swing.*;
import java.awt.*;

public class ScrollFrame extends JFrame {

    public ScrollFrame() throws HeadlessException {
        final JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.red));
        panel.setPreferredSize(new Dimension(800, 600));

        final JScrollPane scroll = new JScrollPane(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout());
        add(scroll);
        setVisible(true);
    }
}
