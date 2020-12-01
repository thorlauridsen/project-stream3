import models.BaseView;
import models.Media;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class CatalogView extends BaseView {

    private JScrollPane scroll;
    private Catalog c;

    public CatalogView() {
        super();
    }

    public void setCatalog(Catalog c) {
        this.c = c;
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        scroll.setVisible(visible);
    }

    @Override
    public void updateView() {
        updateView(1);
    }

    public void updateView(int size) {

        //TODO: Make this less scuffed

        //TODO: Minimum height
        int heightMulti = 50;
        int height = size * heightMulti;

        mainPanel.setPreferredSize(new Dimension(800, height));

        scroll = new JScrollPane(mainPanel);
        scroll.setSize(new Dimension(800, 600));
        scroll.getVerticalScrollBar().setUnitIncrement(20);

        int rows = size / 6;

        mainPanel.setLayout(new GridLayout(rows, 6, 20, 20));
    }

    public void pack() {
        frame.add(scroll);

        frame.pack();
        frame.setVisible(true);
    }

    public void addMedia(Media m, ActionListener al) {
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

            titleButton.addActionListener(al);

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
