import models.BaseView;
import models.Media;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.List;

public class CatalogView extends BaseView {

    private JScrollPane scroll;
    private Catalog c;

    public CatalogView(Catalog c) {
        super();
        this.c = c;
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        scroll.setVisible(visible);
    }

    public void updateGUI() {

        //TODO: Make this less scuffed
        mainPanel.setPreferredSize(new Dimension(800, 10000));

        scroll = new JScrollPane(mainPanel);
        scroll.setSize(new Dimension(800, 600));

        mainPanel.setLayout(new GridLayout(34, 6, 20, 20));

        frame.add(scroll);

        List<Media> mediaList = c.getMediaList();

        for (Media m : mediaList) {
            addMedia(m);
        }
        frame.pack();
        frame.setVisible(true);
    }

    public void addMedia(Media m) {
        JPanel mediaPanel = new JPanel();
        mediaPanel.setLayout(new BorderLayout());

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(m.getImagePath());
            BufferedImage pic = ImageIO.read(is);

            int width = pic.getWidth();
            int height = pic.getHeight();

            //TODO: Handle max width/height

            JLabel imageLabel = new JLabel();
            imageLabel.setSize(new Dimension(width, height));

            JButton titleButton = new JButton(m.getTitle());
            titleButton.setSize(new Dimension(width, height));

            imageLabel.setIcon(new ImageIcon(pic));
            imageLabel.setSize(new Dimension(width, height));

            titleButton.addActionListener(
                e -> {
                    setVisible(false);
                    MediaDetailsController mdc = new MediaDetailsController(m);
                }
            );

            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            titleButton.setHorizontalAlignment(JLabel.CENTER);

            mediaPanel.add(imageLabel, BorderLayout.CENTER);
            mediaPanel.add(titleButton, BorderLayout.PAGE_END);

        } catch (Exception e) {
            e.printStackTrace();
        }
        mainPanel.add(mediaPanel);
    }
}
