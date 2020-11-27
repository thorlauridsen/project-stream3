import models.BaseView;

import javax.swing.*;
import java.awt.*;

public class MediaDetailsView extends BaseView {

    private MediaDetails md;

    public MediaDetailsView(MediaDetails md) {
        super();

        this.md = md;

        mainPanel.setBackground(Color.green);
        frame.add(mainPanel);

        frame.pack();
        frame.setVisible(true);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
