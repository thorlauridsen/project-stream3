import models.BaseView;
import models.Media;

import javax.swing.*;
import java.awt.*;

public class MediaDetailsView extends BaseView {

    private Media media;
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

    public void setMedia(Media media) {
        this.media = media;
    }

    public void updateView() {


    }
}
