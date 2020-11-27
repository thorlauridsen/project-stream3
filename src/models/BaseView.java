package models;

import javax.swing.*;

public abstract class BaseView {

    protected JFrame frame;
    protected JPanel mainPanel;

    public BaseView() {
        frame = SingletonFrame.getInstance();
        mainPanel = new JPanel();
    }

    public void setVisible(boolean visible) {
        mainPanel.setVisible(visible);
    }
}
